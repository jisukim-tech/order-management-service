package com.study.order_management_service.order;

public interface OrderService {
    Order createOrder(Long memberId, String itemName, int itemPrice);
}
