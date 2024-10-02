package com.study.order_management_service.order;

public class Order {
    private Long memberId;
    private String itemName;
    private int itemPrice;
    private int discountAmount;

    public Order(Long memberId, String itemName, int itemPrice, int discountAmount) {
        this.memberId = memberId;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.discountAmount = discountAmount;
    }

    public int getDiscountAmount() {
        return discountAmount;
    }

    @Override
    public String toString() {
        return "Order{" +
                "memberId=" + memberId +
                ", itemName='" + itemName + '\'' +
                ", itemPrice=" + itemPrice +
                ", discountAmount=" + discountAmount +
                '}';
    }
}
