package com.kylin.electricassistsys.service.material;

import com.kylin.electricassistsys.entity.material.ZlglEntity;
import com.kylin.electricassistsys.mapper.material.ZlglMapper;
import com.kylin.electricassistsys.service.BaseService;
import com.kylin.electricassistsys.utility.AuthorityType;
import com.kylin.electricassistsys.utility.OperateButtonScript;
import com.kylin.electricassistsys.utility.StringHelper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * Created by Threecolors on 2018/1/2.
 */
@Service
public class ZlglService extends BaseService<ZlglEntity>
{
    private ZlglMapper mapper;

    @Autowired
    public void setMapper(ZlglMapper mapper)
    {
        this.mapper = mapper;
        setBaseMapper(mapper);
    }

    public List<ZlglEntity> getEntitiesByCondition(ZlglEntity conditionEntity)
    {
        Example example = new Example(ZlglEntity.class);
        Example.Criteria criteria = example.createCriteria();
        if(!StringHelper.isNullOrWhiteSpace(conditionEntity.getZlName()))
        {
            criteria.andLike("zlName","%"+conditionEntity.getZlName()+"%");
        }

        if(!StringHelper.isNullOrWhiteSpace(conditionEntity.getZlType()))
        {
            criteria.andEqualTo("zlType",conditionEntity.getZlType());
        }

        return  mapper.selectByExample(example);
    }

    public List<ZlglEntity> getEntitiesByConditionForJGrid(ZlglEntity conditionEntity, int buttonAuthority )
    {
        List<ZlglEntity> entities = this.getEntitiesByCondition(conditionEntity);

        String operStr = StringUtils.EMPTY;
        if ((AuthorityType.DELETE.getIndex() & buttonAuthority) > 0)
        {
            operStr += OperateButtonScript.DELETE_BUTTON;
        }
        if ((AuthorityType.MODIFY.getIndex() & buttonAuthority) > 0)
        {
            operStr += OperateButtonScript.EIDIT_BUTTON;
        }

        operStr += OperateButtonScript.FILE_DOWNLODING;

        if (!StringUtils.isEmpty(operStr))
        {
            for (ZlglEntity entity : entities)
            {
                entity.setOperate(String.format(operStr, entity.getId(), entity.getId(), entity.getUrl()));
            }
        }

        return  entities;
    }
}
