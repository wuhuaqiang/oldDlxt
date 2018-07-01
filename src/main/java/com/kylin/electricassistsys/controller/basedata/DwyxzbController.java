package com.kylin.electricassistsys.controller.basedata;

import com.kylin.electricassistsys.controller.BaseController;
import com.kylin.electricassistsys.entity.AutoBuilderParam;
import com.kylin.electricassistsys.entity.basedata.DwyxzbEntity;
import com.kylin.electricassistsys.service.basedata.DwyxzbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Threecolors on 2017/11/18.
 * 电网运行指标
 * */
@Controller
@RequestMapping("/basedata/dwyxzb")
public class DwyxzbController extends BaseController<DwyxzbEntity,DwyxzbService>
{
    @Autowired
    public void setService(DwyxzbService service)
    {
        setBaseService(service);
    }

    @Autowired
    private void setAutoBuilderParam()
    {
        AutoBuilderParam autoBuilderParam =new AutoBuilderParam("电网运行指标信息", "/basedata/dwyxzb","520px","450px",1);
        this.setAutoBuilderParam(autoBuilderParam);
    }
}
