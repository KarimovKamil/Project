package ru.itis.inform.exceptions;

import org.springframework.security.core.AuthenticationException;

/**
 * 30.10.2016.
 *
 * @author Maxim Romanov
 */
public class TokenAuthenticationException extends AuthenticationException {
    public TokenAuthenticationException(String msg) {
        super(msg);
    }
}
