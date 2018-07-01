package com.kylin.electricassistsys.service.basedata;

import com.kylin.electricassistsys.entity.basedata.DxcsEntity;
import com.kylin.electricassistsys.mapper.basedata.DxcsMapper;
import com.kylin.electricassistsys.service.BaseService;
import com.kylin.electricassistsys.utility.CustomField;
import com.kylin.electricassistsys.utility.StringHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Threecolors on 2017/11/20.
 */
@Service
public class DxcsService extends BaseService<DxcsEntity>
{
    private DxcsMapper mapper;

    @Autowired
    public void setMapper(DxcsMapper mapper)
    {
        this.mapper = mapper;
        setBaseMapper(mapper);
    }

    public List<DxcsEntity> getEntitiesByCondition(DxcsEntity conditionEntity)
    {
        Example example = new Example(DxcsEntity.class);
        Example.Criteria criteria = example.createCriteria();
        if(!StringHelper.isNullOrWhiteSpace(conditionEntity.getDxlx()))
        {
            criteria.andEqualTo("dxlx",conditionEntity.getDxlx());
        }

        if(!StringHelper.isNullOrWhiteSpace(conditionEntity.getName()))
        {
            criteria.andLike("name","%"+conditionEntity.getName()+"%");
        }

        return  mapper.selectByExample(example);
    }

    public HashMap<String, String> getDxcsKeyName()
    {
        HashMap<String, String> map = new LinkedHashMap<>();
        List<DxcsEntity> entities = mapper.selectAll();
        for (DxcsEntity entity  :entities)
        {
            map.put(entity.getId(),entity.getName());
        }

        return  map;
    }
}
