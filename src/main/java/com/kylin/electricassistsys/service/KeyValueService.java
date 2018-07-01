package com.kylin.electricassistsys.service;

import com.kylin.electricassistsys.entity.enumparam.KeyValueType;
import com.kylin.electricassistsys.service.basedata.DicParamService;
import com.kylin.electricassistsys.service.basedata.DxcsService;
import com.kylin.electricassistsys.service.basedata.PowerSupplyZoneService;
import com.kylin.electricassistsys.service.basedata.ZyyhxxService;
import com.kylin.electricassistsys.service.facility.BdzxxService;
import com.kylin.electricassistsys.service.facility.ByqxxService;
import com.kylin.electricassistsys.service.facility.GyxlxxService;
import com.kylin.electricassistsys.service.system.UnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * Created by Threecolors on 2017/11/30.
 */
@Service
public class KeyValueService
{
    @Autowired
    private DicParamService dicParamService;

    @Autowired
    private PowerSupplyZoneService powerSupplyZoneService;

    @Autowired
    private BdzxxService bdzxxService;

    @Autowired
    private UnitService unitService;

    @Autowired
    private DxcsService dxcsService;

    @Autowired
    private ZyyhxxService zyyhxxService;

    @Autowired
    private GyxlxxService gyxlxxService;

    public HashMap<String, String> getKeyValueMap(KeyValueType keyValueType)
    {
        HashMap<String, String> resultMap = new LinkedHashMap<>();
        resultMap.put("","---请选择---");
        HashMap<String, String> map = new LinkedHashMap<>();
        switch (keyValueType)
        {
            case QY:
                map = powerSupplyZoneService.getPowerSupplyZoneKeyName();
                break;
            case OPERATING_STATE:
                map = getOperatingState();
                break;
            case BDZ:
                map =bdzxxService.getBdzKeyName();
                break;
            case GDGS:
                map = unitService.getUnitKeyName();
                break;
            case ADMINISTRATIVE_LEVEL:
                map = getAdministrativeLevel();
                break;
            case STATUS:
                map = getStatus();
                break;
            case WIRE_TYPE:
                map = getWireType();
                break;
            case DXCS:
                map = dxcsService.getDxcsKeyName();
                break;
            case ZYYH:
                map = zyyhxxService.getKeyName();
                break;
            case GYXLXX:
                map = gyxlxxService.getKeyName();
                break;
            default:
                map = dicParamService.getDicByType(keyValueType.getIndex());
                break;
        }
        resultMap.putAll(map);
        return  resultMap;
    }

    private HashMap<String, String> getOperatingState()
    {
        HashMap<String, String> map = new LinkedHashMap<>();
        map.put("现有","现有");
        map.put("投运","投运");
        map.put("退役","退役");
        return  map;
    }

    private HashMap<String,String> getStatus()
    {
        HashMap<String, String> map = new LinkedHashMap<>();
        map.put("有效","有效");
        map.put("无效","无效");
        return  map;
    }

    private HashMap<String,String> getAdministrativeLevel()
    {
        HashMap<String, String> map = new LinkedHashMap<>();
        map.put("省级","省级");
        map.put("市级","市级");
        map.put("县级","县级");
        return  map;
    }

    private HashMap<String,String> getWireType()
    {
        HashMap<String, String> map = new LinkedHashMap<>();
        map.put("电缆","电缆");
        map.put("架空裸导线","架空裸导线");
        map.put("架空绝缘线","架空绝缘线");

        return  map;
    }
}
