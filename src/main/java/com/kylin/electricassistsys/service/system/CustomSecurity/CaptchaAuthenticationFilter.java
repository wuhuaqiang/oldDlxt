package com.kylin.electricassistsys.service.system.CustomSecurity;

import com.kylin.electricassistsys.common.AccessCheckHandler;
import com.kylin.electricassistsys.common.Constant;
import com.kylin.electricassistsys.entity.ProcessResult;
import com.kylin.electricassistsys.entity.system.SysSetting;
import com.kylin.electricassistsys.exception.AuthoritySysException;
import com.kylin.electricassistsys.service.system.SysSettingService;
import com.kylin.electricassistsys.utility.IPTools;
import com.kylin.electricassistsys.utility.MD5Util;
import com.kylin.electricassistsys.utility.RSAUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.session.SessionInformation;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import sun.net.util.IPAddressUtil;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.security.Principal;
import java.security.interfaces.RSAPrivateKey;
import java.util.Date;
import java.util.List;

/**
 * Created by Threecolors on 2018/1/24.
 */
public class CaptchaAuthenticationFilter extends UsernamePasswordAuthenticationFilter
{
    public static final String SPRING_SECURITY_FORM_CAPTCHA_KEY = "captcha";
    public static final String SESSION_GENERATED_CAPTCHA_KEY = Constant.SESSION_GENERATED_CAPTCHA_KEY;

    private String captchaParameter = SPRING_SECURITY_FORM_CAPTCHA_KEY;

    @Autowired
    SysSettingService sysSettingService;

    @Autowired
    AccessCheckHandler accessCheckHandler;

    @Resource
    private SessionRegistry sessionRegistry;

    public Authentication attemptAuthentication(HttpServletRequest request,
                                                HttpServletResponse response) throws AuthenticationException
    {
        checkSign(request);
        accessCheck(request);

        String genCode = this.obtainGeneratedCaptcha(request);
        String inputCode = this.obtainCaptcha(request);

//        if (inputCode == null || StringUtils.isEmpty(inputCode))
//        {
//            throw new CaptchaException("请填写验证码！");
//        }
//
//        if (!genCode.equalsIgnoreCase(inputCode))
//        {
//            throw new CaptchaException("验证不正确！");
//        }

        Authentication authentication = super.attemptAuthentication(request, response);
        setSessionMaxInactiveInterval(request, authentication);
        return  authentication;
    }

    private void checkSign(HttpServletRequest request)
    {
        String inputCode = this.obtainCaptcha(request);
        String orgSign = this.obtainSign(request);
        String username = this.obtainUsername(request);
        String pwd = this.obtainPassword(request);

        String sign =  MD5Util.encode(inputCode+username+pwd);

        if(!StringUtils.equals(sign,orgSign))
        {
            throw new AuthoritySysException("用户名或密码错误！");
        }
    }

    /**设置会话过期时间
     * @param request
     * @param authentication
     */
    private void setSessionMaxInactiveInterval(HttpServletRequest request,
                                               Authentication authentication)
    {
        SysSetting sysSetting = sysSettingService.selectSysSetting();

        int sessionTimeout = sysSetting.getSessionKeepTime()*600;
        //获取有效的SessionInformation
        List<SessionInformation> sessionInformations = sessionRegistry.getAllSessions(authentication.getPrincipal(), false);
        Date now = new Date();
        for(SessionInformation sessionInformation : sessionInformations)
        {
            if(now.after(DateUtils.addSeconds(sessionInformation.getLastRequest(), sessionTimeout)))
            {
                sessionInformation.expireNow();
            }
        }

        request.getSession().setMaxInactiveInterval(sessionTimeout);

        checkSessionRegistryCount();

        sessionRegistry.registerNewSession(request.getSession().getId(),authentication.getPrincipal());
    }

    /**
     * 当前在线人数校验
     */
    private  void checkSessionRegistryCount()
    {
        SysSetting sysSetting = sysSettingService.selectSysSetting();
        List<Object> principals = sessionRegistry.getAllPrincipals();
        if(principals.size()>=sysSetting.getMaxSessionCount())
        {
            throw new AuthoritySysException("当前使用系统人数过多，稍后使用！");
        }
    }

    protected String obtainCaptcha(HttpServletRequest request)
    {
        return request.getParameter(this.captchaParameter);
    }

    protected String obtainGeneratedCaptcha(HttpServletRequest request)
    {
        return (String) request.getSession().getAttribute(SESSION_GENERATED_CAPTCHA_KEY);
    }

    private  String obtainSign(HttpServletRequest request)
    {
        return request.getParameter("sign");
    }


    /**
     * 密码重载，解密
     *
     * @param request
     * @return
     */
    protected String obtainPassword(HttpServletRequest request)
    {
        try
        {
            HttpSession httpSession = request.getSession();
            RSAPrivateKey rsaPrivateKey = httpSession.getAttribute(
                    Constant.RSA_PRIVATE_KEY) != null ? (RSAPrivateKey) httpSession.getAttribute(
                    Constant.RSA_PRIVATE_KEY) : null;
            RSAUtils rsaUtils = new RSAUtils();
            String password = rsaUtils.decryptStringByJs(request.getParameter(this.getPasswordParameter()),
                                                         rsaPrivateKey);
            return  password;
        }
        catch (Exception ex)
        {
            throw new AuthoritySysException("系统错误，稍后重试！");
        }
    }

    /** 检查登录IP和当前登录时间是否符合要求
     * @param request
     */
    protected void accessCheck(HttpServletRequest request)
    {
        //判断是否为ajax请求，默认不是
        boolean isAjaxRequest = false;
        if(!StringUtils.isBlank(request.getHeader("x-requested-with")) && request.getHeader("x-requested-with").equals("XMLHttpRequest")){
            isAjaxRequest = true;
        }

        String ip = IPTools.getIpAddr(request);

        ProcessResult processResult = new ProcessResult();
        if (!IPAddressUtil.isIPv4LiteralAddress(ip)&&!IPAddressUtil.isIPv6LiteralAddress(ip))
        {
            accessCheckHandler.writeSysAuditLog(request);
            throw new AuthoritySysException("异常IP！");
        }

        if(!accessCheckHandler.checkIPAccessAuthority(ip))
        {
            accessCheckHandler.writeSysAuditLog(request);
            throw new AuthoritySysException("当前IP不允许访问！");
        }

        if(!accessCheckHandler.checkAccessTime())
        {
            throw new AuthoritySysException("当前时间不允许访问！");
        }
    }
}
