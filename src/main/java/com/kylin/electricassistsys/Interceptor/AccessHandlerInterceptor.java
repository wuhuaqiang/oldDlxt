package com.kylin.electricassistsys.Interceptor;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.kylin.electricassistsys.common.AccessCheckHandler;
import com.kylin.electricassistsys.entity.ProcessResult;
import com.kylin.electricassistsys.entity.system.SysSetting;
import com.kylin.electricassistsys.service.system.SysSettingService;
import com.kylin.electricassistsys.utility.IPTools;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import sun.net.util.IPAddressUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Created by Threecolors on 2018/3/16.
 */
@Component
public class AccessHandlerInterceptor implements HandlerInterceptor
{

    @Autowired
    AccessCheckHandler accessCheckHandler;

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest,
                             HttpServletResponse httpServletResponse,
                             Object o) throws Exception
    {
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest,
                           HttpServletResponse httpServletResponse,
                           Object o,
                           ModelAndView modelAndView) throws Exception
    {
        //判断是否为ajax请求，默认不是
        boolean isAjaxRequest = false;
        if(!StringUtils.isBlank(httpServletRequest.getHeader("x-requested-with")) && httpServletRequest.getHeader("x-requested-with").equals("XMLHttpRequest")){
            isAjaxRequest = true;
        }

        String ip = IPTools.getIpAddr(httpServletRequest);

        ProcessResult processResult = new ProcessResult();
        if (!IPAddressUtil.isIPv4LiteralAddress(ip)&&!IPAddressUtil.isIPv6LiteralAddress(ip))
        {
            if(isAjaxRequest)
            {
                processResult.setMessage("异常IP！");
                accessCheckHandler.sendJsonMessage(httpServletResponse,processResult);
            }
            else
            {
                modelAndView.setViewName("login");
            }

            return;
        }

        if(!accessCheckHandler.checkIPAccessAuthority(ip))
        {
            if(isAjaxRequest)
            {
                processResult.setMessage("当前IP不允许访问！");
                accessCheckHandler.sendJsonMessage(httpServletResponse,processResult);
            }
            else
            {
                modelAndView.setViewName("login");
            }

            return;
        }

        if(!accessCheckHandler.checkAccessTime())
        {
            if(isAjaxRequest)
            {
                processResult.setMessage("当前时间不允许访问系统！");
                accessCheckHandler.sendJsonMessage(httpServletResponse,processResult);
            }
            else
            {
                modelAndView.setViewName("login");
            }

            return;
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest,
                                HttpServletResponse httpServletResponse,
                                Object o,
                                Exception e) throws Exception
    {

    }
}
