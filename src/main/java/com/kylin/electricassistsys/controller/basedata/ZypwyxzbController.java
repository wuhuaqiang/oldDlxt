package com.kylin.electricassistsys.controller.basedata;

import com.kylin.electricassistsys.controller.BaseController;
import com.kylin.electricassistsys.entity.AutoBuilderParam;
import com.kylin.electricassistsys.entity.basedata.ZypwyxzbEntity;
import com.kylin.electricassistsys.service.basedata.ZypwyxzbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Threecolors on 2017/12/1.
 */
@Controller
@RequestMapping("/basedata/zypwyxzb")
public class ZypwyxzbController extends BaseController<ZypwyxzbEntity,ZypwyxzbService>
{
    @Autowired
    public void setService(ZypwyxzbService service)
    {
        setBaseService(service);
    }

    @Autowired
    private void setAutoBuilderParam()
    {
        AutoBuilderParam autoBuilderParam =new AutoBuilderParam("中压配网运行指标信息", "/basedata/zypwyxzb","400px","740px",2);
        this.setAutoBuilderParam(autoBuilderParam);
    }
}
