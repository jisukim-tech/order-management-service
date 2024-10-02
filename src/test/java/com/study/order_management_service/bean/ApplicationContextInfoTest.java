package com.study.order_management_service.bean;

import com.study.order_management_service.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextInfoTest {
    AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("모든 스프링 빈이 조회되어야 한다.")
    void findAllBeans() {
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();

        for (String beanDefinitionName : beanDefinitionNames) {
            Object bean = applicationContext.getBean(beanDefinitionName);
            System.out.println("name=" + beanDefinitionName + " object=" + bean);
        }
    }

    @Test
    @DisplayName("직접 등록한 애플리케이션 빈이 조회되어야 한다.")
    void findApplicationBeans() {
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();

        for (String beanDefinitionName : beanDefinitionNames) {
            BeanDefinition beanDefinition = applicationContext.getBeanDefinition(beanDefinitionName);

            if (beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION) {
                Object bean = applicationContext.getBean(beanDefinitionName);
                System.out.println("name=" + beanDefinitionName + " object=" + bean);
            }
        }
    }
}
