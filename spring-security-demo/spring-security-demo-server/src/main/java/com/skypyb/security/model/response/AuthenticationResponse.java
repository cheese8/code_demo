package com.skypyb.security.model.response;

import com.skypyb.security.util.Result;

/**
 * 认证成功响应
 */
public class AuthenticationResponse extends ResultResponse {

    public AuthenticationResponse(String message) {
        super(new Result().custom(200, message));
    }
}
