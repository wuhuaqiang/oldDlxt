package com.kylin.electricassistsys.controller.system;

import com.kylin.electricassistsys.common.Constant;
import com.kylin.electricassistsys.controller.BaseController;
import com.kylin.electricassistsys.entity.AutoBuilderParam;
import com.kylin.electricassistsys.entity.ProcessResult;
import com.kylin.electricassistsys.entity.enumparam.KeyValueType;
import com.kylin.electricassistsys.entity.log.AuditEventGrade;
import com.kylin.electricassistsys.entity.log.AuditEventName;
import com.kylin.electricassistsys.entity.log.AuditEventType;
import com.kylin.electricassistsys.entity.system.User;
import com.kylin.electricassistsys.entity.system.UserInfoEntity;
import com.kylin.electricassistsys.service.KeyValueService;
import com.kylin.electricassistsys.service.system.UserInfoService;
import com.kylin.electricassistsys.service.system.UserService;
import com.kylin.electricassistsys.utility.*;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.security.interfaces.RSAPrivateKey;
import java.util.Date;
import java.util.HashMap;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Threecolors on 2017/11/16.
 */
@Controller
@RequestMapping("/system/user")
public class UserInfoController extends BaseController<UserInfoEntity, UserInfoService>
{
    @Autowired
    KeyValueService keyValueService;

    @Autowired
    UserService userService;

    @Autowired
    private FreeMarkerConfigurer fmConfigurer;

    @Autowired
    public void setService(UserInfoService service)
    {
        setBaseService(service);
    }

    @Autowired
    private void setAutoBuilderParam()
    {
        AutoBuilderParam autoBuilderParam = new AutoBuilderParam("用户信息", "/system/user", "450px", "900px", 1);
        this.setAutoBuilderParam(autoBuilderParam);
    }

    @Autowired
    protected void setAuditEventType()
    {
        this.auditEventType = AuditEventType.SYS_EVENT;
    }

    protected String getListUrl()
    {
        return "system/userlist";
    }

    protected String getEditUrl()
    {
        return "system/useredit";
    }

    /**
     * 构建编辑
     *
     * @param model
     * @param entity
     */
    protected void buildEdit(HttpServletRequest request,
                             Model model,
                             UserInfoEntity entity,
                             String type)
    {
        model.addAttribute("entity", entity);
        HashMap<String, String> unites = keyValueService.getKeyValueMap(KeyValueType.GDGS);
        model.addAttribute("unites", unites);
        model.addAttribute("autoBuilderParam", autoBuilderParam);
    }


    @ResponseBody
    @RequestMapping(value = "/resetAccount", method = RequestMethod.POST)
    public ProcessResult resetAccount(HttpServletRequest request,
                                      String id)
    {
        String msg = "重置失败";
        AuditEventGrade auditEventGrade = AuditEventGrade.INFO;
        ProcessResult processResult = new ProcessResult();
        try
        {
            processResult.setSuccess(service.resetAccount(id));
            return processResult;
        }
        catch (Exception ex)
        {
            auditEventGrade = AuditEventGrade.ERROR;
            msg = "系统异常：" + ex.getMessage();
            throw ex;
        }
        finally
        {
            this.writeSysAuditLog(AuditEventName.MODIFY, processResult.isSuccess()? "重置成功" : msg, auditEventGrade);
        }
    }

    @ResponseBody
    @RequestMapping(value = "/unlockAccount", method = RequestMethod.POST)
    public ProcessResult unlockAccount(HttpServletRequest request,
                                       String id)
    {
        String msg = "解锁失败";
        AuditEventGrade auditEventGrade = AuditEventGrade.INFO;
        ProcessResult processResult = new ProcessResult();
        try
        {
            processResult.setSuccess(userService.unlockAccount(id));
            return processResult;
        }
        catch (Exception ex)
        {
            auditEventGrade = AuditEventGrade.ERROR;
            msg = "系统异常：" + ex.getMessage();
            throw ex;
        }
        finally
        {
            this.writeSysAuditLog(AuditEventName.MODIFY, processResult.isSuccess()? "解锁成功" : msg, auditEventGrade);
        }
    }


