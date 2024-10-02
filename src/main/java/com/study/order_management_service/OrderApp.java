package com.study.order_management_service;

import com.study.order_management_service.member.Grade;
import com.study.order_management_service.member.Member;
import com.study.order_management_service.member.MemberService;
import com.study.order_management_service.order.Order;
import com.study.order_management_service.order.OrderService;

public class OrderApp {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
        OrderService orderService = appConfig.orderService();

        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(1L, "itemA", 20000);

        System.out.println("order = " + order);
    }
}
