package com.kylin.electricassistsys.controller;

import com.kylin.electricassistsys.entity.system.LoginRecords;
import com.kylin.electricassistsys.entity.system.SysSetting;
import com.kylin.electricassistsys.entity.system.User;
import com.kylin.electricassistsys.entity.system.UserInfoEntity;
import com.kylin.electricassistsys.service.system.LoginRecordsService;
import com.kylin.electricassistsys.service.system.MenuService;
import com.kylin.electricassistsys.service.system.SysSettingService;
import com.kylin.electricassistsys.service.system.UserService;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;


/**
 * Created by Threecolors on 2017/11/13.
 */
@Controller
public class DefaultController extends AuthorityController
{
    @Autowired
    private MenuService menuService;

    @Autowired
    private LoginRecordsService loginRecordsService;

    @Autowired
    private SysSettingService sysSettingService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = {"/default","/"}, method = RequestMethod.GET)
    public String defaultPage(Model model)
    {
        UserInfoEntity userInfoEntity = this.getUserInfo();
        String leftTree =  menuService.getLeftMenuTree();
        model.addAttribute("leftTree", leftTree);
        model.addAttribute("userName",userInfoEntity.getName());
        return "default";
    }

    @RequestMapping(value = {"/index"}, method = RequestMethod.GET)
    public String index(Model model)
    {
        UserInfoEntity userInfo = this.getUserInfo();
        if(userInfo==null)
        {
            return "login";
        }
       LoginRecords loginRecords = loginRecordsService.getEntityById(userInfo.getId());
        SysSetting sysSetting =sysSettingService.selectSysSetting();
        User user =  userService.selectByKyId(userInfo.getId());
        boolean isFirstLogin = DateUtils.isSameInstant(user.getChangePwdTime(),user.getAddTime());
        long expiped =sysSetting.getPwdValidDurationTime() - ((new Date().getTime() - user.getChangePwdTime().getTime()) / (24 * 60 * 60 * 1000));
       model.addAttribute("loginRecords",loginRecords);
       model.addAttribute("user",userInfo);
       model.addAttribute("expiped",expiped);
       model.addAttribute("isFirstLogin",isFirstLogin);
        return "index";
    }
}
