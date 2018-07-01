package com.kylin.electricassistsys.controller;

import com.kylin.electricassistsys.entity.system.UserInfoEntity;
import com.kylin.electricassistsys.service.system.CustomSecurity.CustomGrantedAuthority;
import com.kylin.electricassistsys.service.system.UserInfoService;
import com.kylin.electricassistsys.utility.IPTools;
import com.kylin.electricassistsys.utility.StringHelper;
import org.apache.calcite.linq4j.Linq4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Collection;

/**
 * Created by Threecolors on 2018/1/21.
 */
public class AuthorityController
{
    @Autowired
    private UserInfoService userInfoService;

    private UserInfoEntity userInfo;

    private int restrictAuthority = 127;

    private String userIp = "";

    public AuthorityController()
    {
    }

    protected int getAuthority()
    {
        String url = this.getUrlWithQueryString();
        Collection<CustomGrantedAuthority> grantedAuthorityList = (Collection<CustomGrantedAuthority>) SecurityContextHolder.getContext().getAuthentication().getAuthorities();
        CustomGrantedAuthority customGrantedAuthority = Linq4j.asEnumerable(grantedAuthorityList).firstOrDefault(a->a.getPermissionUrl().equals(url));

        //用户权限列表没有获取到，判定为无权限
        if(customGrantedAuthority==null)
        {
            return  0;
        }
        return customGrantedAuthority.getMethod()&restrictAuthority;
    }

    protected  String getUrlWithQueryString()
    {
        HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
        String requestURL = request.getRequestURI();
        String queryString = request.getQueryString();
        if(StringHelper.isNullOrEmpty(queryString))
        {
            return requestURL;
        }

        return requestURL + "?" + queryString;
    }



    //  此方法会在每次请求前调用（这个类的处理方法）
    @ModelAttribute
    private void initUser(HttpSession session) {
        Object obj = session.getAttribute("userInfo");
        if(obj==null)
        {
            UserDetails userDetails =  (UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            if(userDetails!=null)
            {
                obj = userInfoService.getUserInfoByAccount(userDetails.getUsername());
            }
            session.setAttribute("userInfo", obj);
        }

        if(obj instanceof UserInfoEntity) {
            this.userInfo = (UserInfoEntity) obj;
        }
        else
        {
            this.userInfo = new UserInfoEntity();
        }

    }

    public UserInfoEntity getUserInfo()
    {
        return userInfo;
    }

    public int getRestrictAuthority()
    {
        return restrictAuthority;
    }

    public void setRestrictAuthority(int restrictAuthority)
    {
        this.restrictAuthority = restrictAuthority;
    }

    public String getUserIp()
    {
        HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
        return IPTools.getIpAddr(request);
    }
}
