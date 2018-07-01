package com.kylin.electricassistsys.mapper.log;

import com.kylin.electricassistsys.commonmapper.BaseMapper;
import com.kylin.electricassistsys.entity.log.LoginLog;
import com.kylin.electricassistsys.entity.log.SysAuditSetting;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * Created by Threecolors on 2018/3/5.
 */
@Mapper
@Component(value="SysAuditSettingMapper")
public interface SysAuditSettingMapper extends BaseMapper<SysAuditSetting>
{
}
