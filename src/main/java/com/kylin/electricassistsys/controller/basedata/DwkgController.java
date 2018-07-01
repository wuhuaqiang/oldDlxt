package com.kylin.electricassistsys.controller.basedata;

import com.kylin.electricassistsys.controller.BaseController;
import com.kylin.electricassistsys.entity.AutoBuilderParam;
import com.kylin.electricassistsys.entity.basedata.DwkgEntity;
import com.kylin.electricassistsys.service.basedata.DwkgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * Created by Threecolors on 2017/11/19.
 */
@Controller
@RequestMapping("/basedata/dwkg")
public class DwkgController extends BaseController<DwkgEntity,DwkgService>
{
    @Autowired
    public void setService(DwkgService service)
    {
        setBaseService(service);
    }

    @Autowired
    private void setAutoBuilderParam()
    {
        AutoBuilderParam autoBuilderParam =new AutoBuilderParam("电网开关类设施和设备情况信息", "/basedata/dwkg", "520px", "450px", 1);
        this.setAutoBuilderParam(autoBuilderParam);
    }
}
