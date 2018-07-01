package com.kylin.electricassistsys.mapper.log;

import com.kylin.electricassistsys.commonmapper.BaseMapper;
import com.kylin.electricassistsys.entity.log.LoginLog;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * Created by Threecolors on 2018/2/1.
 */
@Mapper
@Component(value="LoginLogMapper")
public interface LoginLogMapper extends BaseMapper<LoginLog>
{
}
