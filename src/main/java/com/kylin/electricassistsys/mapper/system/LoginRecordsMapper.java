package com.kylin.electricassistsys.mapper.system;

import com.kylin.electricassistsys.commonmapper.BaseMapper;
import com.kylin.electricassistsys.entity.system.LoginRecords;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * Created by Threecolors on 2018/1/22.
 */
@Mapper
@Component(value="LoginRecordsMapper")
public interface LoginRecordsMapper extends BaseMapper<LoginRecords>
{
}
