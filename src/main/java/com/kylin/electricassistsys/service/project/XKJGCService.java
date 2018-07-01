package com.kylin.electricassistsys.service.project;

import com.kylin.electricassistsys.entity.enumparam.KeyValueType;
import com.kylin.electricassistsys.entity.project.XkjGcEntity;
import com.kylin.electricassistsys.mapper.project.XKJGCMapper;
import com.kylin.electricassistsys.service.BaseService;
import com.kylin.electricassistsys.service.KeyValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Set;

/**
 * Created by Threecolors on 2017/12/28.
 */
@Service
public class XKJGCService extends BaseService<XkjGcEntity>
{
    private XKJGCMapper mapper;

    @Autowired
    KeyValueService keyValueService;

    @Autowired
    public void setMapper(XKJGCMapper mapper)
    {
        this.mapper = mapper;
        setBaseMapper(mapper);
    }

    /**
     * 特殊处理，转化字段展示和数据库存储不一致的情况
     *
     * @param entity
     */
    protected void specialProcessForField(XkjGcEntity entity, String type)
    {
        entity.setType(Integer.parseInt(type));
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
        tempValue = entity.getYwdwId();
        entity.setYwdwId("");
        for(String ks:kset)
        {
            String value = map.get(ks);
            if(tempValue.equals(value))
            {
                entity.setYwdwId(ks);
                break;
            }
        }
    }
}

