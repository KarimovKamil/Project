package ru.itis.inform.security;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 30.10.2016.
 *
 * @author Maxim Romanov
 */
public class TokenAuthenticationEntryPoint implements AuthenticationEntryPoint {
    /**Gonna use this method when given token is incorrect*/
    @Override
    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        httpServletResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Authentication token was either missing or invalid");
    }
}
