package com.study.shoppingmall.dto;

import com.study.shoppingmall.domain.enums.UserRole;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class LoginRequestDto {
    private String uesrname;
    private String password;
}
