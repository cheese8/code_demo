package com.skypyb.security.filter;

import com.skypyb.security.model.response.AuthenticationFailResponse;
import com.skypyb.security.util.ResponseUtil;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AuthenticationFailedEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException {
        ResponseUtil.printAndFlush(httpServletResponse, AuthenticationFailResponse.asResponse(e).toJson(), "application/json; charset=utf-8");
    }
}
