package com.study.order_management_service.bean;

import com.study.order_management_service.AppConfig;
import com.study.order_management_service.member.MemberService;
import com.study.order_management_service.member.MemberServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

public class ApplicationContextBasicBeanFindTest {
    AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("이름과 인터페이스 타입으로 빈을 조회할 수 있어야 한다.")
    void findBeanByNameAndInterfaceType() {
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }

    @Test
    @DisplayName("인터페이스 타입으로 빈을 조회할 수 있어야 한다.")
    void findBeanByType() {
        MemberService memberService = applicationContext.getBean(MemberService.class);
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }

    @Test
    @DisplayName("구현 클래스 타입으로 빈을 조회할 수 있어야 한다.")
    void findBeanByNameAndConcreteType() {
        MemberService memberService = applicationContext.getBean("memberService", MemberServiceImpl.class);
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }

    @Test
    @DisplayName("존재하지 않는 이름으로 빈을 조회한 경우 NoSuchBeanDefinitionException이 발생해야 한다.")
    void findBeanByInvalidname() {
        org.junit.jupiter.api.Assertions.assertThrows(NoSuchBeanDefinitionException.class, () -> {
            applicationContext.getBean("invalidName", MemberService.class);
        });
    }
}
