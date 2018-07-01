package com.kylin.electricassistsys.controller.basedata;

import com.kylin.electricassistsys.controller.BaseController;
import com.kylin.electricassistsys.entity.AutoBuilderParam;
import com.kylin.electricassistsys.entity.basedata.ZyyhxxEntity;
import com.kylin.electricassistsys.entity.enumparam.KeyValueType;
import com.kylin.electricassistsys.service.KeyValueService;
import com.kylin.electricassistsys.service.basedata.ZyyhxxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * Created by Threecolors on 2017/12/1.
 */
@Controller
@RequestMapping("/basedata/zyyhxx")
public class ZyyhxxController extends BaseController<ZyyhxxEntity, ZyyhxxService>
{
    @Autowired
    KeyValueService keyValueService;

    @Autowired
    private void setAutoBuilderParam()
    {
        AutoBuilderParam autoBuilderParam =new AutoBuilderParam("重要用户信息", "/basedata/zyyhxx","700px","950px",2);
        this.setAutoBuilderParam(autoBuilderParam);
    }

    @Autowired
    public void setService(ZyyhxxService service)
    {
        setBaseService(service);
    }
}
