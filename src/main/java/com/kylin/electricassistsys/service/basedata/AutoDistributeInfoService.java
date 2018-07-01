package com.kylin.electricassistsys.service.basedata;

import com.kylin.electricassistsys.entity.basedata.AutoDistributeInfoEntity;
import com.kylin.electricassistsys.mapper.basedata.AutoDistributeInfoMapper;
import com.kylin.electricassistsys.service.BaseService;
import com.kylin.electricassistsys.utility.CustomField;
import com.kylin.electricassistsys.utility.OperateButtonScript;
import com.kylin.electricassistsys.utility.StringHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.Map;

/**
 * Created by Threecolors on 2017/11/17.
 */
@Service
public class AutoDistributeInfoService extends BaseService<AutoDistributeInfoEntity>
{
    private AutoDistributeInfoMapper mapper;

    @Autowired
    public void setMapper(AutoDistributeInfoMapper mapper)
    {
        this.mapper = mapper;
        setBaseMapper(mapper);
    }

    public List<AutoDistributeInfoEntity> getEntitiesByCondition(AutoDistributeInfoEntity conditionEntity)
    {
        Example example = new Example(AutoDistributeInfoEntity.class);
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
