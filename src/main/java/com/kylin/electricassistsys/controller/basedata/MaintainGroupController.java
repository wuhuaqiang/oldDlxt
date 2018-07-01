package com.kylin.electricassistsys.controller.basedata;

import com.kylin.electricassistsys.controller.BaseController;
import com.kylin.electricassistsys.entity.AutoBuilderParam;
import com.kylin.electricassistsys.entity.basedata.MaintainGroupEntity;
import com.kylin.electricassistsys.service.basedata.MaintainGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Threecolors on 2017/11/17.
 */
@Controller
@RequestMapping("/basedata/maintaingroup")
public class MaintainGroupController extends BaseController<MaintainGroupEntity,MaintainGroupService>
{
    @Autowired
    public void setService(MaintainGroupService service)
    {
        setBaseService(service);
    }

    @Autowired
    private void setAutoBuilderParam()
    {
        AutoBuilderParam autoBuilderParam =new AutoBuilderParam("维护班组", "/basedata/maintaingroup","300px","450px",1);
        this.setAutoBuilderParam(autoBuilderParam);
    }
}
