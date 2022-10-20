package com.study.shoppingmall.domain.user.dto;

import com.study.shoppingmall.domain.enums.UserRole;
import com.study.shoppingmall.domain.user.User;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class LoginRequestDto {
    private String email;
    private String password;

    public User toEntity() {
        return User.builder()
                .email(email)
                .password(password)
                .build();
    }
}
