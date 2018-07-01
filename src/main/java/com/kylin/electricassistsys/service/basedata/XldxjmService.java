package com.kylin.electricassistsys.service.basedata;

import com.kylin.electricassistsys.entity.basedata.XldxjmEntity;
import com.kylin.electricassistsys.mapper.basedata.XldxjmMapper;
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
public class XldxjmService extends BaseService<XldxjmEntity>
{
    private XldxjmMapper mapper;

    @Autowired
    public void setMapper(XldxjmMapper mapper)
    {
        this.mapper = mapper;
        setBaseMapper(mapper);
    }

    public List<XldxjmEntity> getEntitiesByCondition(XldxjmEntity conditionEntity)
    {
        Example example = new Example(XldxjmEntity.class);
        Example.Criteria criteria = example.createCriteria();
        if(!StringHelper.isNullOrWhiteSpace(conditionEntity.getSupplyZoneType()))
        {
            criteria.andEqualTo("supplyZoneType",conditionEntity.getSupplyZoneType());
        }

        return  mapper.selectByExample(example);
    }
}
