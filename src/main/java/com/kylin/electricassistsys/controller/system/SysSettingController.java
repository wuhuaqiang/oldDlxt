package com.kylin.electricassistsys.controller.system;

import com.kylin.electricassistsys.common.Constant;
import com.kylin.electricassistsys.controller.AuthorityController;
import com.kylin.electricassistsys.controller.BaseController;
import com.kylin.electricassistsys.entity.AutoBuilderParam;
import com.kylin.electricassistsys.entity.ProcessResult;
import com.kylin.electricassistsys.entity.log.AuditEventGrade;
import com.kylin.electricassistsys.entity.log.AuditEventName;
import com.kylin.electricassistsys.entity.log.AuditEventType;
import com.kylin.electricassistsys.entity.log.SysAuditLog;
import com.kylin.electricassistsys.entity.system.SysSetting;
import com.kylin.electricassistsys.entity.system.UserInfoEntity;
import com.kylin.electricassistsys.service.log.SysAuditLogService;
import com.kylin.electricassistsys.service.system.SysSettingService;
import com.kylin.electricassistsys.service.system.UserInfoService;
import com.kylin.electricassistsys.utility.DESCryptography;
import com.kylin.electricassistsys.utility.RSAUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.security.interfaces.RSAPrivateKey;
import java.util.*;

/**
 * Created by Threecolors on 2018/1/31.
 */
@Controller
@RequestMapping("/system/sysSetting")
public class SysSettingController extends AuthorityController //extends BaseController<SysSetting, SysSettingService>
{
    protected final Log logger = LogFactory.getLog(this.getClass());

    @Autowired
    protected SysAuditLogService sysAuditLogService;

    @Autowired
    private SysSettingService service;

    private AutoBuilderParam autoBuilderParam =new AutoBuilderParam("系统设置", "/system/sysSetting", "450px", "900px", 1);

    private AuditEventType auditEventType = AuditEventType.SYS_EVENT;

    @RequestMapping
    public String sysSetting(HttpServletRequest request, Model model)
    {
        RSAUtils rsa = new RSAUtils();
        rsa.buildRsaModelParam(request, model);

        SysSetting sysSetting =  service.selectSysSetting();
        model.addAttribute("entity",sysSetting);
        model.addAttribute("autoBuilderParam",autoBuilderParam);
        return "system/sysSetting";
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

    @ResponseBody
    @RequestMapping(value = {"/saveModify","/saveAdd"},method = RequestMethod.POST)
    public ProcessResult save(HttpServletRequest request ,@Validated SysSetting entity) throws Exception
    {
        String msg = "保存系统设置失败";
        AuditEventGrade auditEventGrade = AuditEventGrade.INFO;
        ProcessResult processResult = new ProcessResult();
        try
        {
            String pwd = DESCryptography.encode(getDecryptStringForRSAJS(request, entity.getMailPassword()));
            entity.setMailPassword(pwd);
            SysSetting sysSetting = service.selectSysSetting();
            if (StringUtils.isEmpty(sysSetting.getId()))
            {
                entity.setId(UUID.randomUUID().toString());
                if (service.insertSelective(entity))
                {
                    processResult.setSuccess(true);
                }
            }
            else if (StringUtils.equals(sysSetting.getId(), entity.getId()))
            {
                if (service.updateByPrimaryKeySelective(entity))
                {
                    processResult.setSuccess(true);
                }
            }
        }
        catch (Exception ex)
        {
            auditEventGrade = AuditEventGrade.ERROR;
            msg = "系统异常：" + ex.getMessage();
            logger.error("保存系统设置出错",ex);
            throw ex;
        }
        finally
        {
            this.writeSysAuditLog(AuditEventName.MODIFY, processResult.isSuccess() ? "保存系统设置成功" : msg, auditEventGrade);
        }

        return processResult;
    }

    protected void writeSysAuditLog(AuditEventName eventName,
                                    String msg, AuditEventGrade auditEventGrade)
    {
        try
        {
            SysAuditLog sysAuditLog = new SysAuditLog();
            sysAuditLog.setAccount(this.getUserInfo().getUsername());
            sysAuditLog.setModuleName(this.autoBuilderParam.getTitle());
            sysAuditLog.setCurrentTime(new Date());
            sysAuditLog.setUserIp(this.getUserIp());
            sysAuditLog.setAuditEventName(eventName.getName());
            sysAuditLog.setMessage(msg);
            sysAuditLog.setType(this.auditEventType.getName());
            sysAuditLog.setAuditEventGrade(auditEventGrade.getName());
            sysAuditLog.setId(UUID.randomUUID().toString());
            sysAuditLogService.add(sysAuditLog);
        }
        catch (Exception ex)
        {
            logger.error(ex);
        }
    }
}
