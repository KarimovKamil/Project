package ru.itis.inform.exceptions;

import org.springframework.security.core.AuthenticationException;

/**
 * Created by Kamil Karimov on 22.11.2016.
 */
public class PermissionException extends AuthenticationException {
    public PermissionException(String msg) {
        super(msg);
    }
}
