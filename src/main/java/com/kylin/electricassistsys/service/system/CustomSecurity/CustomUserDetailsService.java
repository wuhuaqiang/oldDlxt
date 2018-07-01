package com.kylin.electricassistsys.service.system.CustomSecurity;


import com.kylin.electricassistsys.common.Constant;
import com.kylin.electricassistsys.entity.system.AccountStatus;
import com.kylin.electricassistsys.entity.system.LoginRecords;
import com.kylin.electricassistsys.entity.system.SysSetting;
import com.kylin.electricassistsys.exception.AuthoritySysException;
import com.kylin.electricassistsys.service.system.LoginRecordsService;
import com.kylin.electricassistsys.service.system.RoleAuthorityService;
import com.kylin.electricassistsys.service.system.SysSettingService;
import com.kylin.electricassistsys.service.system.UserService;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.List;

/**
 * Created by Threecolors on 2017/12/4.
 */
@Service
public class CustomUserDetailsService implements UserDetailsService
{
    private final static long MSEL_FOR_DAY = 24 * 60 * 60 * 1000;
    private final static long MSEL_FOR_MIN = 60 * 1000;

    protected final Log logger = LogFactory.getLog(this.getClass());

    @Autowired
    private LoginRecordsService loginRecordsService;

    @Autowired
    UserService userService;

    @Autowired
    RoleAuthorityService roleAuthorityService;

    @Autowired
    private SysSettingService sysSettingService;

    @Autowired
    private SessionRegistry sessionRegistry;

    @Override
    public UserDetails loadUserByUsername(String username)
    {
        try
        {
            // /重写loadUserByUsername 方法获得 userdetails 类型用户
            com.kylin.electricassistsys.entity.system.User user = userService.getUserByUsername(username);

            if (user!=null)
            {
                SysSetting sysSetting =sysSettingService.selectSysSetting();

                if(!this.checkTemporaryAccount(user,sysSetting))
                {
                    throw new BadCredentialsException("临时账号已经过期！");
                }

                //检查账号休眠情况
                if(!this.checkAccountValidDurationTime(user,sysSetting))
                {
                    throw new BadCredentialsException("账号状态不可用,请联系管理员！");
                }

                checkPwdValidDurationTime(user,sysSetting);
                HashMap<String, Integer> roleAuthorityMaps = roleAuthorityService.getRoleAuthorityByAccount(username);
                List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
                Set<Map.Entry<String, Integer>> entrySet = roleAuthorityMaps.entrySet();
                for (Map.Entry<String, Integer> entry : entrySet)
                {
                    GrantedAuthority grantedAuthority = new CustomGrantedAuthority(entry.getKey(), entry.getValue());
                    grantedAuthorities.add(grantedAuthority);
                }

                return new User(user.getUsername(), user.getPassword(), user.isEnabled(),user.isAccountNonExpired(),true,user.isAccountNonLocked(),grantedAuthorities);
            }
            else
            {
                throw new BadCredentialsException("用户名或密码错误！");
            }
        }
        catch (AuthenticationException authenticationException)
        {
            throw  authenticationException;
        }
        catch (Exception ex)
        {
            logger.error(ex);
            throw new AuthoritySysException("系统错误，稍后重试！");
        }
    }


    private  boolean checkTemporaryAccount(com.kylin.electricassistsys.entity.system.User user,SysSetting sysSetting)
    {
        if(StringUtils.equals(user.getAccountStatus(),AccountStatus.TEMPORARY_AVAILABLE.getName()))
        {
            long temp = (new Date().getTime() - user.getAddTime().getTime()) - sysSetting.getTemporaryAccountDurationTime()*MSEL_FOR_DAY;
            if(temp>0)
            {
                return  false;
            }
        }

        return true;
    }



    /**检查用户账号登录记录，判断是否长时间未使用的休眠账号
     * @param user
     * @param sysSetting
     * @return
     */
    private  boolean checkAccountValidDurationTime(com.kylin.electricassistsys.entity.system.User user,SysSetting sysSetting)
    {
        if(StringUtils.equals(user.getAccountStatus(),AccountStatus.RESTING.getName()))
        {
            return  false;
        }

        LoginRecords loginRecords = loginRecordsService.getEntityById(user.getId());
        if(loginRecords!=null)
        {
            long resting = (new Date().getTime() - loginRecords.getLoginTime().getTime())  - sysSetting.getAccountValidDurationTime()*MSEL_FOR_DAY;
            if(resting>0)
            {
                user.setAccountStatus(AccountStatus.RESTING.getName());
                userService.update(user);
                return false;
            }
        }

        return true;
    }

    /**检查用户密码过期情况(不做验证，只修改数据库，不然密码过期无法登录，先允许登录，登录成功强行修改密码)
     * 1. 锁定账号时间验证，超过锁定时间，自动解锁
     * 2. 查看用户上次更改密码时间，判断是否密码过期
     * @param user
     * @param sysSetting
     */
    private void checkPwdValidDurationTime(com.kylin.electricassistsys.entity.system.User user, SysSetting sysSetting)
    {
        //锁定账号时间验证，超过锁定时间，自动解锁
        if(!user.isAccountNonLocked())
        {
            long lock = (new Date().getTime() - user.getLockTime().getTime())  - sysSetting.getPwdLockDuration()*MSEL_FOR_MIN;
            user.setAccountNonLocked(lock > 0);
        }

        //查看用户上次更改密码时间，判断是否密码过期
        long expiped =(new Date().getTime() - user.getChangePwdTime().getTime()) - sysSetting.getPwdValidDurationTime()* MSEL_FOR_DAY;
        user.setCredentialsNonExpired(expiped<0);

        userService.update(user);
    }
}
