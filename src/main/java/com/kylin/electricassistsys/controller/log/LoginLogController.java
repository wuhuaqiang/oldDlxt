package com.kylin.electricassistsys.controller.log;

import com.kylin.electricassistsys.controller.BaseController;
import com.kylin.electricassistsys.entity.AutoBuilderParam;
import com.kylin.electricassistsys.entity.log.AuditEventType;
import com.kylin.electricassistsys.entity.log.LoginLog;
import com.kylin.electricassistsys.service.log.LoginLogService;
import com.kylin.electricassistsys.utility.CustomField;
import com.kylin.electricassistsys.utility.JQGridHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by Threecolors on 2018/3/15.
 */
@Controller
@RequestMapping("/log/loginLog")
public class LoginLogController extends BaseController<LoginLog,LoginLogService>
{
    @Autowired
    public void setService(LoginLogService service)
    {
        setBaseService(service);
    }
    @Autowired
    protected void setAuditEventType()
    {
        this.auditEventType = AuditEventType.SYS_EVENT;
    }


    @Autowired
    public void setRestrictAuthority()
    {
        //查看，查询，导出
        this.setRestrictAuthority(81);
    }

    @Autowired
    private void setAutoBuilderParam()
    {
        AutoBuilderParam autoBuilderParam =new AutoBuilderParam("用户登录日志", "/log/loginLog", "280px", "450px", 1);
        this.setAutoBuilderParam(autoBuilderParam);
    }
}
