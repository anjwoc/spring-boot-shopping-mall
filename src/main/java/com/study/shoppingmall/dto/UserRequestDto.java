package com.study.shoppingmall.dto;

import com.study.shoppingmall.domain.enums.UserRole;
import com.study.shoppingmall.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserRequestDto {
    private String email;
    private String username;
    private Integer age;
    private String password;
    private String address;
    private UserRole role;

    @Builder
    public UserRequestDto(String email, String username, Integer age, String password, String address, UserRole role) {
        this.email = email;
        this.username = username;
        this.age = age;
        this.password = password;
        this.address = address;
        this.role = role;
    }

    public User toEntity() {
        return User.builder()
                .email(email)
                .username(username)
                .age(age)
                .password(password)
                .address(address)
                .role(role)
                .build();
    }
}
