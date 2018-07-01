package com.kylin.electricassistsys.service.basedata;

import com.kylin.electricassistsys.entity.basedata.XldxjmfbEntity;
import com.kylin.electricassistsys.mapper.basedata.XldxjmfbMapper;
import com.kylin.electricassistsys.service.BaseService;
import com.kylin.electricassistsys.utility.CustomField;
import com.kylin.electricassistsys.utility.StringHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.Map;

/**
 * Created by Threecolors on 2017/11/18.
 */
@Service
public class XldxjmfbService extends BaseService<XldxjmfbEntity>
{
    private XldxjmfbMapper mapper;

    @Autowired
    public void setMapper(XldxjmfbMapper mapper)
    {
        this.mapper = mapper;
        setBaseMapper(mapper);
    }

    public List<XldxjmfbEntity> getEntitiesByCondition(XldxjmfbEntity conditionEntity)
    {
        Example example = new Example(XldxjmfbEntity.class);
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
