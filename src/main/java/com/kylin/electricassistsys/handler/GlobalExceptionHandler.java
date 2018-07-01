package com.kylin.electricassistsys.handler;

import com.kylin.electricassistsys.entity.ProcessResult;
import com.kylin.electricassistsys.exception.AppException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Threecolors on 2018/1/10.
 */
@ControllerAdvice
public class GlobalExceptionHandler
{
    //添加全局异常处理流程，根据需要设置需要处理的异常
    @ResponseBody
    @ExceptionHandler(value = BindException.class)
    public Object BindExceptionHandler(HttpServletRequest request, BindException exception) throws Exception
    {
        ProcessResult processResult = new ProcessResult();
        //解析原错误信息，封装后返回，此处返回非法的字段名称，原始值，错误信息
        for (FieldError error : exception.getBindingResult().getFieldErrors())
        {
            if (error.getDefaultMessage().contains("java.lang.NumberFormatException"))
            {
                error = new FieldError(error.getObjectName(), error.getField(), "数据不正确");
            }

            processResult.getFieldErrors().add(error);
        }

        return processResult;
    }

    @ExceptionHandler(value = AppException.class)
    public Object AppExceptionHandler(AppException exception) throws Exception
    {
        ProcessResult processResult = new ProcessResult();
        processResult.setMessage(exception.getMessage());
        processResult.setSuccess(false);
        return processResult;
    }

    @ExceptionHandler(value = Exception.class)
    public Object AuthenticationExceptionHandler(Exception exception) throws Exception
    {
        ProcessResult processResult = new ProcessResult();
        processResult.setMessage(exception.getMessage());
        processResult.setSuccess(false);
        return processResult;
    }
}
