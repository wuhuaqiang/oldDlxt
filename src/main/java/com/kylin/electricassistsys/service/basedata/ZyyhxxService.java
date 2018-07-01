package com.kylin.electricassistsys.service.basedata;

import com.kylin.electricassistsys.entity.basedata.ByqcsEntity;
import com.kylin.electricassistsys.entity.basedata.ZyyhxxEntity;
import com.kylin.electricassistsys.entity.enumparam.KeyValueType;
import com.kylin.electricassistsys.mapper.basedata.ZyyhxxMapper;
import com.kylin.electricassistsys.service.BaseService;
import com.kylin.electricassistsys.service.KeyValueService;
import com.kylin.electricassistsys.utility.CustomField;
import com.kylin.electricassistsys.utility.StringHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.*;

/**
 * Created by Threecolors on 2017/12/1.
 */
@Service
public class ZyyhxxService extends BaseService<ZyyhxxEntity>
{
    private ZyyhxxMapper mapper;

    @Autowired
    private KeyValueService keyValueService;

    @Autowired
    public void setMapper(ZyyhxxMapper mapper)
    {
        this.mapper = mapper;
        setBaseMapper(mapper);
    }

    public List<ZyyhxxEntity> getEntitiesByCondition(ZyyhxxEntity conditionEntity)
    {
        return  mapper.getEntitiesByCondition(conditionEntity);
    }

    public HashMap<String, String> getKeyName()
    {
        HashMap<String, String> map = new LinkedHashMap<>();
        List<ZyyhxxEntity> entities = mapper.selectAll();
        for (ZyyhxxEntity entity  :entities)
        {
            map.put(entity.getId(),entity.getYhmc());
        }

        return  map;
    }

    /**
     * 特殊处理，转化字段展示和数据库存储不一致的情况
     *
     * @param entity
     */
    protected void specialProcessForField(ZyyhxxEntity entity,String type)
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

        map = keyValueService.getKeyValueMap(KeyValueType.BDZ);
        kset=map.keySet();
         tempValue = entity.getBdz();
        entity.setBdz("");
        for(String ks:kset)
        {
            String value = map.get(ks);
            if(tempValue.equals(value))
            {
                entity.setBdz(ks);
                break;
            }
        }
    }
}
