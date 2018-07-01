package com.kylin.electricassistsys.mapper.basedata;

import com.kylin.electricassistsys.commonmapper.BaseMapper;
import com.kylin.electricassistsys.entity.basedata.MaintainGroupEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * Created by Threecolors on 2017/11/17.
 */
@Mapper
@Component(value="MaintainGroupMapper")
public interface MaintainGroupMapper extends BaseMapper<MaintainGroupEntity>
{
}
