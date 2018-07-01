package com.kylin.electricassistsys.controller.basedata;

import com.kylin.electricassistsys.controller.BaseController;
import com.kylin.electricassistsys.entity.AutoBuilderParam;
import com.kylin.electricassistsys.entity.basedata.DxcsEntity;
import com.kylin.electricassistsys.service.basedata.DxcsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Threecolors on 2017/11/20.
 */
@Controller
@RequestMapping("/basedata/dxcs")
public class DxcsController extends BaseController<DxcsEntity,DxcsService>
{
    @Autowired
    public void setService(DxcsService service)
    {
        setBaseService(service);
    }

    @Autowired
    private void setAutoBuilderParam()
    {
        AutoBuilderParam autoBuilderParam =new AutoBuilderParam("导线参数信息", "/basedata/dxcs", "500px", "900px", 2);
        this.setAutoBuilderParam(autoBuilderParam);
    }
}
