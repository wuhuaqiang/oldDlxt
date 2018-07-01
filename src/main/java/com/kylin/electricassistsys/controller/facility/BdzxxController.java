package com.kylin.electricassistsys.controller.facility;

import com.kylin.electricassistsys.controller.BaseController;
import com.kylin.electricassistsys.controller.BaseController;
import com.kylin.electricassistsys.entity.AutoBuilderParam;
import com.kylin.electricassistsys.entity.LigerGridModel;
import com.kylin.electricassistsys.entity.basedata.DicParamEntity;
import com.kylin.electricassistsys.entity.basedata.ZyyhxxEntity;
import com.kylin.electricassistsys.entity.enumparam.KeyValueType;
import com.kylin.electricassistsys.entity.facility.BdzxxEntity;
import com.kylin.electricassistsys.entity.facility.ByqxxEntity;
import com.kylin.electricassistsys.service.KeyValueService;
import com.kylin.electricassistsys.service.basedata.ZyyhxxService;
import com.kylin.electricassistsys.service.facility.BdzxxService;
import com.kylin.electricassistsys.service.facility.ByqxxService;
import com.kylin.electricassistsys.utility.CustomField;
import com.kylin.electricassistsys.utility.JQGridColModel;
import com.kylin.electricassistsys.utility.JQGridHelper;
import com.kylin.electricassistsys.utility.StringHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * Created by Threecolors on 2017/12/1.
 */
@Controller
@RequestMapping("/facility/bdzxx")
public class BdzxxController extends BaseController<BdzxxEntity,BdzxxService>
{
    @Autowired
    KeyValueService keyValueService;

    @Autowired
    ByqxxService byqxxService;

    @Autowired
    public void setService(BdzxxService service)
    {
        setBaseService(service);
    }

    @Autowired
    private void setAutoBuilderParam()
    {
        AutoBuilderParam autoBuilderParam =new AutoBuilderParam("变电站信息", "/facility/bdzxx", "550px", "1250px", 2);
        this.setAutoBuilderParam(autoBuilderParam);
    }

    protected String getEditUrl()
    {
        return "facility/bdzxxEdit";
    }

    protected void buildEdit(HttpServletRequest request, Model model, BdzxxEntity entity, String type)
    {
        //电压等级
        HashMap<String, String> voltages = keyValueService.getKeyValueMap(KeyValueType.VOLTAGE);

        //运维单位(供电公司)
        HashMap<String, String> ywdws = keyValueService.getKeyValueMap(KeyValueType.GDGS);

        //所属区域
        HashMap<String, String> qys = keyValueService.getKeyValueMap(KeyValueType.QY);

        //供区类型
        HashMap<String, String> gqlxs = keyValueService.getKeyValueMap(KeyValueType.SUPPLY_ZONE_TYPE);

        //安装形式
        HashMap<String, String> azxss = keyValueService.getKeyValueMap(KeyValueType.AZXS);

        //使用方式（变电站属性）
        HashMap<String, String> syfss = keyValueService.getKeyValueMap(KeyValueType.SYFS);

        //城农网
        HashMap<String, String> cnws = keyValueService.getKeyValueMap(KeyValueType.CNW);

        //高压配电装置类型
        HashMap<String, String> gypdzzlxs = keyValueService.getKeyValueMap(KeyValueType.GYPDZZLX);

        //变压器
        List<ByqxxEntity> byqs = byqxxService.getByqxxByBdzId(entity.getId());

        //主接线
        HashMap<String, String> zjxs = keyValueService.getKeyValueMap(KeyValueType.ZJX);

        model.addAttribute("voltages", voltages);
        model.addAttribute("ywdws", ywdws);
        model.addAttribute("qys", qys);
        model.addAttribute("gqlxs", gqlxs);
        model.addAttribute("azxss", azxss);
        model.addAttribute("syfss", syfss);
        model.addAttribute("cnws", cnws);
        model.addAttribute("gypdzzlxs", gypdzzlxs);
        model.addAttribute("byqs", byqs);
        model.addAttribute("zjxs", zjxs);
        model.addAttribute("entity",entity);
        model.addAttribute("autoBuilderParam", autoBuilderParam);
    }

    @ResponseBody
    @RequestMapping("/getBdzxx")
    public BdzxxEntity getBdzxx(@RequestParam(value = "id", required = false, defaultValue = "") String id)
    {
        return this.service.getBdzxxByBdzId(id);
    }

    @RequestMapping("/statemet")
    public String list(Model model)
    {
        this.setRestrictAuthority(80);
        List<CustomField> customFields = service.getCustomFields(null);
        buildQueryForm(model, customFields);
        model.addAttribute("autoBuilderParam", autoBuilderParam);

        return "statement/bdzStatistics";
    }

    @ResponseBody
    @RequestMapping("/statemetLoad")
    public LigerGridModel<BdzxxEntity> statemetLoad(BdzxxEntity entity)
    {
        int buttonAuthority = this.getAuthority();
        List<BdzxxEntity> entities = service.getEntitiesByConditionForJGrid(entity,buttonAuthority);
        LigerGridModel<BdzxxEntity> data = new LigerGridModel<>();
        data.setRows(entities);
        return data;
    }
}
