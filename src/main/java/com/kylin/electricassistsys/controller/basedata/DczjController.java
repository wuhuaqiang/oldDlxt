package com.kylin.electricassistsys.controller.basedata;

import com.kylin.electricassistsys.controller.BaseController;
import com.kylin.electricassistsys.entity.AutoBuilderParam;
import com.kylin.electricassistsys.entity.basedata.DczjEntity;
import com.kylin.electricassistsys.service.basedata.DczjService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Threecolors on 2017/11/19.
 */
@Controller
@RequestMapping("/basedata/dczj")
public class DczjController extends BaseController<DczjEntity,DczjService>
{
    @Autowired
    public void setService(DczjService service)
    {
        setBaseService(service);
    }

    @Autowired
    private void setAutoBuilderParam()
    {
        AutoBuilderParam autoBuilderParam =new AutoBuilderParam("电厂装机信息", "/basedata/dczj", "280px", "450px", 1);
        this.setAutoBuilderParam(autoBuilderParam);
    }
}