    @RequestMapping("/modfiyPwd")
    public String modfiyPwd(HttpServletRequest request,
                            Model model)
    {
        RSAUtils rsa = new RSAUtils();
        rsa.buildRsaModelParam(request, model);

        AutoBuilderParam autoBuilderParam = new AutoBuilderParam("用户信息", "/system/user/pwd", "500px", "900px", 1);
        model.addAttribute("username", this.getUserInfo().getUsername());
        model.addAttribute("autoBuilderParam", autoBuilderParam);
        return "system/modifyPwd";
    }

    @RequestMapping("/modfiyUserInfo")
    public String modfiyUserInfo(Model model)
    {
        UserInfoEntity userInfoEntity = service.getUserInfoByAccount(this.getUserInfo().getUsername());
        model.addAttribute("entity", userInfoEntity);
        AutoBuilderParam autoBuilderParam = new AutoBuilderParam("用户信息", "/system/user/userInfo", "510px", "900px", 1);
        model.addAttribute("autoBuilderParam", autoBuilderParam);
        HashMap<String, String> unites = keyValueService.getKeyValueMap(KeyValueType.GDGS);
        model.addAttribute("unites", unites);
        model.addAttribute("flag", true);
        return getEditUrl();
    }

    @ResponseBody
    @RequestMapping("/userInfo/saveModify")
    public ProcessResult saveUserInfo(@Validated UserInfoEntity entity)
    {
        String msg = "修改失败";
        AuditEventGrade auditEventGrade = AuditEventGrade.INFO;
        ProcessResult processResult = new ProcessResult();
        try
        {
            UserInfoEntity userInfoEntity = service.getUserInfoByAccount(this.getUserInfo().getUsername());
            userInfoEntity.setAddress(entity.getAddress());
            userInfoEntity.setEmail(entity.getEmail());
            userInfoEntity.setName(entity.getName());
            userInfoEntity.setCellphoneNumber(entity.getCellphoneNumber());
            userInfoEntity.setQq(entity.getQq());
            userInfoEntity.setSex(entity.getSex());
            userInfoEntity.setTelephoneNumber(entity.getTelephoneNumber());
            userInfoEntity.setRemark(entity.getRemark());
            userInfoEntity.setUpdateTime(null);

            processResult.setSuccess(service.updateByPrimaryKeySelective(userInfoEntity));
        }
        catch (Exception ex)
        {
            auditEventGrade = AuditEventGrade.ERROR;
            msg = "系统异常：" + ex.getMessage();
            throw ex;
        }
        finally
        {
            this.writeSysAuditLog(AuditEventName.MODIFY, processResult.isSuccess() ? "修改成功" : msg, auditEventGrade);
        }
        return processResult;
    }

    @ResponseBody
    @RequestMapping("/pwd/save")
    public ProcessResult savePwd(HttpServletRequest request,
                                 @Validated User user,
                                 @NotBlank(message = "必填项") String orgPassword,
                                 @NotBlank(message = "必填项") String rePassword)
    {
        String msg = "修改失败";
        AuditEventGrade auditEventGrade = AuditEventGrade.INFO;
        ProcessResult processResult = new ProcessResult();
        try
        {
            user.setPassword(getDecryptStringForRSAJS(request, user.getPassword()));
            orgPassword = getDecryptStringForRSAJS(request, orgPassword);
            rePassword = getDecryptStringForRSAJS(request, rePassword);

            User orgUser = userService.getEntityByAccount(this.getUserInfo().getUsername());

            processResult = this.checkUsernameAndPwd(user, orgUser, orgPassword, rePassword);
            if (processResult.getFieldErrors().size() > 0)
            {
                return processResult;
            }

            orgUser.setPassword(DESCryptography.encode(user.getPassword()));
            orgUser.setChangePwdTime(new Date());
            orgUser.setCredentialsNonExpired(true);
            if (!userService.updateByPrimaryKeySelective(orgUser))
            {
                processResult.setMessage("保存失败!");
            }
            else
            {
                processResult.setSuccess(true);
            }
        }
        catch (Exception ex)
        {
            auditEventGrade = AuditEventGrade.ERROR;
            msg = "系统异常：" + ex.getMessage();
            throw ex;
        }
        finally
        {
            this.writeSysAuditLog(AuditEventName.MODIFY, processResult.isSuccess()? "修改成功" : msg, auditEventGrade);
        }

        return processResult;
    }

