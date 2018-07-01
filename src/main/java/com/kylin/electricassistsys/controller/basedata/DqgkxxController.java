package com.kylin.electricassistsys.controller.basedata;

import com.kylin.electricassistsys.controller.BaseController;
import com.kylin.electricassistsys.entity.AutoBuilderParam;
import com.kylin.electricassistsys.entity.basedata.DicParamEntity;
import com.kylin.electricassistsys.entity.basedata.DicParamType;
import com.kylin.electricassistsys.entity.basedata.DqgkxxEntity;
import com.kylin.electricassistsys.entity.enumparam.KeyValueType;
import com.kylin.electricassistsys.service.KeyValueService;
import com.kylin.electricassistsys.service.basedata.DicParamService;
import com.kylin.electricassistsys.service.basedata.DqgkxxService;
import com.kylin.electricassistsys.service.basedata.PowerSupplyZoneService;
import com.kylin.electricassistsys.utility.JQGridColModel;
import com.kylin.electricassistsys.utility.QueryFormHelper;
import com.kylin.electricassistsys.utility.TagType;
import com.kylin.electricassistsys.utility.UIElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * Created by Threecolors on 2017/11/29.
 * 地区概况
 */
@Controller
@RequestMapping("/basedata/dqgkxx")
public class DqgkxxController extends BaseController<DqgkxxEntity,DqgkxxService>
{
    @Autowired
    KeyValueService keyValueService;

    @Autowired
    public void setService(DqgkxxService service)
    {
        setBaseService(service);
    }

    @Autowired
    private void setAutoBuilderParam()
    {
        AutoBuilderParam autoBuilderParam =new AutoBuilderParam("地区概况信息", "/basedata/dqgkxx","430px","700px",2);
        this.setAutoBuilderParam(autoBuilderParam);
    }

    protected  String getEditUrl()
    {
        return "basedata/dqgkxxEdit";
    }

    protected  void buildEdit(Model model, DqgkxxEntity dqgkxxEntity)
    {
        HashMap<String, String> gqlxs = keyValueService.getKeyValueMap(KeyValueType.SUPPLY_ZONE_TYPE);
        model.addAttribute("gqlxs", gqlxs);

        HashMap<String, String>  qyMaps = keyValueService.getKeyValueMap(KeyValueType.QY);
        model.addAttribute("qyMaps", qyMaps);

        model.addAttribute("entity",dqgkxxEntity);
    }
}
