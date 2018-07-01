package com.kylin.electricassistsys.service.log;

import com.kylin.electricassistsys.entity.log.LoginLog;
import com.kylin.electricassistsys.entity.log.SysAuditSetting;
import com.kylin.electricassistsys.mapper.log.LoginLogMapper;
import com.kylin.electricassistsys.service.BaseService;
import com.kylin.electricassistsys.service.system.SysAuditSettingService;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by Threecolors on 2018/2/1.
 */
@Service
public class LoginLogService extends BaseService<LoginLog> {
    @Autowired
    protected SysAuditSettingService sysAuditSettingService;
    @Autowired
    private LoginLogMapper mapper;

    @Autowired
    public void setMapper(LoginLogMapper mapper) {
        this.mapper = mapper;
        setBaseMapper(mapper);
    }

    public int deleteRedundancyLog() {
        SysAuditSetting sysSetting = sysAuditSettingService.getSysAuditSetting();
        Example example = new Example(LoginLog.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andLessThan("loginTime", DateUtils.addDays(new Date(), -sysSetting.getLogValidDurationTime()));
        return mapper.deleteByExample(example);
    }


    /**
     * 获取用户最近的登录记录
     *
     * @param userName
     * @param timeInterval
     * @return
     */
    public List<LoginLog> getRecentLoginLogInLimitTime(String userName, int timeInterval) {
        Example example = new Example(getMyClass());
        Example.Criteria criteria = example.createCriteria();
        criteria.andGreaterThan("loginTime", DateUtils.addMinutes(new Date(), -timeInterval));
        criteria.andEqualTo("account", userName);
        example.orderBy("loginTime").desc();

        return mapper.selectByExample(example);
    }

    public int getLoginLogCount() {
        return mapper.selectCount(null);
    }

    public List<LoginLog> getEntitiesByConditionForJGrid(LoginLog conditionEntity,
                                                         int buttonAuthority) {
        Example example = new Example(LoginLog.class);
        Example.Criteria criteria = example.createCriteria();
        if (!StringUtils.isEmpty(conditionEntity.getAccount())) {
            criteria.andLike("account", "%" + conditionEntity.getAccount() + "%");
        }

        example.orderBy("loginTime").desc();

        return mapper.selectByExample(example);
    }

    public void addLoginLog(String userName, String userIp, String logType, String isSuccess, String msg) {
        try {
            LoginLog loginLog = new LoginLog();
            loginLog.setId(UUID.randomUUID().toString());
            loginLog.setIsSuccess(isSuccess);
            loginLog.setAccount(userName);
            loginLog.setLoginIp(userIp);
            loginLog.setLogType(logType);
            loginLog.setLoginTime(new Date());
            loginLog.setErrorMsg(msg);
            this.add(loginLog);
        } catch (Exception ex) {

        }
    }
}
