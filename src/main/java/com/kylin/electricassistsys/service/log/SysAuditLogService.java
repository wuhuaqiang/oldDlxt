package com.kylin.electricassistsys.service.log;

import com.kylin.electricassistsys.common.SendEmailHelper;
import com.kylin.electricassistsys.entity.log.AuditEventName;
import com.kylin.electricassistsys.entity.log.AuditEventType;
import com.kylin.electricassistsys.entity.log.SysAuditLog;
import com.kylin.electricassistsys.entity.log.SysAuditSetting;
import com.kylin.electricassistsys.mapper.log.SysAuditLogMapper;
import com.kylin.electricassistsys.service.BaseService;
import com.kylin.electricassistsys.service.system.SysAuditSettingService;
import com.kylin.electricassistsys.utility.StringHelper;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Threecolors on 2018/2/22.
 */
@Service
public class SysAuditLogService extends BaseService<SysAuditLog>
{
    @Autowired
    private SysAuditLogMapper mapper;

    @Autowired
    protected SysAuditSettingService sysAuditSettingService;

    @Autowired
    SendEmailHelper sendEmailHelper;

    @Autowired
    public void setMapper(SysAuditLogMapper mapper)
    {
        this.mapper = mapper;
        setBaseMapper(mapper);
    }

    public int getSysAuditLogCount()
    {
        return  mapper.selectCount(null);
    }

    public void  addAndMonitoringLog(SysAuditLog sysAuditLog)
    {
        this.insertSelective(sysAuditLog);

        if(sysAuditLog.getAuditEventName().equals(AuditEventName.UNAUTHORIZED.getName())
                ||sysAuditLog.getAuditEventName().equals(AuditEventName.IP_ABNORMAL.getName()))
        {
            SysAuditSetting sysSetting = sysAuditSettingService.getSysAuditSetting();
            if(!StringUtils.isEmpty(sysSetting.getEmailList()))
            {
                String sendTo = sysSetting.getEmailList().replaceAll("\r|\n", "");
                String subject = "主题：系统异常";
                Map<String, Object> map = new HashMap<>();
                map.put("info", sysAuditLog);
                sendEmailHelper.SendEmailForUserPwd(sendTo.split("；|;"), subject, map, "sysAuditAbnormalWarning.ftl");
            }
        }
    }

    public int deleteRedundancyLog()
    {
        SysAuditSetting sysSetting = sysAuditSettingService.getSysAuditSetting();
        Example example = new Example(SysAuditLog.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andLessThan("currentTime", DateUtils.addDays(new Date(),-sysSetting.getLogValidDurationTime()));
        return mapper.deleteByExample(example);
    }


    public List<SysAuditLog> getEntitiesByConditionForJGrid(SysAuditLog conditionEntity,
                                                            int buttonAuthority)
    {
        Example example = new Example(SysAuditLog.class);
        Example.Criteria criteria = example.createCriteria();
        if (!StringUtils.isEmpty(conditionEntity.getAccount()))
        {
            criteria.andLike("account", "%" + conditionEntity.getAccount() + "%");
        }

        if (!StringUtils.isEmpty(conditionEntity.getModuleName()))
        {
            criteria.andLike("moduleName", "%" + conditionEntity.getModuleName() + "%");
        }

        if (!StringUtils.isEmpty(conditionEntity.getAuditEventName()))
        {
            criteria.andLike("auditEventName", "%" + conditionEntity.getAuditEventName() + "%");
        }

        if (!StringUtils.isEmpty(conditionEntity.getAuditEventGrade()))
        {
            criteria.andLike("auditEventGrade", conditionEntity.getAuditEventGrade());
        }

        int auditEventType = Integer.parseInt(conditionEntity.getType());

        criteria.andEqualTo("type", AuditEventType.getName(auditEventType));

        example.orderBy("currentTime").desc();

        return mapper.selectByExample(example);
    }
}
