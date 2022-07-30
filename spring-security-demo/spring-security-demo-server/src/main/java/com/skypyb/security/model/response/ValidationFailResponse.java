package com.skypyb.security.model.response;


import com.skypyb.security.exception.RequestValidationException;
import com.skypyb.security.util.Result;


/**
 * 数据效验失败时返回的响应
 */
public class ValidationFailResponse extends ResultResponse {

    public ValidationFailResponse(Result result) {
        super(result);
    }

    public static ValidationFailResponse from(RequestValidationException e) {
        return new ValidationFailResponse(new Result().custom(e.getCode(), e.getMessage()));
    }

}
