package com.study.order_management_service.member;

import com.study.order_management_service.AppConfig;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MemberServiceTest {
    MemberService memberService;

    @BeforeEach
    public void beforEach() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
    }

    @Test
    @DisplayName("회원 가입 후 해당 회원을 조회할 수 있어야 한다.")
    void join() {
        //given
        Member member = new Member(1L, "memberA", Grade.VIP);

        //when
        memberService.join(member);
        Member foundMember = memberService.findMember(1L);

        //then
        assertThat(member).isEqualTo(foundMember);
    }
}