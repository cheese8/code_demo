package com.skypyb.security.model.response;

import com.skypyb.security.exception.SecurityAuthException;
import com.skypyb.security.util.Result;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.AuthenticationException;

public class AuthenticationFailResponse extends ResultResponse {

    public AuthenticationFailResponse(Result result) {
        super(result);
    }

    public static AuthenticationFailResponse asResponse(AuthenticationException e) {
        AuthenticationFailResponse unauthorized;

        if (e instanceof InternalAuthenticationServiceException) {
            e = (AuthenticationException) e.getCause();
        }

        if (e instanceof SecurityAuthException) {
            SecurityAuthException ex = (SecurityAuthException) e;
            unauthorized = new AuthenticationFailResponse(new Result().custom(ex.getCode(), ex.getMessage()));
        } else if (e instanceof DisabledException) {
            unauthorized = new AuthenticationFailResponse(new Result().custom(401, "User is disabled!"));
        } else if (e instanceof BadCredentialsException) {
            unauthorized = new AuthenticationFailResponse(new Result().custom(401, "Wrong credentials!"));
        } else {
            unauthorized = new AuthenticationFailResponse(new Result().custom(401, "Unauthorized"));
        }
        return unauthorized;
    }

}
