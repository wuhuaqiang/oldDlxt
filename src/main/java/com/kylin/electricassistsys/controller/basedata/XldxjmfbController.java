package com.kylin.electricassistsys.controller.basedata;

import com.kylin.electricassistsys.controller.BaseController;
import com.kylin.electricassistsys.entity.AutoBuilderParam;
import com.kylin.electricassistsys.entity.basedata.XldxjmfbEntity;
import com.kylin.electricassistsys.service.basedata.XldxjmfbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Threecolors on 2017/11/18.
 */
@Controller
@RequestMapping("/basedata/xldxjmfb")
public class XldxjmfbController extends BaseController<XldxjmfbEntity,XldxjmfbService>
{
    @Autowired
    public void setService(XldxjmfbService service)
    {
        setBaseService(service);
    }

    @Autowired
    private void setAutoBuilderParam()
    {
        AutoBuilderParam autoBuilderParam =new AutoBuilderParam("导线截面分布信息", "/basedata/xldxjmfb", "400px", "900px", 2);
        this.setAutoBuilderParam(autoBuilderParam);
    }
}