    @ResponseBody
    @RequestMapping(value = "/saveAdd", method = RequestMethod.POST)
    public ProcessResult saveAdd(HttpServletRequest request,
                                 @Validated UserInfoEntity entity) throws Exception
    {
        String msg = "添加失败";
        ProcessResult processResult = new ProcessResult();
        AuditEventGrade auditEventGrade = AuditEventGrade.INFO;
        try
        {
            //检查账号是否重复
            if (userService.isUsernameExsist(entity.getUsername()))
            {
                processResult.setMessage("账号已经存在！");
                return processResult;
            }

            entity.setId(UUID.randomUUID().toString());
            processResult.setSuccess(service.insertSelective(entity));
            return processResult;
        }
        catch (Exception ex)
        {
            msg = "系统异常：" + ex.getMessage();
            throw ex;
        }
        finally
        {
            this.writeSysAuditLog(AuditEventName.ADD, processResult.isSuccess() ? "添加成功" : msg, auditEventGrade);
        }
    }

    private String getDecryptStringForRSAJS(HttpServletRequest request,
                                            String input)
    {
        HttpSession httpSession = request.getSession();
        RSAPrivateKey rsaPrivateKey = httpSession.getAttribute(
                Constant.RSA_PRIVATE_KEY) != null ? (RSAPrivateKey) httpSession.getAttribute(
                Constant.RSA_PRIVATE_KEY) : null;
        RSAUtils rsaUtils = new RSAUtils();

        return rsaUtils.decryptStringByJs(input, rsaPrivateKey);
    }

    private ProcessResult checkUsernameAndPwd(User user,
                                              User orgUser,
                                              String inputOrgPwd,
                                              String rePassWord)
    {
        ProcessResult processResult = new ProcessResult();

        if (!user.equals(orgUser))
        {
            processResult.getFieldErrors().add(new FieldError("", "username", "账号不正确"));
        }

        if (!orgUser.getPassword().equals(inputOrgPwd))
        {
            processResult.getFieldErrors().add(new FieldError("", "orgPassword", "密码不正确"));
        }

        if (!user.getPassword().equals(rePassWord))
        {
            processResult.getFieldErrors().add(new FieldError("", "rePassword", "密码不一致"));
        }

        if (user.getPassword().equals(inputOrgPwd))
        {
            processResult.getFieldErrors().add(new FieldError("", "password", "新密码与原密码一致"));
        }
        else if (!pwdCheck(user.getPassword()))
        {
            processResult.getFieldErrors().add(new FieldError("", "password", "大写字母、小写字母、数字、特殊字符中的三种或三种以上构成8到20位字符"));
        }
        else if (user.getPassword().contains(user.getUsername()))
        {
            processResult.getFieldErrors().add(new FieldError("", "password", "密码不能包含用户名"));
        }

        return processResult;
    }


    /**
     * 8到20位字符，复杂度为大写字母、小写字母、数字、特殊字符中的三种或三种以上的组合
     *
     * @param pwd
     * @return
     */
    private boolean pwdCheck(String pwd)
    {

        if (pwd.length() > 20 || pwd.length() < 8)
        {
            return false;
        }

        int a = 0;
        int b = 0;
        int c = 0;
        int d = 0;
        for (int i = 0; i < pwd.length(); i++)
        {
            if (Character.isUpperCase(pwd.charAt(i)))
            {
                a = 1;
            }
            if (Character.isLowerCase(pwd.charAt(i)))
            {
                b = 1;
            }
            if (Character.isDigit(pwd.charAt(i)))
            {
                c = 1;
            }
        }

        Pattern p = Pattern.compile("[@#$%^&*]");
        Matcher m = p.matcher(pwd);
        boolean match = m.find();
        if (match)
        {
            d = 1;
        }

        if (a + b + c + d >= 3)
        {
            return true;
        }
        return false;
    }
}
