package com.kylin.electricassistsys.service.basedata;

import com.kylin.electricassistsys.entity.CommonEntity;
import com.kylin.electricassistsys.entity.basedata.MaintainGroupEntity;
import com.kylin.electricassistsys.mapper.basedata.MaintainGroupMapper;
import com.kylin.electricassistsys.mapper.basedata.PowerSupplyZoneMapper;
import com.kylin.electricassistsys.service.BaseService;
import com.kylin.electricassistsys.utility.CustomField;
import com.kylin.electricassistsys.utility.OperateButtonScript;
import com.kylin.electricassistsys.utility.StringHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Threecolors on 2017/11/17.
 */
@Service
public class MaintainGroupService extends BaseService<MaintainGroupEntity>
{
    private MaintainGroupMapper mapper;

    @Autowired
    public void setMapper(MaintainGroupMapper mapper)
    {
        this.mapper = mapper;
        setBaseMapper(mapper);
    }

    /**
     * 根据名称获取
     *
     * @return 所有实体集合
     */
    public List<MaintainGroupEntity> getEntitiesByCondition(MaintainGroupEntity conditionEntity)
    {
        Example example = new Example(MaintainGroupEntity.class);
        Example.Criteria criteria = example.createCriteria();
        if(!StringHelper.isNullOrWhiteSpace(conditionEntity.getName()))
        {
            criteria.andLike("name","%"+conditionEntity.getName()+"%");
        }
        example.orderBy("rank");

        return  mapper.selectByExample(example);
    }
}
