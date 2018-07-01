package com.kylin.electricassistsys.service.basedata;

import com.kylin.electricassistsys.entity.basedata.ByqcsEntity;
import com.kylin.electricassistsys.mapper.basedata.ByqcsMapper;
import com.kylin.electricassistsys.service.BaseService;
import com.kylin.electricassistsys.utility.CustomField;
import com.kylin.electricassistsys.utility.StringHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.Map;

/**
 * Created by Threecolors on 2017/11/28.
 */
@Service
public class ByqcsService extends BaseService<ByqcsEntity>
{
    private ByqcsMapper mapper;

    @Autowired
    public void setMapper(ByqcsMapper mapper)
    {
        this.mapper = mapper;
        setBaseMapper(mapper);
    }

    public List<ByqcsEntity> getEntitiesByCondition(ByqcsEntity conditionEntity)
    {
        Example example = new Example(ByqcsEntity.class);
        Example.Criteria criteria = example.createCriteria();
        if(!StringHelper.isNullOrWhiteSpace(conditionEntity.getXh()))
        {
            criteria.andLike("xh","%"+conditionEntity.getXh()+"%");
        }

        if(!StringHelper.isNullOrWhiteSpace(conditionEntity.getDydj()))
        {
            criteria.andEqualTo("dydj",conditionEntity.getDydj());
        }

        return  mapper.selectByExample(example);
    }
}
