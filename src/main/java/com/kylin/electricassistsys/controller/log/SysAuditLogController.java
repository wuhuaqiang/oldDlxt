package com.kylin.electricassistsys.controller.log;

import com.kylin.electricassistsys.controller.BaseController;
import com.kylin.electricassistsys.entity.AutoBuilderParam;
import com.kylin.electricassistsys.entity.basedata.DicParamEntity;
import com.kylin.electricassistsys.entity.basedata.DicParamType;
import com.kylin.electricassistsys.entity.log.AuditEventType;
import com.kylin.electricassistsys.entity.log.SysAuditLog;
import com.kylin.electricassistsys.service.log.SysAuditLogService;
import com.kylin.electricassistsys.utility.CustomField;
import com.kylin.electricassistsys.utility.JQGridHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by Threecolors on 2018/2/22.
 */
@Controller
@RequestMapping("/log/sysAuditLog/{type}")
public class SysAuditLogController extends BaseController<SysAuditLog,SysAuditLogService>
{
    @Autowired
    public void setService(SysAuditLogService service)
    {
        setBaseService(service);
    }

    @Autowired
    public void setRestrictAuthority()
    {
        //查看，查询，导出
        this.setRestrictAuthority(81);
    }

    @Autowired
    protected void setAuditEventType()
    {
        this.auditEventType = AuditEventType.SYS_EVENT;
    }

    @Autowired
    private void setAutoBuilderParam()
    {
        AutoBuilderParam autoBuilderParam =new AutoBuilderParam("系统审计日志", "/log/sysAuditLog", "280px", "450px", 1);
        this.setAutoBuilderParam(autoBuilderParam);
    }

    protected void buildListModel(Model model, String type) throws IllegalAccessException, InstantiationException
    {
        int auditEventType = Integer.parseInt(type);
        String typeName = AuditEventType.getName(auditEventType);
        SysAuditLog sysAuditLog = new SysAuditLog();
        sysAuditLog.setType(type);

        this.autoBuilderParam = new AutoBuilderParam(typeName+"信息", "/log/sysAuditLog","300px","500px",1);

        int buttonAuthority = this.getAuthority();
        List<CustomField> customFields = service.getCustomFields(null);
        buildQueryForm(model, customFields);
        List<SysAuditLog> entities = service.getEntitiesByConditionForJGrid(sysAuditLog,buttonAuthority);
        String jGridString = JQGridHelper.bulidJqGirdScript(autoBuilderParam.getTitle() + "列表", entities, customFields, "id", buttonAuthority);
        model.addAttribute("jGrid", jGridString);
        model.addAttribute("autoBuilderParam", autoBuilderParam);
        model.addAttribute("type", auditEventType);
    }
}
