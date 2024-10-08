package com.study.order_management_service.order;

import com.study.order_management_service.AppConfig;
import com.study.order_management_service.member.Grade;
import com.study.order_management_service.member.Member;
import com.study.order_management_service.member.MemberService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

class OrderServiceTest {
    MemberService memberService;
    OrderService orderService;

    @BeforeEach
    void beforeEach() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        memberService = applicationContext.getBean("memberService", MemberService.class);
        orderService = applicationContext.getBean("orderService", OrderService.class);
    }

    @Test
    @DisplayName("주문을 생성할 수 있어야 한다.")
    void createOrder() {
        Long memberId = 1L;

        //given
        Member member = new Member(memberId, "memberA", Grade.VIP);

        //when
        memberService.join(member);
        Order order = orderService.createOrder(memberId, "itemA", 10000);

        //then
        assertThat(order.getDiscountAmount()).isEqualTo(1000);
    }
}