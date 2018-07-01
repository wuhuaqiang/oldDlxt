package com.kylin.electricassistsys.controller.basedata;

import com.kylin.electricassistsys.controller.BaseController;
import com.kylin.electricassistsys.entity.AutoBuilderParam;
import com.kylin.electricassistsys.entity.basedata.PowerSupplyZoneEntity;
import com.kylin.electricassistsys.service.basedata.PowerSupplyZoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Threecolors on 2017/11/17.
 */
@Controller
@RequestMapping("basedata/powersupplyzone")
public class PowerSupplyZoneController extends BaseController<PowerSupplyZoneEntity,PowerSupplyZoneService>
{
    @Autowired
    public void setService(PowerSupplyZoneService service)
    {
        setBaseService(service);
    }

    @Autowired
    private void setAutoBuilderParam()
    {
        AutoBuilderParam autoBuilderParam = new AutoBuilderParam("供区信息", "/basedata/powersupplyzone", "300px", "500px",
                                                                 1);
        this.setAutoBuilderParam(autoBuilderParam);
    }
}
