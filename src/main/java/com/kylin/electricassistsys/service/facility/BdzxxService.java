package com.kylin.electricassistsys.service.facility;

import com.kylin.electricassistsys.entity.enumparam.KeyValueType;
import com.kylin.electricassistsys.entity.facility.BdzxxEntity;
import com.kylin.electricassistsys.mapper.facility.BdzxxMapper;
import com.kylin.electricassistsys.service.BaseService;
import com.kylin.electricassistsys.service.KeyValueService;
import com.kylin.electricassistsys.utility.CustomField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by Threecolors on 2017/12/1.
 */
@Service
public class BdzxxService extends BaseService<BdzxxEntity>
{
    private BdzxxMapper mapper;

    @Autowired
    private KeyValueService keyValueService;

    @Autowired
    public void setMapper(BdzxxMapper mapper)
    {
        this.mapper = mapper;
        setBaseMapper(mapper);
    }

    public HashMap<String, String> getBdzKeyName()
    {
        HashMap<String, String> map = new LinkedHashMap<>();
        List<BdzxxEntity> entities = mapper.selectAll();
        for (BdzxxEntity entity  :entities)
        {
            map.put(entity.getId(),entity.getBdzName());
        }

        return  map;
    }

    public BdzxxEntity getBdzxxByBdzId(String bdzId)
    {
        return this.mapper.getEntityById(bdzId);
    }

    /**
     * 特殊处理，转化字段展示和数据库存储不一致的情况
     *
     * @param entity
     */
    protected void specialProcessForField(BdzxxEntity entity,String type)
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
    }
}