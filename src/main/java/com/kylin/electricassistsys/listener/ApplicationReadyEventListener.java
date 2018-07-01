package com.kylin.electricassistsys.listener;

import com.kylin.electricassistsys.common.SendEmailHelper;
import com.kylin.electricassistsys.entity.log.SysAuditSetting;
import com.kylin.electricassistsys.service.log.LoginLogService;
import com.kylin.electricassistsys.service.log.SysAuditLogService;
import com.kylin.electricassistsys.service.system.SysAuditSettingService;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.boot.context.event.ApplicationStartingEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Threecolors on 2018/3/16.
 */
@Component
public class ApplicationReadyEventListener implements ApplicationListener<ApplicationReadyEvent>
{
    @Autowired
    LoginLogService loginLogService;

    @Autowired
    SysAuditLogService sysAuditLogService;

    @Autowired
    SysAuditSettingService sysAuditSettingService;

    @Autowired
    SendEmailHelper sendEmailHelper;

    protected final Log logger = LogFactory.getLog(this.getClass());


    @Override
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent)
    {
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        cachedThreadPool.execute(() ->
                                 {

                                     int loginLogCount;
                                     int sysAuditLogCount;
                                     SysAuditSetting sysAuditSetting;

                                     while (true)
                                     {
                                         try
                                         {
                                             loginLogCount = loginLogService.getLoginLogCount();
                                             sysAuditLogCount = sysAuditLogService.getSysAuditLogCount();
                                             sysAuditSetting = sysAuditSettingService.getSysAuditSetting();

                                             if (loginLogCount > sysAuditSetting.getLogMaxCount() || sysAuditLogCount > sysAuditSetting.getLogMaxCount())
                                             {
                                                 if (!StringUtils.isEmpty(sysAuditSetting.getEmailList()))
                                                 {
                                                     String sendTo = sysAuditSetting.getEmailList().replaceAll("\r|\n",
                                                                                                               "");
                                                     String subject = "主题：审计日志数量超容";
                                                     Map<String, Object> map = new HashMap<>();
                                                     map.put("loginLogCount", loginLogCount);
                                                     map.put("sysAuditLogCount", sysAuditLogCount);
                                                     map.put("maxCount", sysAuditSetting.getLogMaxCount());
                                                     sendEmailHelper.SendEmailForUserPwd(sendTo.split("；|;"), subject,
                                                                                         map,
                                                                                         "auditLogCapacityWarning.ftl");
                                                 }
                                             }
                                         }
                                         catch (Exception ex)
                                         {
                                             logger.error(ex);
                                         }
                                         finally
                                         {
                                             try
                                             {
                                                 Thread.sleep(1000 * 60 * 60);
                                             }
                                             catch (InterruptedException e)
                                             {
                                                 e.printStackTrace();
                                             }
                                         }
                                     }
                                 });
    }
}
