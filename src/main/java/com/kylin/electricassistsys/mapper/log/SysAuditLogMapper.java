package com.kylin.electricassistsys.mapper.log;

import com.kylin.electricassistsys.commonmapper.BaseMapper;
import com.kylin.electricassistsys.entity.log.SysAuditLog;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * Created by Threecolors on 2018/2/22.
 */
@Mapper
@Component(value="SysAuditLogMapper")
public interface SysAuditLogMapper extends BaseMapper<SysAuditLog>
{
}
