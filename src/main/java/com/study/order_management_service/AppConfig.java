package com.study.order_management_service;

import com.study.order_management_service.discount.DiscountPolicy;
import com.study.order_management_service.discount.FixedDiscountPolicy;
import com.study.order_management_service.discount.RateDiscountPolicy;
import com.study.order_management_service.member.MemberRepository;
import com.study.order_management_service.member.MemberService;
import com.study.order_management_service.member.MemberServiceImpl;
import com.study.order_management_service.member.MemoryMemberRepository;
import com.study.order_management_service.order.OrderService;
import com.study.order_management_service.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(discountPolicy(), memberRepository());
    }
}
