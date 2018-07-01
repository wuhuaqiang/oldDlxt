package com.kylin.electricassistsys.controller.basedata;

import com.kylin.electricassistsys.controller.BaseController;
import com.kylin.electricassistsys.entity.AutoBuilderParam;
import com.kylin.electricassistsys.entity.basedata.DyxxEntity;
import com.kylin.electricassistsys.service.basedata.DyxxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Threecolors on 2017/11/30.
 */
@Controller
@RequestMapping("/basedata/dyxx")
public class DyxxController extends BaseController<DyxxEntity,DyxxService>
{
    @Autowired
    public void setService(DyxxService service)
    {
        setBaseService(service);
    }

    @Autowired
    private void setAutoBuilderParam()
    {
        AutoBuilderParam autoBuilderParam =new AutoBuilderParam("电源信息", "/basedata/dyxx","450px","1050px",3);
        this.setAutoBuilderParam(autoBuilderParam);
    }
}
