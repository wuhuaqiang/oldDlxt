package com.kylin.electricassistsys.controller.facility;

import com.kylin.electricassistsys.controller.BaseController;
import com.kylin.electricassistsys.entity.AutoBuilderParam;
import com.kylin.electricassistsys.entity.LigerGridModel;
import com.kylin.electricassistsys.entity.enumparam.KeyValueType;
import com.kylin.electricassistsys.entity.facility.GyxlxxEntity;
import com.kylin.electricassistsys.service.KeyValueService;
import com.kylin.electricassistsys.service.facility.GyxlxxService;
import com.kylin.electricassistsys.utility.CustomField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Threecolors on 2017/12/31.
 */
@Controller
@RequestMapping("/facility/gyxlxx")
public class GyxlxxController extends BaseController<GyxlxxEntity,GyxlxxService>
{
    @Autowired
    KeyValueService keyValueService;

    @Autowired
    public void setService(GyxlxxService service)
    {
        setBaseService(service);
    }

    @Autowired
    private void setAutoBuilderParam()
    {
        AutoBuilderParam autoBuilderParam =new AutoBuilderParam("高压线路信息", "/facility/gyxlxx","600px","1250px",2);
        this.setAutoBuilderParam(autoBuilderParam);
    }

    protected  String getEditUrl()
    {
        return "facility/gyxlxxEdit";
    }

    protected  void buildEdit(Model model, GyxlxxEntity entity,String type)
    {
        HashMap<String, String>  ywdws = keyValueService.getKeyValueMap(KeyValueType.GDGS);
        model.addAttribute("ywdws", ywdws);
        HashMap<String, String> voltages = keyValueService.getKeyValueMap(KeyValueType.VOLTAGE);
        model.addAttribute("voltages", voltages);
        HashMap<String, String>  gqlxs = keyValueService.getKeyValueMap(KeyValueType.SUPPLY_ZONE_TYPE);
        model.addAttribute("gqlxs", gqlxs);

        HashMap<String, String>  qys = keyValueService.getKeyValueMap(KeyValueType.QY);
        model.addAttribute("qys", qys);

        HashMap<String, String> fsfss = keyValueService.getKeyValueMap(KeyValueType.FSFS);
        model.addAttribute("fsfss", fsfss);

        HashMap<String, String> dlxhs = keyValueService.getKeyValueMap(KeyValueType.DXCS);
        model.addAttribute("dlxhs", dlxhs);
        HashMap<String,String> ctbbs = keyValueService.getKeyValueMap(KeyValueType.CTBV);
        model.addAttribute("ctbbs", ctbbs);

        HashMap<String, String> cnws = keyValueService.getKeyValueMap(KeyValueType.CNW);
        model.addAttribute("cnws", cnws);
        HashMap<String, String> dxxhs = keyValueService.getKeyValueMap(KeyValueType.DXCS);
        model.addAttribute("dxxhs", dxxhs);
        HashMap<String, String> syfss = keyValueService.getKeyValueMap(KeyValueType.SYFS);
        model.addAttribute("syfss", syfss);

        HashMap<String, String>  qdlxs =getJdlx(entity.getQdlx());
        model.addAttribute("qdlxs", qdlxs);
        HashMap<String, String>  zdlxs =getJdlx(entity.getZdlx());
        model.addAttribute("zdlxs", zdlxs);
        model.addAttribute("entity",entity);
        model.addAttribute("autoBuilderParam", autoBuilderParam);
    }

    @ResponseBody
    @RequestMapping("/getJdlx")
    public HashMap<String, String> getJdlx(String jdlx)
    {
        return this.service.getJdlx(jdlx);
    }

    @RequestMapping("/statemet")
    public String list(Model model)
    {
        this.setRestrictAuthority(80);
        List<CustomField> customFields = service.getCustomFields(null);
        buildQueryForm(model, customFields);
        model.addAttribute("autoBuilderParam", autoBuilderParam);
//        //电压等级
//        HashMap<String, String> voltages = keyValueService.getKeyValueMap(KeyValueType.VOLTAGE);
//        //所属区域
//        HashMap<String, String> qys = keyValueService.getKeyValueMap(KeyValueType.QY);
//        model.addAttribute("voltages", voltages);
//        model.addAttribute("qys", qys);
        return "statement/gyxlStatistics";
    }

    @ResponseBody
    @RequestMapping("/statemetLoad")
    public LigerGridModel<GyxlxxEntity> statemetLoad(GyxlxxEntity entity)
    {
        int buttonAuthority = this.getAuthority();
        List<GyxlxxEntity> entities = service.getEntitiesByConditionForJGrid(entity,buttonAuthority);
        LigerGridModel<GyxlxxEntity> data = new LigerGridModel<>();
        data.setRows(entities);
        return data;
    }
}

