package com.kylin.electricassistsys.controller.basedata;

import com.kylin.electricassistsys.controller.BaseController;
import com.kylin.electricassistsys.entity.AutoBuilderParam;
import com.kylin.electricassistsys.entity.basedata.XldxjmEntity;
import com.kylin.electricassistsys.service.basedata.XldxjmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Threecolors on 2017/11/18.
 */
@Controller
@RequestMapping("/basedata/xldxjm")
public class XldxjmController extends BaseController<XldxjmEntity,XldxjmService>
{
    @Autowired
    public void setService(XldxjmService service)
    {
        setBaseService(service);
    }

    @Autowired
    private void setAutoBuilderParam()
    {
        AutoBuilderParam autoBuilderParam =new AutoBuilderParam("导线截面信息", "/basedata/xldxjm", "500px", "450px", 1);
        this.setAutoBuilderParam(autoBuilderParam);
    }
}
