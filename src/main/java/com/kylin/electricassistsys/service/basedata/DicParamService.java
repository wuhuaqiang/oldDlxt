package com.kylin.electricassistsys.service.basedata;

import com.kylin.electricassistsys.entity.basedata.DicParamEntity;
import com.kylin.electricassistsys.mapper.basedata.DicParamMapper;
import com.kylin.electricassistsys.service.BaseService;
import com.kylin.electricassistsys.utility.CustomField;
import com.kylin.electricassistsys.utility.OperateButtonScript;
import com.kylin.electricassistsys.utility.StringHelper;
import org.apache.calcite.linq4j.Linq4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.*;

/**
 * Created by Threecolors on 2017/11/17.
 */
@Service
public class DicParamService extends BaseService<DicParamEntity>
{
    private DicParamMapper mapper;

    @Autowired
    public void setMapper(DicParamMapper mapper)
    {
        this.mapper = mapper;
        setBaseMapper(mapper);
    }

    /**
     * 获取所有
     *
     * @return 所有实体集合
     */
    public List<DicParamEntity> getByType(int dicParamType)
    {
        Example example = new Example(DicParamEntity.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("type",dicParamType);
        return mapper.selectByExample(example);
    }

    public List<DicParamEntity> getEntitiesByCondition(DicParamEntity conditionEntity)
    {
        Example example = new Example(DicParamEntity.class);
        Example.Criteria criteria = example.createCriteria();
        if(!StringHelper.isNullOrWhiteSpace(conditionEntity.getName()))
        {
            criteria.andLike("name","%"+conditionEntity.getName()+"%");
        }
        criteria.andEqualTo("type",conditionEntity.getType());
        example.orderBy("updateTime").desc();
        return  mapper.selectByExample(example);
    }


    /**
     * 根据名称获取
     *
     * @return 所有实体集合
     */
    public HashMap<String, String> getDicByType(int dicParamType)
    {
        HashMap<String, String> map = new LinkedHashMap<>();
        List<DicParamEntity> params = this.getByType(dicParamType);

        for (DicParamEntity param  :params)
        {
            map.put(param.getName(),param.getName());
        }

        return  map;
    }

    public List<CustomField> getPreviewField(DicParamEntity entity)
    {
        List<CustomField> customFields = this.getCustomFields(entity);
        customFields = Linq4j.asEnumerable(customFields).where(a -> a.getMeta().isImport()&&!a.getName().equals("type")).orderBy(a -> a.getRank()).toList();
        return customFields;
    }

    protected void specialProcessForField(DicParamEntity entity,String type)
    {
        entity.setType(Integer.parseInt(type));
    }
}
