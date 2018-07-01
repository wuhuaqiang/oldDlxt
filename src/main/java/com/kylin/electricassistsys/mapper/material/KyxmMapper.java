package com.kylin.electricassistsys.mapper.material;

import com.kylin.electricassistsys.commonmapper.BaseMapper;
import com.kylin.electricassistsys.entity.material.KyxmEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * Created by Threecolors on 2018/1/2.
 */
@Mapper
@Component(value="KyxmMapper")
public interface KyxmMapper extends BaseMapper<KyxmEntity>
{
}
