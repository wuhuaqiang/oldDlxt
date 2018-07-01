package com.kylin.electricassistsys.controller.basedata;

import com.kylin.electricassistsys.controller.BaseController;
import com.kylin.electricassistsys.entity.AutoBuilderParam;
import com.kylin.electricassistsys.entity.basedata.DwpbsbEntity;
import com.kylin.electricassistsys.service.basedata.DwpbsbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Threecolors on 2017/11/18.
 */
@Controller
@RequestMapping("/basedata/dwpbsb")
public class DwpbsbController extends BaseController<DwpbsbEntity,DwpbsbService>
{
    @Autowired
    public void setService(DwpbsbService service)
    {
        setBaseService(service);
    }

    @Autowired
    private void setAutoBuilderParam()
    {
        AutoBuilderParam autoBuilderParam =new AutoBuilderParam("电网配变设备信息", "/basedata/dwpbsb","500px","1000px",2);
        this.setAutoBuilderParam(autoBuilderParam);
    }
}
