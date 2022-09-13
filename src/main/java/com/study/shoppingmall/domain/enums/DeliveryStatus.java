package com.study.shoppingmall.domain.enums;

public enum DeliveryStatus {
    READY("배송준비"),
    PENDING("배송대기"),
    START("배송시작"),
    INPROGRESS("배송중"),
    COMPLETE("배송완료");

    private String status;

    DeliveryStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
