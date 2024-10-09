package com.study.order_management_service.bean;

import com.study.order_management_service.member.MemberRepository;
import com.study.order_management_service.member.MemoryMemberRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ApplicationContextSameTypeBeanFindTest {
    AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(SameTypeBeanConfig.class);

    @Test
    @DisplayName("타입으로 조회 시 타입이 동일한 빈이 둘 이상인 경우 NoUniqueBeanDefinitionException이 발생해야 한다.")
    void findBeanBySameType() {
        assertThrows(NoUniqueBeanDefinitionException.class, () ->
                                applicationContext.getBean(MemberRepository.class));
    }

    @Test
    @DisplayName("이름과 타입으로 빈을 조회할 수 있어야 한다.")
    void findBeanByName() {
        MemberRepository memberRepository = applicationContext.getBean("memberRepository1", MemberRepository.class);
        assertThat(memberRepository).isInstanceOf(MemberRepository.class);
    }

    @Test
    @DisplayName("특정 타입 빈을 모두 조회할 수 있어야 한다.")
    void findAllBeanByType() {
        Map<String, MemberRepository> beansOfType = applicationContext.getBeansOfType(MemberRepository.class);

        System.out.println("beansOfType = " + beansOfType);

        for (String key : beansOfType.keySet()) {
            System.out.println("key = " + key + " value = " + beansOfType.get(key));
            assertThat(beansOfType.size()).isEqualTo(2);
        }
    }

    @Configuration
    static class SameTypeBeanConfig {

        @Bean
        public MemberRepository memberRepository1() {
            return new MemoryMemberRepository();
        }

        @Bean
        public MemberRepository memberRepository2() {
            return new MemoryMemberRepository();
        }
    }
}
