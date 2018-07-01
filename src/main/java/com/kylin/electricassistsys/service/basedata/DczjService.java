package com.kylin.electricassistsys.service.basedata;

import com.kylin.electricassistsys.entity.basedata.DczjEntity;
import com.kylin.electricassistsys.mapper.basedata.DczjMapper;
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
public class DczjService extends BaseService<DczjEntity>
{
    private DczjMapper mapper;

    @Autowired
    public void setMapper(DczjMapper mapper)
    {
        this.mapper = mapper;
        setBaseMapper(mapper);
    }

    public List<DczjEntity> getEntitiesByCondition(DczjEntity conditionEntity)
    {
        Example example = new Example(DczjEntity.class);
        Example.Criteria criteria = example.createCriteria();
        if(!StringHelper.isNullOrWhiteSpace(conditionEntity.getLx()))
        {
            criteria.andLike("lx","%"+conditionEntity.getLx()+"%");
        }

        return  mapper.selectByExample(example);
    }
}
