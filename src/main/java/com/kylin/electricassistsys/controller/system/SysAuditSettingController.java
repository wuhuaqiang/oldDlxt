package com.kylin.electricassistsys.controller.system;

import com.kylin.electricassistsys.controller.AuthorityController;
import com.kylin.electricassistsys.entity.AutoBuilderParam;
import com.kylin.electricassistsys.entity.ProcessResult;
import com.kylin.electricassistsys.entity.log.*;
import com.kylin.electricassistsys.service.log.LoginLogService;
import com.kylin.electricassistsys.service.log.SysAuditLogService;
import com.kylin.electricassistsys.service.system.SysAuditSettingService;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.UUID;

/**
 * Created by Threecolors on 2018/3/15.
 */
@Controller
@RequestMapping("/system/sysAuditSetting")
public class SysAuditSettingController extends AuthorityController
{
    protected final Log logger = LogFactory.getLog(this.getClass());

    @Autowired
    protected SysAuditLogService sysAuditLogService;

    @Autowired
    private SysAuditSettingService service;

    @Autowired
    private LoginLogService loginLogService;

    private AutoBuilderParam autoBuilderParam =new AutoBuilderParam("系统设置", "/system/sysAuditSetting", "450px", "900px", 1);

    private AuditEventType auditEventType = AuditEventType.SYS_EVENT;

    @RequestMapping(method = RequestMethod.GET)
    public String sysAuditSetting(Model model)
    {
        SysAuditSetting sysSetting =  service.getSysAuditSetting();
        model.addAttribute("entity",sysSetting);
        model.addAttribute("autoBuilderParam",autoBuilderParam);
        return "system/sysAuditSetting";
    }

    @ResponseBody
    @RequestMapping(value = {"/deleteAuditLog"},method = RequestMethod.POST)
    public  ProcessResult deleteAuditLog()
    {
        String msg = "删除冗余系统审核日志失败";
        AuditEventGrade auditEventGrade = AuditEventGrade.INFO;
        ProcessResult processResult = new ProcessResult();
        try
        {
            SysAuditSetting sysSetting = service.getSysAuditSetting();
            int count = 0;
            count+= sysAuditLogService.deleteRedundancyLog();
            count += loginLogService.deleteRedundancyLog();
            processResult.setCount(count);
            processResult.setSuccess(true);
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
            this.writeSysAuditLog(AuditEventName.DELETE, processResult.isSuccess() ? "删除冗余系统审核日志成功" : msg, auditEventGrade);
        }

        return processResult;
    }


    @ResponseBody
    @RequestMapping(value = {"/saveModify","/saveAdd"},method = RequestMethod.POST)
    public ProcessResult save(@Validated SysAuditSetting entity) throws Exception
    {
        String msg = "保存系统审计设置失败";
        AuditEventGrade auditEventGrade = AuditEventGrade.INFO;
        ProcessResult processResult = new ProcessResult();
        try
        {
            SysAuditSetting sysAuditSetting = service.getSysAuditSetting();
            if (StringUtils.isEmpty(sysAuditSetting.getId()))
            {
                entity.setId(UUID.randomUUID().toString());
                if (service.insertSelective(entity))
                {
                    processResult.setSuccess(true);
                }
            }
            else if (StringUtils.equals(sysAuditSetting.getId(), entity.getId()))
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
            logger.error("保存系统审计设置出错",ex);
            throw ex;
        }
        finally
        {
            this.writeSysAuditLog(AuditEventName.MODIFY, processResult.isSuccess() ? "保存系统审计设置成功" : msg, auditEventGrade);
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
