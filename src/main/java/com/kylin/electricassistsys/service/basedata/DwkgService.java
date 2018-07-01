package com.kylin.electricassistsys.service.basedata;

import com.kylin.electricassistsys.entity.basedata.DwkgEntity;
import com.kylin.electricassistsys.mapper.basedata.DwkgMapper;
import com.kylin.electricassistsys.service.BaseService;
import com.kylin.electricassistsys.utility.CustomField;
import com.kylin.electricassistsys.utility.StringHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.Map;

/**
 * Created by Threecolors on 2017/11/19.
 */
@Service
public class DwkgService extends BaseService<DwkgEntity>
{
    private DwkgMapper mapper;

    @Autowired
    public void setMapper(DwkgMapper mapper)
    {
        this.mapper = mapper;
        setBaseMapper(mapper);
    }

    public List<DwkgEntity> getEntitiesByCondition(DwkgEntity conditionEntity)
    {
        Example example = new Example(DwkgEntity.class);
        Example.Criteria criteria = example.createCriteria();
        if(!StringHelper.isNullOrWhiteSpace(conditionEntity.getSupplyZoneType()))
        {
            criteria.andEqualTo("supplyZoneType",conditionEntity.getSupplyZoneType());
        }

        if(!StringHelper.isNullOrWhiteSpace(conditionEntity.getVoltage()))
        {
            criteria.andEqualTo("voltage",conditionEntity.getVoltage());
        }

        return  mapper.selectByExample(example);
    }
}
