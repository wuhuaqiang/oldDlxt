package com.kylin.electricassistsys.controller.system;

import com.kylin.electricassistsys.controller.BaseController;
import com.kylin.electricassistsys.entity.AutoBuilderParam;
import com.kylin.electricassistsys.entity.CommonEntity;
import com.kylin.electricassistsys.entity.ProcessResult;
import com.kylin.electricassistsys.entity.log.AuditEventGrade;
import com.kylin.electricassistsys.entity.log.AuditEventName;
import com.kylin.electricassistsys.entity.log.AuditEventType;
import com.kylin.electricassistsys.entity.system.RoleEntity;
import com.kylin.electricassistsys.entity.system.UserRoleEntity;
import com.kylin.electricassistsys.entity.system.UserSetRoleEntity;
import com.kylin.electricassistsys.service.system.RoleService;
import com.kylin.electricassistsys.service.system.UnitService;
import com.kylin.electricassistsys.utility.JQGridColModel;
import com.kylin.electricassistsys.utility.JQGridHelper;
import com.kylin.electricassistsys.utility.StringHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by Threecolors on 2017/11/14.
 */
@Controller
@RequestMapping("/system/role")
public class RoleController extends BaseController<RoleEntity, RoleService>
{
    @Autowired
    public void setService(RoleService service)
    {
        setBaseService(service);
    }

    @Autowired
    private void setAutoBuilderParam()
    {
        AutoBuilderParam autoBuilderParam = new AutoBuilderParam("角色信息", "/system/role", "300px", "550px", 1);
        this.setAutoBuilderParam(autoBuilderParam);
    }

    @Autowired
    protected void setAuditEventType()
    {
        this.auditEventType = AuditEventType.SYS_EVENT;
    }

    protected String getListUrl()
    {
        return "system/rolelist";
    }

    @RequestMapping("/getAll")
    public String getAll(@RequestParam(value = "id") String id,
                         Model model)
    {
        List<UserSetRoleEntity> userSetRoleEntityList = this.service.getUserSetRoleEntity(id);
        model.addAttribute("roles", userSetRoleEntityList);
        model.addAttribute("userId", id);
        model.addAttribute("autoBuilderParam", autoBuilderParam);
        return "system/userSetRole";
    }

    @ResponseBody
    @RequestMapping("/saveUserSetRole")
    public ProcessResult saveUserSetRole(UserRoleEntity userRoleEntity)
    {
        String msg = "设置用户角色失败";
        AuditEventGrade auditEventGrade = AuditEventGrade.INFO;
        ProcessResult processResult = new ProcessResult();
        try
        {
            processResult.setSuccess(service.saveUserSetRole(userRoleEntity));
        }
        catch (Exception ex)
        {
            auditEventGrade = AuditEventGrade.ERROR;
            msg = "系统异常：" + ex.getMessage();
            throw ex;
        }
        finally
        {
            this.writeSysAuditLog(AuditEventName.MODIFY,processResult.isSuccess() ? "设置用户角色成功" : msg,
                                  auditEventGrade);
        }
        return processResult;
    }

    @ResponseBody
    @RequestMapping("/saveRoleAuthority")
    public ProcessResult saveRoleAuthority(@RequestParam(value = "roleId") String roleId,
                                           @RequestParam(value = "ckNavi", required = false, defaultValue = "") String ckNavi,
                                           @RequestParam(value = "ckButtonQx", required = false, defaultValue = "") String ckButtonQx)
    {
        String msg = "设置角色权限失败";
        AuditEventGrade auditEventGrade = AuditEventGrade.INFO;
        ProcessResult processResult = new ProcessResult();
        try
        {
            processResult.setSuccess(service.saveRoleAuthority(roleId, ckNavi, ckButtonQx));
        }
        catch (Exception ex)
        {
            auditEventGrade = AuditEventGrade.ERROR;
            msg = "系统异常：" + ex.getMessage();
            throw ex;
        }
        finally
        {
            this.writeSysAuditLog(AuditEventName.MODIFY, processResult.isSuccess()  ? "设置角色权限成功" : msg,
                                  auditEventGrade);
        }

        return processResult;

    }
}
