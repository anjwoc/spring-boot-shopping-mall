package com.study.shoppingmall.dto;


import lombok.Data;

@Data
public class UserSearchCondition {
    private String username;
    private Integer ageGoe;
    private Integer ageLoe;
    private Integer balanceGoe;
    private Integer balanceLoe;
}
