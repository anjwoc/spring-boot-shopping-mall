package com.study.shoppingmall.dto;

import com.study.shoppingmall.domain.enums.UserRole;
import com.study.shoppingmall.domain.user.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Getter
@NoArgsConstructor
public class UserRequestDto {
    private String email;
    private String username;
    private Integer age;
    private String password;
    private String address;
    private UserRole role;

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
