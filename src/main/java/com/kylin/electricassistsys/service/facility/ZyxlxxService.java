package com.kylin.electricassistsys.service.facility;

import com.kylin.electricassistsys.entity.enumparam.KeyValueType;
import com.kylin.electricassistsys.entity.facility.ZyxlxxEntity;
import com.kylin.electricassistsys.mapper.facility.ZyxlxxMapper;
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
public class ZyxlxxService extends BaseService<ZyxlxxEntity>
{
    private ZyxlxxMapper mapper;

    @Autowired
    KeyValueService keyValueService;

    @Autowired
    public void setMapper(ZyxlxxMapper mapper)
    {
        this.mapper = mapper;
        setBaseMapper(mapper);
    }

    /**
     * 特殊处理，转化字段展示和数据库存储不一致的情况
     *
     * @param entity
     */
    protected void specialProcessForField(ZyxlxxEntity entity,String type)
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