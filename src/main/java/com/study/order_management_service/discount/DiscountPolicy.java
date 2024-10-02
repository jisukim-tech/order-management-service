package com.study.order_management_service.discount;

import com.study.order_management_service.member.Member;

public interface DiscountPolicy {

    /**
     * @return 할인액
     */
    int discount(Member member, int itemPrice);
}
