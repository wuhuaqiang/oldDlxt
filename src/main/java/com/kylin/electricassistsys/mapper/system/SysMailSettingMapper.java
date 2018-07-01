package com.kylin.electricassistsys.mapper.system;

import com.kylin.electricassistsys.commonmapper.BaseMapper;
import com.kylin.electricassistsys.entity.system.SysMailSetting;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * Created by Threecolors on 2018/3/2.
 */
@Mapper
@Component(value="SysMailSettingMapper")
public interface SysMailSettingMapper extends BaseMapper<SysMailSetting>
{
}
