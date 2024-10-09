package com.study.order_management_service.bean;

import com.study.order_management_service.discount.DiscountPolicy;
import com.study.order_management_service.discount.FixedDiscountPolicy;
import com.study.order_management_service.discount.RateDiscountPolicy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ApplicationContextExtendedFindTest {
    AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(TestConfig.class);

    @Test
    @DisplayName("자식이 둘 이상인 부모 타입으로 조회한 경우 NoUniqueBeanDefinitionException이 발생해야 한다.")
    void findBeanBySameParentType() {
        assertThrows(NoUniqueBeanDefinitionException.class, () ->
                                applicationContext.getBean(DiscountPolicy.class));
    }

    @Test
    @DisplayName("빈 이름과 부모 타입으로 빈을 조회할 수 있어야 한다.")
    void findBeanByParentTypeAndBeanName() {
        DiscountPolicy rateDiscountPolicy = applicationContext.getBean("rateDiscountPolicy", DiscountPolicy.class);
        assertThat(rateDiscountPolicy).isInstanceOf(RateDiscountPolicy.class);
    }

    @Test
    @DisplayName("특정 하위 타입으로 빈을 조회할 수 있어야 한다.")
    void findBeanBySubType() {
        RateDiscountPolicy rateDiscountPolicy = applicationContext.getBean("rateDiscountPolicy", RateDiscountPolicy.class);
        assertThat(rateDiscountPolicy).isInstanceOf(RateDiscountPolicy.class);
    }

    @Test
    @DisplayName("부모 타입으로 모든 하위 타입 빈을 조회할 수 있어야 한다.")
    void findAllBeanByParentType() {
        Map<String, DiscountPolicy> beansOfType = applicationContext.getBeansOfType(DiscountPolicy.class);

        System.out.println("beansOfType = " + beansOfType);

        for (String key : beansOfType.keySet()) {
            System.out.println("key = " + key + " value = " + beansOfType.get(key));
            assertThat(beansOfType.size()).isEqualTo(2);
        }
    }

    @Test
    @DisplayName("Object 타입으로 모든 하위 타입 빈을 조회할 수 있어야 한다.")
    void findAllBeanByObjectType() {
        Map<String, Object> beansOfType = applicationContext.getBeansOfType(Object.class);

        for (String key : beansOfType.keySet()) {
            System.out.println("key = " + key + " value = " + beansOfType.get(key));
        }
    }

    @Configuration
    static class TestConfig {

        @Bean
        public DiscountPolicy rateDiscountPolicy() {
            return new RateDiscountPolicy();
        }

        @Bean
        public DiscountPolicy fixedDiscountPolicy() {
            return new FixedDiscountPolicy();
        }
    }
}
