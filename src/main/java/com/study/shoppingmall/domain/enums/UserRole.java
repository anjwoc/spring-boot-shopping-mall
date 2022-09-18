package com.study.shoppingmall.domain.enums;

import lombok.Data;

public enum UserRole {
    GUEST("guest"),
    USER("user"),
    ADMIN("admin");

    private String role;

    UserRole(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}
