package com.MyMallPositioning.common_utils;

import lombok.Getter;

@Getter
public enum ResultCode {
    SUCCESS(200),
    ERROR(500);

    private final int code;

    ResultCode(int code) {
        this.code = code;
    }

}