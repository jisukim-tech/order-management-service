package com.study.order_management_service;

import com.study.order_management_service.member.Grade;
import com.study.order_management_service.member.Member;
import com.study.order_management_service.member.MemberService;

public class MemberApp {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();

        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member foundMember = memberService.findMember(1L);

        System.out.println("new member = " + member.getName());
        System.out.println("found member = " + foundMember.getName());
    }
}
