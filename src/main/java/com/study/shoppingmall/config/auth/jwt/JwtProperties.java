package com.study.shoppingmall.config.auth.jwt;

public interface JwtProperties {
    String SECRET = "anjwoc";
    String TOKEN_PREFIX = "Bearer ";
    String HEADER_STRING = "Authorization";

    int EXPIRATION_TIME = 864000000; // 10일(1/1000초)
}
