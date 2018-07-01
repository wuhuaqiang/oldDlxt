package com.kylin.electricassistsys.service.system;

import com.kylin.electricassistsys.entity.enumparam.Status;
import com.kylin.electricassistsys.entity.system.UnitEntity;
import com.kylin.electricassistsys.mapper.system.UnitMapper;
import com.kylin.electricassistsys.service.BaseService;
import com.kylin.electricassistsys.utility.CustomField;
import com.kylin.electricassistsys.utility.OperateButtonScript;
import com.kylin.electricassistsys.utility.StringHelper;
import org.apache.calcite.linq4j.Linq4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Threecolors on 2017/11/16.
 */
@Service
public class UnitService extends BaseService<UnitEntity>
{
    @Autowired
    private UnitMapper mapper;

    @Autowired
    public void setMapper(UnitMapper mapper)
    {
        this.mapper = mapper;
        setBaseMapper(mapper);
    }

    public List<UnitEntity> getEnableAll()
    {
        Example example = new Example(UnitEntity.class);
        Example.Criteria criteria= example.createCriteria();
        criteria.andEqualTo("status",Status.VALID.getName());
        return mapper.selectByExample(example);
    }

    public HashMap<String, String> getUnitKeyName()
    {
        HashMap<String, String> map = new LinkedHashMap<>();
        List<UnitEntity> entities = getEnableAll();
        for (UnitEntity entity  :entities)
        {
            map.put(entity.getId(),entity.getName());
        }

        return  map;
    }

    /**
     * 根据名称获取
     *
     * @return 所有实体集合
     */
    public List<UnitEntity> getEntitiesByCondition(UnitEntity conditionEntity)
    {
        Example example = new Example(UnitEntity.class);
        Example.Criteria criteria = example.createCriteria();
        if(!StringHelper.isNullOrWhiteSpace(conditionEntity.getName()))
        {
            criteria.andLike("name","%"+conditionEntity.getName()+"%");
        }
        example.orderBy("updateTime").desc();

        return  mapper.selectByExample(example);
    }
}
