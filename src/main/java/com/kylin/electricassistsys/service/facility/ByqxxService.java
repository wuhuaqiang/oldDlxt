package com.kylin.electricassistsys.service.facility;

import com.kylin.electricassistsys.entity.enumparam.KeyValueType;
import com.kylin.electricassistsys.entity.facility.ByqxxEntity;
import com.kylin.electricassistsys.mapper.facility.ByqxxMapper;
import com.kylin.electricassistsys.service.BaseService;
import com.kylin.electricassistsys.service.KeyValueService;
import com.kylin.electricassistsys.utility.CustomField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by Threecolors on 2017/12/2.
 */
@Service
public class ByqxxService extends BaseService<ByqxxEntity>
{
    private ByqxxMapper mapper;

    @Autowired
    private KeyValueService keyValueService;

    @Autowired
    public void setMapper(ByqxxMapper mapper)
    {
        this.mapper = mapper;
        setBaseMapper(mapper);
    }

    /**获取变电站的变压器
     * @param bdzId
     * @return
     */
    public List<ByqxxEntity> getByqxxByBdzId(String bdzId)
    {
        Example example = new Example(ByqxxEntity.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("bdz",bdzId);
        return this.mapper.selectByExample(example);
    }

    /**
     * 特殊处理，转化字段展示和数据库存储不一致的情况
     *
     * @param entity
     */
    protected void specialProcessForField(ByqxxEntity entity,String type)
    {
        Map<String,String> map = keyValueService.getKeyValueMap(KeyValueType.QY);
        Set<String> kset=map.keySet();
        String tempValue = entity.getQyId();
        entity.setQyId("");
        for(String ks:kset)
        {
            String value = map.get(ks);
            if(tempValue.equals(value))
            {
                entity.setQyId(ks);
                break;
            }
        }

        map = keyValueService.getKeyValueMap(KeyValueType.BDZ);
        kset=map.keySet();
        tempValue = entity.getBdz();
        entity.setBdz("");
        for(String ks:kset)
        {
            String value = map.get(ks);
            if(tempValue.equals(value))
            {
                entity.setBdz(ks);
                break;
            }
        }
    }
}
