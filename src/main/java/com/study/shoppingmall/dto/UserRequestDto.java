package com.study.shoppingmall.dto;

import com.study.shoppingmall.config.CorsConfig;
import com.study.shoppingmall.config.SecurityConfig;
import com.study.shoppingmall.domain.enums.UserRole;
import com.study.shoppingmall.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

@Getter
@NoArgsConstructor
public class UserRequestDto {
    SecurityConfig config = new SecurityConfig(new CorsConfig());

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
                .password(config.getPasswordEncoder().encode(password))
                .address(address)
                .role(role)
                .build();
    }
}
