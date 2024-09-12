package com.algoriant.product.jwtUtill;

import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serializable;

@Component

public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint,Serializable{

    public void commence(HttpServletRequest request,
                         HttpServletResponse response,
                         javax.naming.AuthenticationException authenticationException) throws IOException {

        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized");
    }
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, org.springframework.security.core.AuthenticationException authException) throws IOException, ServletException {

    }
}
