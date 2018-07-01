package com.kylin.electricassistsys.handler;

import com.kylin.electricassistsys.service.log.LoginLogService;
import com.kylin.electricassistsys.utility.IPTools;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Threecolors on 2018/3/15.
 */
//@Component
public class LogoutLogHandler //implements LogoutHandler
{
//    @Autowired
//    private LoginLogService loginLogService;
//
//    @Override
//    public void logout(HttpServletRequest httpServletRequest,
//                       HttpServletResponse httpServletResponse,
//                       Authentication authentication)
//    {
//        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
//
//        String userIp = IPTools.getIpAddr(httpServletRequest);
//        String userName = userDetails.getUsername();
//
//        loginLogService.addLoginLog(userName, userIp, "注销", true, StringUtils.EMPTY);
 //   }
}
