package com.kylin.electricassistsys.controller;

import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Threecolors on 2018/1/26.
 */
@Controller
public class DefaultErrorController implements ErrorController
{
    private static final String ERROR_PATH = "/error";

    @RequestMapping(value=ERROR_PATH)
    public String handleError(HttpServletRequest request, HttpServletResponse response,Model model)
    {
        String msg;
        String url = "error";
        String orUrl = request.getHeader("Referer");
        if(orUrl.contains("login"))
        {
            url = "login";
        }
        int status = response.getStatus();
        switch (status)
        {
            case 404:
                msg ="Sorry..页面没有找到！";
                break;
            case 403:
                msg = "Sorry..您无权访问！";
                break;
            default:
                msg="Sorry..系统错误！";
        }

        model.addAttribute("msg",msg);
        return url;
    }

    @Override
    public String getErrorPath()
    {
        return ERROR_PATH;
    }
}
