package com.kylin.electricassistsys.controller;

import com.kylin.electricassistsys.common.CaptchaImgCreater;
import com.kylin.electricassistsys.common.Constant;
import com.kylin.electricassistsys.entity.log.LoginLog;
import com.kylin.electricassistsys.entity.system.UserInfoEntity;
import com.kylin.electricassistsys.service.log.LoginLogService;
import com.kylin.electricassistsys.utility.IPTools;
import com.kylin.electricassistsys.utility.RSAUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.security.KeyPair;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.Date;
import java.util.UUID;

/**
 * Created by Threecolors on 2017/12/4.
 */
@Controller
public class LoginController {
    @Autowired
    private LoginLogService loginLogService;

    @RequestMapping(value = {"login"}, method = RequestMethod.GET)
    public String login(HttpServletRequest request, Model model) {
        RSAUtils rsa = new RSAUtils();
        rsa.buildRsaModelParam(request, model);
        return "login";
    }

    @RequestMapping(value = "/captchImg", method = RequestMethod.GET)
    public void getCaptchImg(HttpServletRequest request, HttpServletResponse response) {
        CaptchaImgCreater captchaImgCreater = new CaptchaImgCreater(response, request);
        try {
            captchaImgCreater.createRandImage();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "/expiredProcess")
    public String expiredProcess(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) auth.getPrincipal();

        String userIp = IPTools.getIpAddr(request);
        String userName = userDetails.getUsername();
        loginLogService.addLoginLog(userName, userIp, "注销", "1", StringUtils.EMPTY);
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }


        return "login";
    }
}
