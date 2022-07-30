package com.skypyb.security.util;

import java.io.Serializable;

public final class Result<T> implements Serializable {
    
    private Integer code = ResultCode.SUCCESS.getCode();
    private String message;
    private T data;

    public Integer getCode() {
        return code;
    }

    public Result<T> code(final Integer code) {
        this.code = code;
        return this;
    }

    public Result<T> code(ResultCode resultCode) {
        this.code = resultCode.getCode();
        this.message = resultCode.getMessage();
        return this;
    }

    public Boolean succeeded() {
        return ResultCode.SUCCESS.getCode().equals(this.getCode());
    }

    public String getMessage() {
        return message;
    }

    public Result<T> message(String message) {
        this.message = message;
        return this;
    }

    public static <T> Result<T> success() {
        Result<T> result = new Result<T>();
        result.code(ResultCode.SUCCESS.getCode());
        result.message(ResultCode.SUCCESS.getMessage());
        return result;
    }

    public static <T> Result<T> error() {
        Result<T> result = new Result<T>();
        result.code(ResultCode.ERROR.getCode());
        result.message(ResultCode.ERROR.getMessage());
        return result;
    }

    public Result<T> custom(Integer code, String message) {
        this.code = code;
        this.message = message;
        return this;
    }

    public T getData() {
        return data;
    }

    public Result<T> data(T data) {
        this.data = data;
        return this;
    }
}