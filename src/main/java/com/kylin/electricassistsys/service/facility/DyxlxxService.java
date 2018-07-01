package com.kylin.electricassistsys.service.facility;

import com.kylin.electricassistsys.entity.enumparam.KeyValueType;
import com.kylin.electricassistsys.entity.facility.DyxlxxEntity;
import com.kylin.electricassistsys.mapper.facility.DyxlxxMapper;
import com.kylin.electricassistsys.service.BaseService;
import com.kylin.electricassistsys.service.KeyValueService;
import com.kylin.electricassistsys.utility.CustomField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by Threecolors on 2017/12/31.
 */
@Service
public class DyxlxxService extends BaseService<DyxlxxEntity>
{
    private DyxlxxMapper mapper;

    @Autowired
    KeyValueService keyValueService;

    @Autowired
    public void setMapper(DyxlxxMapper mapper)
    {
        this.mapper = mapper;
        setBaseMapper(mapper);
    }

    /**
     * 特殊处理，转化字段展示和数据库存储不一致的情况
     *
     * @param entity
     */
    protected void specialProcessForField(DyxlxxEntity entity,String type)
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
        tempValue = entity.getDlxh();
        entity.setDlxh("");
        for(String ks:kset)
        {
            String value = map.get(ks);
            if(tempValue.equals(value))
            {
                entity.setDlxh(ks);
                break;
            }
        }
    }
}