package com.kylin.electricassistsys.controller.basedata;

import com.kylin.electricassistsys.controller.BaseController;
import com.kylin.electricassistsys.entity.AutoBuilderParam;
import com.kylin.electricassistsys.entity.basedata.AutoDistributeInfoEntity;
import com.kylin.electricassistsys.service.basedata.AutoDistributeInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * Created by Threecolors on 2017/11/17.
 */
@Controller
@RequestMapping("/basedata/autodistributeinfo")
public class AutoDistributeInfoController extends BaseController<AutoDistributeInfoEntity, AutoDistributeInfoService>
{
    @Autowired
    private void setService(AutoDistributeInfoService service)
    {
        setBaseService(service);
    }

    @Autowired
    private void setAutoBuilderParam()
    {
        AutoBuilderParam autoBuilderParam =new AutoBuilderParam("配电自动化信息", "/basedata/autodistributeinfo", "400px", "450px", 1);
        this.setAutoBuilderParam(autoBuilderParam);
    }
}
