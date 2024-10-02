package com.study.order_management_service.discount;

import com.study.order_management_service.member.Grade;
import com.study.order_management_service.member.Member;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class FixedDiscountPolicyTest {
    FixedDiscountPolicy discountPolicy = new FixedDiscountPolicy();

    @Test
    @DisplayName("VIP 회원은 1000원 할인이 적용되어야 한다.")
    void fixedDiscountForVIP() {
        Long memberId = 1L;
        int itemPrice = 10000;

        //given
        Member member = new Member(memberId, "memberVIP", Grade.VIP);

        //when
        int discountAmount = discountPolicy.discount(member, itemPrice);

        //then
        assertThat(discountAmount).isEqualTo(1000);
    }

    @Test
    @DisplayName("일반 회원은 할인이 적용되지 않아야 한다.")
    void fixedDiscountForBASIC() {
        Long memberId = 2L;
        int itemPrice = 10000;

        //given
        Member member = new Member(memberId, "memberBASIC", Grade.BASIC);

        //when
        int discountAmount = discountPolicy.discount(member, itemPrice);

        //then
        assertThat(discountAmount).isEqualTo(0);
    }
}