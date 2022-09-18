package com.study.shoppingmall.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserDto {
    private String email;

    private String username;

    private Integer age;
    private String address;
    private Integer balance;

    @QueryProjection
    public UserDto(String email, String username, Integer age, String address, Integer balance){
        this.email = email;
        this.username = username;
        this.age = age;
        this.address = address;
        this.balance = balance;
    }
}
