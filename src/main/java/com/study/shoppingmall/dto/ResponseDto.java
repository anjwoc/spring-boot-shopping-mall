package com.study.shoppingmall.dto;

import com.study.shoppingmall.utils.ResponseStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ResponseDto<T> {
    private final ResponseStatus status;
    private final T message;
    private final T data;
}
