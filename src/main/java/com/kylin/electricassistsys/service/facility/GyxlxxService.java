package com.kylin.electricassistsys.service.facility;

import com.kylin.electricassistsys.entity.enumparam.KeyValueType;
import com.kylin.electricassistsys.entity.facility.GyxlxxEntity;
import com.kylin.electricassistsys.mapper.facility.GyxlxxMapper;
import com.kylin.electricassistsys.service.BaseService;
import com.kylin.electricassistsys.service.KeyValueService;
import com.kylin.electricassistsys.utility.StringHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by Threecolors on 2017/12/31.
 */
@Service
public class GyxlxxService extends BaseService<GyxlxxEntity>
{
    private GyxlxxMapper mapper;

    @Autowired
    KeyValueService keyValueService;

    @Autowired
    public void setMapper(GyxlxxMapper mapper)
    {
        this.mapper = mapper;
        setBaseMapper(mapper);
    }

    public HashMap<String, String> getKeyName()
    {
        HashMap<String, String> map = new LinkedHashMap<>();
        List<GyxlxxEntity> entities = mapper.selectAll();
        for (GyxlxxEntity entity  :entities)
        {
            map.put(entity.getId(),entity.getXlmc());
        }

        return  map;
    }

    public List<GyxlxxEntity> getEntitiesByCondition(GyxlxxEntity conditionEntity)
    {
        List<GyxlxxEntity> entities = mapper.getEntitiesByCondition(conditionEntity);

        HashMap<String, String> jdlx = getAllJdlx();
        for(GyxlxxEntity entity: entities)
        {
            entity.setSjqdName(jdlx.get(entity.getSjqd()));
            entity.setSjzdName(jdlx.get(entity.getSjzd()));
        }

        return  entities;
    }

    private HashMap<String, String> getAllJdlx()
    {
        HashMap<String, String> map = new LinkedHashMap<>();
        map = keyValueService.getKeyValueMap(KeyValueType.BDZ);
        map.putAll(keyValueService.getKeyValueMap(KeyValueType.ZYYH));
        map.putAll(keyValueService.getKeyValueMap(KeyValueType.GYXLXX));
        return  map;
    }

    public HashMap<String, String> getJdlx(String jdlx)
    {
        HashMap<String, String> map = new LinkedHashMap<>();
        if(!StringHelper.isNullOrWhiteSpace(jdlx))
        {
            switch (jdlx)
            {
                case "变电站":
                    map = keyValueService.getKeyValueMap(KeyValueType.BDZ);
                    break;
                case "重要用户":
                    map = keyValueService.getKeyValueMap(KeyValueType.ZYYH);
                    break;
                case "电源":
                    //map = keyValueService.getKeyValueMap(KeyValueType.BDZ);
                    break;
                case "线路":
                    map = keyValueService.getKeyValueMap(KeyValueType.GYXLXX);
                    break;
            }
        }

        return map;
    }

    /**
     * 特殊处理，转化字段展示和数据库存储不一致的情况
     *
     * @param entity
     */
    protected void specialProcessForField(GyxlxxEntity entity,String type)
    {
        Map<String,String> map = keyValueService.getKeyValueMap(KeyValueType.QY);
        Set<String> kset=map.keySet();
        String tempValue = entity.getQyId();
        entity.setQyId("");
        for(String ks:kset)
        {
            String value = map.get(ks);
            if(tempValue.equals(value))
            {
                entity.setQyId(ks);
                break;
            }
        }

        map = keyValueService.getKeyValueMap(KeyValueType.GDGS);
        kset=map.keySet();
        tempValue = entity.getYwdw();
        entity.setYwdw("");
        for(String ks:kset)
        {
            String value = map.get(ks);
            if(tempValue.equals(value))
            {
                entity.setYwdw(ks);
                break;
            }
        }

        map = keyValueService.getKeyValueMap(KeyValueType.DXCS);
        kset=map.keySet();
        String dx1 = entity.getDxxh1();
        String dx2 = entity.getDxxh2();
        String dx3 = entity.getDxxh3();
        entity.setDxxh1("");
        entity.setDxxh2("");
        entity.setDxxh3("");
        boolean dx1Flag = false;
        boolean dx2Flag = false;
        boolean dx3Flag = false;
        for(String ks:kset)
        {
            String value = map.get(ks);
            if(dx1.equals(value))
            {
                entity.setDxxh1(ks);
                dx1Flag = true;
            }

            if(dx2.equals(value))
            {
                entity.setDxxh2(ks);
                dx2Flag = true;
            }

            if(dx3.equals(value))
            {
                entity.setDxxh3(ks);
                dx3Flag = true;
            }

            if (dx1Flag&&dx2Flag&&dx3Flag)
            {
                break;
            }
        }


        map = getAllJdlx();
        kset=map.keySet();
        String qd = entity.getSjqd();
        String zd = entity.getSjzd();
        entity.setSjqd("");
        entity.setSjzd("");
        boolean qdFlag = false;
        boolean zdFlag = false;
        for(String ks:kset)
        {
            String value = map.get(ks);
            if(zd.equals(value))
            {
                entity.setSjzd(ks);
                zdFlag = true;
            }

            if(qd.equals(value))
            {
                entity.setSjqd(ks);
                qdFlag = true;
            }

            if (qdFlag&&zdFlag)
            {
                break;
            }
        }
    }
}