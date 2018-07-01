package com.kylin.electricassistsys.listener;

import com.kylin.electricassistsys.entity.log.LoginLog;
import com.kylin.electricassistsys.entity.system.SysSetting;
import com.kylin.electricassistsys.entity.system.User;
import com.kylin.electricassistsys.service.log.LoginLogService;
import com.kylin.electricassistsys.service.system.LoginRecordsService;
import com.kylin.electricassistsys.service.system.SysSettingService;
import com.kylin.electricassistsys.service.system.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.AuthenticationFailureBadCredentialsEvent;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Threecolors on 2018/1/31.
 */
@Component
public class AuthenticationFailureListener implements ApplicationListener<AuthenticationFailureBadCredentialsEvent> {

    @Autowired
    UserService userService;

    @Autowired
    SysSettingService sysSettingService;

    @Autowired
    LoginRecordsService loginRecordsService;

    @Autowired
    LoginLogService loginLogService;

    /**
     * 登录失败事件
     *
     * @param e
     */
    public void onApplicationEvent(AuthenticationFailureBadCredentialsEvent e) {
        WebAuthenticationDetails webAuthenticationDetails = (WebAuthenticationDetails) e.getAuthentication().getDetails();

        String username = e.getAuthentication().getPrincipal().toString();
        String userIp = webAuthenticationDetails.getRemoteAddress();

        User user = userService.getUserByUsername(username);
        //根据账号获取用户登录信息
        if (user != null && isLockAccount(username)) {
            user.setAccountNonLocked(false);
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

        return sysSetting.getMaxLoginFailedTimes() <= failureCount + 1;
    }
}

