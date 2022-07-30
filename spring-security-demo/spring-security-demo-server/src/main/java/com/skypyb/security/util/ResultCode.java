package com.skypyb.security.util;

import java.util.LinkedHashMap;
import java.util.Map;

public enum ResultCode {
    
    SUCCESS(200, "SUCCESS"),
    ERROR(999, "ERROR");
    
    private static Map<Integer, ResultCode> map = new LinkedHashMap<>();

    static {
        for (ResultCode resultCode : ResultCode.values()) {
            map.put(resultCode.getCode(), resultCode);
        }
    }

    public static ResultCode of(final Integer code) {
        return map.get(code);
    }

    private Integer code;
    private String message;

    private ResultCode(final Integer code, final String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public ResultCode code(final Integer code) {
        this.code = code;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public ResultCode message(final String message) {
        this.message = message;
        return this;
    }
    
}
