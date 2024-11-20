package com.MyMallPositioning.common_utils;

import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;
import java.util.HashMap;
import java.util.Map;

/**
 * 统一返回结果的类
 */

@Data
@Builder
public class R {

    @ApiModelProperty(value = "是否成功")
    private Boolean success;

    @ApiModelProperty(value = "返回码")
    private Integer code;

    @ApiModelProperty(value = "返回消息")
    private String message;

    @ApiModelProperty(value = "消息细节")
    private String details;

    @ApiModelProperty(value = "返回数据")
    @Builder.Default
    private Map<String, Object> data = new HashMap<>();

    // 静态方法返回成功的结果
    public static R ok() {
        return R.builder()
                .success(true)
                .code(ResultCode.SUCCESS.getCode())
                .message("成功")
                .build();
    }

    // 静态方法返回失败的结果
    public static R error() {
        return R.builder()
                .success(false)
                .code(ResultCode.ERROR.getCode())
                .message("失败")
                .build();
    }

    // 链式调用方法
    public R success(Boolean success) {
        this.success = success;
        return this;
    }

    public R message(String message) {
        this.message = message;
        return this;
    }

    public R details(String details) {
        this.details = details;
        return this;
    }

    public R code(Integer code) {
        this.code = code;
        return this;
    }

    public R data(String key, Object value) {
        this.data.put(key, value);
        return this;
    }

    public R data(Map<String, Object> map) {
        this.data.putAll(map);
        return this;
    }
}
