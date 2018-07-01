package com.kylin.electricassistsys.entity;

import org.springframework.validation.FieldError;

import java.util.ArrayList;
import java.util.List;

public class ProcessResult
{

    private boolean success;

    private int count;

    private String message = "";

    private List<FieldError> fieldErrors = new ArrayList<>();

    public boolean isSuccess()
    {
        return success;
    }

    public void setSuccess(boolean success)
    {
        this.success = success;
    }

    public int getCount()
    {
        return count;
    }

    public void setCount(int count)
    {
        this.count = count;
    }

    public String getMessage()
    {
        return message;
    }

    public void setMessage(String message)
    {
        this.message = message;
    }

    public List<FieldError> getFieldErrors()
    {
        return fieldErrors;
    }

    public void setFieldErrors(List<FieldError> fieldErrors)
    {
        this.fieldErrors = fieldErrors;
    }
}
