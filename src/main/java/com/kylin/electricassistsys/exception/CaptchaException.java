package com.kylin.electricassistsys.exception;

import org.springframework.security.core.AuthenticationException;

/**
 * Created by Threecolors on 2018/1/24.
 */
public class CaptchaException extends AuthenticationException
{
    public  CaptchaException(String errorMessage)
    {
        super(errorMessage);
    }
}
