package com.study.shoppingmall.utils;

import com.study.shoppingmall.dto.ResponseDto;

public class ResponseUtil {
    public static <T>ResponseDto<T> SUCCESS(String message, T data) {
        return new ResponseDto(ResponseStatus.SUCCESS, message, data);
    }

    public static <T>ResponseDto<T> FAILURE(String message, T data) {
        return new ResponseDto(ResponseStatus.FAILURE, message, data);
    }

    public static <T>ResponseDto<T> ERROR(String message, T data) {
        return new ResponseDto(ResponseStatus.ERROR, message, data);
    }
}
