package com.kylin.electricassistsys.controller.facility;

import com.kylin.electricassistsys.controller.BaseController;
import com.kylin.electricassistsys.entity.AutoBuilderParam;
import com.kylin.electricassistsys.entity.enumparam.KeyValueType;
import com.kylin.electricassistsys.entity.facility.DyxlxxEntity;
import com.kylin.electricassistsys.service.KeyValueService;
import com.kylin.electricassistsys.service.facility.DyxlxxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;

/**
 * Created by Threecolors on 2017/12/31.
 */
@Controller
@RequestMapping("/facility/dyxlxx")
public class DyxlxxController extends BaseController<DyxlxxEntity,DyxlxxService>
{
    @Autowired
    KeyValueService keyValueService;

    @Autowired
    public void setService(DyxlxxService service)
    {
        setBaseService(service);
    }

    @Autowired
    private void setAutoBuilderParam()
    {
        AutoBuilderParam autoBuilderParam =new AutoBuilderParam("低压线路信息", "/facility/dyxlxx","600px","1250px",2);
        this.setAutoBuilderParam(autoBuilderParam);
    }

    protected  String getEditUrl()
    {
        return "facility/dyxlxxEdit";
    }

    protected  void buildEdit(Model model, DyxlxxEntity entity,String type)
    {
        HashMap<String, String>  ywdws = keyValueService.getKeyValueMap(KeyValueType.GDGS);
        model.addAttribute("ywdws", ywdws);

        HashMap<String, String>  gqlxs = keyValueService.getKeyValueMap(KeyValueType.SUPPLY_ZONE_TYPE);
        model.addAttribute("gqlxs", gqlxs);

        HashMap<String, String>  qys = keyValueService.getKeyValueMap(KeyValueType.QY);
        model.addAttribute("qys", qys);

        HashMap<String, String> fsfss = keyValueService.getKeyValueMap(KeyValueType.FSFS);
        model.addAttribute("fsfss", fsfss);

        HashMap<String, String> dlxhs = keyValueService.getKeyValueMap(KeyValueType.DXCS);
        model.addAttribute("dlxhs", dlxhs);

        model.addAttribute("entity",entity);
        model.addAttribute("autoBuilderParam", autoBuilderParam);
    }
}
