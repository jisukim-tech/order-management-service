package com.study.order_management_service.discount;

import com.study.order_management_service.member.Grade;
import com.study.order_management_service.member.Member;

public class FixedDiscountPolicy implements DiscountPolicy {
    private int fixedDiscount = 1000;

    @Override
    public int discount(Member member, int itemPrice) {
        if (member.getGrade() == Grade.VIP) {
            return fixedDiscount;
        } else {
            return 0;
        }
    }
}
