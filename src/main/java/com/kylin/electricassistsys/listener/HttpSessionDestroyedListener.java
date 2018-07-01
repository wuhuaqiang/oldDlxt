package com.kylin.electricassistsys.listener;

import com.kylin.electricassistsys.entity.system.UserInfoEntity;
import com.kylin.electricassistsys.service.log.LoginLogService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.security.web.session.HttpSessionDestroyedEvent;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * Created by Threecolors on 2018/3/15.
 */
@Component
public class HttpSessionDestroyedListener implements ApplicationListener<HttpSessionDestroyedEvent> {
    @Autowired
    private LoginLogService loginLogService;

    @Override
    public void onApplicationEvent(HttpSessionDestroyedEvent httpSessionDestroyedEvent) {
        HttpSession session = httpSessionDestroyedEvent.getSession();

        String logType = "注销";
        if (new Date().getTime() - session.getLastAccessedTime() > session.getMaxInactiveInterval() * 1000) {
            logType = "连接超时";
        }

        UserInfoEntity userInfoEntity = (UserInfoEntity) session.getAttribute("userInfo");
        if (userInfoEntity != null) {
            String loginIP = session.getAttribute("loginIP").toString();
            loginLogService.addLoginLog(userInfoEntity.getUsername(), loginIP, logType, "1", StringUtils.EMPTY);
        }
    }
}
