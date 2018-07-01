package com.kylin.electricassistsys.mapper.system;

import com.kylin.electricassistsys.commonmapper.BaseMapper;
import com.kylin.electricassistsys.entity.system.SysSetting;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * Created by Threecolors on 2018/1/31.
 */
@Mapper
@Component(value="SysSettingMapper")
public interface SysSettingMapper extends BaseMapper<SysSetting>
{
}
