package com.kylin.electricassistsys.exception;

import org.springframework.security.core.AuthenticationException;

/**
 * Created by Threecolors on 2018/1/31.
 */
public class AuthoritySysException extends AuthenticationException
{
    public  AuthoritySysException(String errorMessage)
    {
        super(errorMessage);
    }
}