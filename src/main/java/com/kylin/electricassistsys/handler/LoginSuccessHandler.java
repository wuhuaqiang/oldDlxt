package com.kylin.electricassistsys.handler;

import com.kylin.electricassistsys.entity.log.LoginLog;
import com.kylin.electricassistsys.entity.system.LoginRecords;
import com.kylin.electricassistsys.entity.system.UserInfoEntity;
import com.kylin.electricassistsys.exception.AppException;
import com.kylin.electricassistsys.service.log.LoginLogService;
import com.kylin.electricassistsys.service.system.LoginRecordsService;
import com.kylin.electricassistsys.service.system.UnitService;
import com.kylin.electricassistsys.service.system.UserInfoService;
import com.kylin.electricassistsys.utility.IPTools;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.stereotype.Service;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;
import java.util.UUID;

/**
 * Created by Threecolors on 2018/1/22.
 */
@Service
public class LoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {
    @Autowired
    private LoginRecordsService loginRecordsService;

    @Autowired
    private UserInfoService userInfoService;

    @Autowired
    private LoginLogService loginLogService;

    @Autowired
    public void setAlwaysUseDefaultTargetUrl() {
        this.setAlwaysUseDefaultTargetUrl(true);
    }

    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response,
                                        Authentication authentication) throws ServletException, IOException {

        super.onAuthenticationSuccess(request, response, authentication);

        HttpSession session = request.getSession();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();

        String userIp = IPTools.getIpAddr(request);
        String userName = userDetails.getUsername();

        //登录成功保存用户信息
        UserInfoEntity userInfoEntity = userInfoService.getUserInfoByAccount(userName);
        session.setAttribute("userInfo", userInfoEntity);
        session.setAttribute("loginIP", userIp);

        //登录记录
        String userInfoId = userInfoEntity.getId();
        AddLoginRecord(userIp, userName, userInfoId);

        //记录登录日志
        loginLogService.addLoginLog(userName, userIp, "登录", "1", StringUtils.EMPTY);
    }

    protected void AddLoginRecord(String userIp,
                                  String userName,
                                  String userInfoId) {
        LoginRecords loginRecords = loginRecordsService.getEntityById(userInfoId);
        if (loginRecords == null) {
            loginRecords = new LoginRecords();
            loginRecords.setId(userInfoId);
            loginRecords.setAccount(userName);
            loginRecords.setLoginIp(userIp);
            loginRecords.setLoginTime(new Date());
            loginRecords.setLoginCount(1);
            loginRecordsService.add(loginRecords);
        } else {
            loginRecords.setLastLoginIp(loginRecords.getLoginIp());
            loginRecords.setLastLoginTime(loginRecords.getLoginTime());
            loginRecords.setLoginIp(userIp);
            loginRecords.setLoginTime(new Date());
            loginRecords.setLoginCount(loginRecords.getLoginCount() + 1);
            loginRecordsService.update(loginRecords);
        }
    }
}
