package com.kylin.electricassistsys.controller.system;

import com.kylin.electricassistsys.controller.BaseController;
import com.kylin.electricassistsys.entity.AutoBuilderParam;
import com.kylin.electricassistsys.entity.log.AuditEventType;
import com.kylin.electricassistsys.entity.system.UnitEntity;
import com.kylin.electricassistsys.service.system.UnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Threecolors on 2017/11/14.
 */
@Controller
@RequestMapping("/system/unit")
public class UnitController extends BaseController<UnitEntity,UnitService>
{
    @Autowired
    private void setService(UnitService service)
    {
        setBaseService(service);
    }

    @Autowired
    protected void setAuditEventType()
    {
        this.auditEventType = AuditEventType.SYS_EVENT;
    }

    @Autowired
    private void setAutoBuilderParam()
    {
        AutoBuilderParam autoBuilderParam = new AutoBuilderParam("单位信息", "/system/unit","360px","550px",1);
        this.setAutoBuilderParam(autoBuilderParam);
    }
}
