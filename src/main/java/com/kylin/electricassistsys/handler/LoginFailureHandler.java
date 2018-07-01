package com.kylin.electricassistsys.handler;

import com.kylin.electricassistsys.entity.log.LoginLog;
import com.kylin.electricassistsys.entity.system.LoginRecords;
import com.kylin.electricassistsys.entity.system.SysSetting;
import com.kylin.electricassistsys.entity.system.User;
import com.kylin.electricassistsys.entity.system.UserInfoEntity;
import com.kylin.electricassistsys.exception.AppException;
import com.kylin.electricassistsys.service.log.LoginLogService;
import com.kylin.electricassistsys.service.system.LoginRecordsService;
import com.kylin.electricassistsys.service.system.SysSettingService;
import com.kylin.electricassistsys.service.system.UserInfoService;
import com.kylin.electricassistsys.service.system.UserService;
import com.kylin.electricassistsys.utility.IPTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.ExceptionMappingAuthenticationFailureHandler;
import org.springframework.stereotype.Service;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.security.Principal;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by Threecolors on 2018/1/31.
 */
@Service
public class LoginFailureHandler extends ExceptionMappingAuthenticationFailureHandler {
    @Autowired
    UserService userService;

    @Autowired
    SysSettingService sysSettingService;

    @Autowired
    LoginRecordsService loginRecordsService;

    @Autowired
    private LoginLogService loginLogService;

    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        super.onAuthenticationFailure(request, response, exception);
        String userIp = IPTools.getIpAddr(request);
        String username = request.getParameter("username");
        loginLogService.addLoginLog(username, userIp, "登录", "0", exception.getMessage());

        User user = userService.getUserByUsername(username);
        //根据账号获取用户登录信息
        if (user != null && isLockAccount(username)) {
            user.setAccountNonLocked(false);
            user.setLockTime(new Date());
            userService.update(user);
        }
    }

    private boolean isLockAccount(String userName) {
        //获取系统设置
        SysSetting sysSetting = sysSettingService.selectSysSetting();
        //获取最新的 topN 条登录日志
        int failureCount = 0;
        List<LoginLog> loginLogList = loginLogService.getRecentLoginLogInLimitTime(userName, sysSetting.getLoginFailedTimeInterval());
        for (LoginLog loginLog : loginLogList) {
            if ("1".equals(loginLog.getIsSuccess())) {
                break;
            }

            if (loginLog.getErrorMsg().contains("用户名或密码错误")) {
                failureCount++;
            }
        }

        return sysSetting.getMaxLoginFailedTimes() <= failureCount;
    }
}
