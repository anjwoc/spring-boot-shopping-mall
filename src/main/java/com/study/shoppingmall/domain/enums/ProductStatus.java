package com.study.shoppingmall.domain.enums;

public enum ProductStatus {
    SOLDOUT("품절"),
    STOP("판매중지"),
    SALE("판매중");

    private String status;

    ProductStatus(String status) {
        this.status = status;
    }

    public String getValue() {
        return status;
    }
}
