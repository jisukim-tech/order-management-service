package com.study.order_management_service.discount;

import com.study.order_management_service.member.Grade;
import com.study.order_management_service.member.Member;

public class RateDiscountPolicy implements DiscountPolicy {
    private int discountPercent = 10;

    @Override
    public int discount(Member member, int itemPrice) {
        if (member.getGrade() == Grade.VIP) {
            return itemPrice * discountPercent / 100;
        } else {
            return 0;
        }
    }
}
