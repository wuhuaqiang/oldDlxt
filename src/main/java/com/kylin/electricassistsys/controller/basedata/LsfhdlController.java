package com.kylin.electricassistsys.controller.basedata;

import com.kylin.electricassistsys.controller.BaseController;
import com.kylin.electricassistsys.entity.AutoBuilderParam;
import com.kylin.electricassistsys.entity.basedata.DicParamEntity;
import com.kylin.electricassistsys.entity.basedata.DicParamType;
import com.kylin.electricassistsys.entity.basedata.LsfhdlEntity;
import com.kylin.electricassistsys.entity.enumparam.KeyValueType;
import com.kylin.electricassistsys.service.KeyValueService;
import com.kylin.electricassistsys.service.basedata.DicParamService;
import com.kylin.electricassistsys.service.basedata.LsfhdlService;
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
 */
@Controller
@RequestMapping("/basedata/lsfhdl")
public class LsfhdlController extends BaseController<LsfhdlEntity,LsfhdlService>
{
    @Autowired
    KeyValueService keyValueService;

    @Autowired
    public void setService(LsfhdlService service)
    {
        setBaseService(service);
    }

    @Autowired
    private void setAutoBuilderParam()
    {
        AutoBuilderParam autoBuilderParam =new AutoBuilderParam("历史负荷电量信息", "/basedata/lsfhdl","470px","1200px",2);
        this.setAutoBuilderParam(autoBuilderParam);
    }

    protected  String getEditUrl()
    {
        return "basedata/lsfhdlEdit";
    }

    protected  void buildEdit(Model model, LsfhdlEntity zyyhxxEntity)
    {
        HashMap<String, String> gqlxs = keyValueService.getKeyValueMap(KeyValueType.SUPPLY_ZONE_TYPE);
        model.addAttribute("gqlxs", gqlxs);

        HashMap<String, String>  qyMaps = keyValueService.getKeyValueMap(KeyValueType.QY);
        model.addAttribute("qyMaps", qyMaps);

        model.addAttribute("entity",zyyhxxEntity);
    }
}

