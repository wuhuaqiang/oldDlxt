package com.kylin.electricassistsys.service.system;

import com.kylin.electricassistsys.entity.log.SysAuditSetting;
import com.kylin.electricassistsys.mapper.log.SysAuditLogMapper;
import com.kylin.electricassistsys.mapper.log.SysAuditSettingMapper;
import com.kylin.electricassistsys.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Threecolors on 2018/3/5.
 */
@Service
public class SysAuditSettingService extends BaseService<SysAuditSetting>
{
    @Autowired
    private SysAuditSettingMapper mapper;

    @Autowired
    public void setMapper(SysAuditSettingMapper mapper)
    {
        this.mapper = mapper;
        setBaseMapper(mapper);
    }

    public SysAuditSetting getSysAuditSetting()
    {
        List<SysAuditSetting> sysSettings = mapper.selectAll();
        if(sysSettings.size()>0)
        {
            return  sysSettings.get(0);
        }
        else
        {
            return  new SysAuditSetting();
        }
    }
}
