package com.kylin.electricassistsys.service.basedata;

import com.kylin.electricassistsys.entity.basedata.PowerSupplyZoneEntity;
import com.kylin.electricassistsys.mapper.basedata.PowerSupplyZoneMapper;
import com.kylin.electricassistsys.service.BaseService;
import com.kylin.electricassistsys.utility.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.*;

/**
 * Created by Threecolors on 2017/11/17.
 */
@Service
public class PowerSupplyZoneService extends BaseService<PowerSupplyZoneEntity>
{
    private PowerSupplyZoneMapper mapper;

    @Autowired
    public void setPowerSupplyZoneMapper(PowerSupplyZoneMapper mapper)
    {
        this.mapper = mapper;
        setBaseMapper(mapper);
    }

    /**
     * 根据名称获取
     *
     * @return 所有实体集合
     */
    public List<PowerSupplyZoneEntity> getEntitiesByCondition(PowerSupplyZoneEntity conditionEntity)
    {
        Example example = new Example(PowerSupplyZoneEntity.class);
        Example.Criteria criteria = example.createCriteria();
        if(!StringHelper.isNullOrWhiteSpace(conditionEntity.getName()))
        {
            criteria.andLike("name","%"+conditionEntity.getName()+"%");
        }
        example.orderBy("updateTime").desc();

        return  mapper.selectByExample(example);
    }

    public HashMap<String, String> getPowerSupplyZoneKeyName()
    {
        HashMap<String, String> map = new LinkedHashMap<>();
        List<PowerSupplyZoneEntity> entities = mapper.selectAll();
        for (PowerSupplyZoneEntity entity  :entities)
        {
            map.put(entity.getId(),entity.getName());
        }

        return  map;
    }


}
