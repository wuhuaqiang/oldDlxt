package com.kylin.electricassistsys.service.system.CustomSecurity;

import com.kylin.electricassistsys.entity.log.AuditEventGrade;
import com.kylin.electricassistsys.entity.log.AuditEventName;
import com.kylin.electricassistsys.entity.log.AuditEventType;
import com.kylin.electricassistsys.entity.log.SysAuditLog;
import com.kylin.electricassistsys.service.log.SysAuditLogService;
import com.kylin.electricassistsys.utility.IPTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.UUID;

/**
 * Created by Threecolors on 2017/12/4.
 */
@Service
public class CustomAccessDecisionManager implements AccessDecisionManager
{
    @Autowired
    SysAuditLogService sysAuditLogService;

    // decide 方法是判定是否拥有权限的决策方法，
    //authentication 是CustomUserDetailsService中循环添加到 GrantedAuthority 对象中的权限信息集合.
    //object 包含客户端发起的请求的requset信息，可转换为 HttpServletRequest request = ((FilterInvocation) object).getHttpRequest();
    //configAttributes 为CustomInvocationSecurityMetadataSource的getAttributes(Object object)这个方法返回的结果，此方法是为了判定用户请求的url 是否在权限表中，如果在权限表中，则返回给 decide 方法，用来判定用户是否有此权限。如果不在权限表中则放行。
    @Override
    public void decide(Authentication authentication, Object object, Collection<ConfigAttribute> configAttributes) throws AccessDeniedException, InsufficientAuthenticationException {

        if(null== configAttributes || configAttributes.size() <=0) {
            return;
        }


        HttpServletRequest request = ((FilterInvocation) object).getHttpRequest();
        String url;
        if ("anonymousUser".equals(authentication.getPrincipal())
                || matchers("/images/**", request)
                || matchers("/js/**", request)
                || matchers("/css/**", request)
                || matchers("/fonts/**", request)
                || matchers("/", request)
                || matchers("/favicon.ico", request)
                || matchers("/login", request)) {
            return;
        } else {
            for (GrantedAuthority ga : authentication.getAuthorities()) {
                if (ga instanceof CustomGrantedAuthority) {
                    CustomGrantedAuthority customGrantedAuthority = (CustomGrantedAuthority) ga;
                    url = customGrantedAuthority.getPermissionUrl();
                    if (matchers(url, request)) {
                        return;
                    }
                }
            }
        }
        //越权事件
        writeSysAuditLog(authentication,request);
        throw new AccessDeniedException("权限不足");
    }

    protected void writeSysAuditLog(Authentication authentication,HttpServletRequest request)
    {
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String userIp = IPTools.getIpAddr(request);
        String msg = String.format("目标地址：{%s}",request.getServletPath()) ;
        try
        {
            SysAuditLog sysAuditLog = new SysAuditLog();
            sysAuditLog.setAccount(userDetails.getUsername());
            sysAuditLog.setModuleName("访问越权");
            sysAuditLog.setCurrentTime(new Date());
            sysAuditLog.setUserIp(userIp);
            sysAuditLog.setAuditEventName(AuditEventName.UNAUTHORIZED.getName());
            sysAuditLog.setMessage(msg);
            sysAuditLog.setType(AuditEventType.SYS_EVENT.getName());
            sysAuditLog.setAuditEventGrade(AuditEventGrade.ABNORMAL.getName());
            sysAuditLog.setId(UUID.randomUUID().toString());
            sysAuditLogService.addAndMonitoringLog(sysAuditLog);
        }
        catch (Exception ex)
        {
            String s = ex.getMessage();
        }
    }

    @Override
    public boolean supports(ConfigAttribute attribute) {
        return true;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return true;
    }

    private boolean matchers(String url, HttpServletRequest request) {
        AntPathRequestMatcher matcher = new AntPathRequestMatcher(url);
        if (matcher.matches(request)) {
            return true;
        }
        return false;
    }
}
