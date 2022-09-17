package com.study.shoppingmall.domain.enums;

public enum OrderStatus {
    COMPLETE("결제완료"),
    READY("결제대기"),
    CANCLE("결제취소"),
    REFUND("환불"),
    SHIPPING("배송중");

    private String status;

    OrderStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
