package com.kylin.electricassistsys.common;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.kylin.electricassistsys.entity.log.AuditEventGrade;
import com.kylin.electricassistsys.entity.log.AuditEventName;
import com.kylin.electricassistsys.entity.log.AuditEventType;
import com.kylin.electricassistsys.entity.log.SysAuditLog;
import com.kylin.electricassistsys.entity.system.SysSetting;
import com.kylin.electricassistsys.service.log.SysAuditLogService;
import com.kylin.electricassistsys.service.system.SysSettingService;
import com.kylin.electricassistsys.utility.IPTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by Threecolors on 2018/3/16.
 */
@Component
public class AccessCheckHandler
{
    @Autowired
    SysSettingService sysSettingService;

    @Autowired
    SysAuditLogService sysAuditLogService;

    /**访问时间校验
     * @return
     */
    public boolean checkAccessTime()
    {
        try
        {
            SysSetting sysSetting = sysSettingService.selectSysSetting();
            SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            Date now = new Date();
            String dateStr = simpleDateFormat1.format(now);
            String startTimeStr = dateStr + " " + sysSetting.getAccessBeginTime();
            String endTimeStr = dateStr + " " + sysSetting.getAccessEndTime();

            Date startTime = simpleDateFormat2.parse(startTimeStr);
            Date endTime = simpleDateFormat2.parse(endTimeStr);
            if (now.after(startTime) && now.before(endTime))
            {
                return true;
            }

            return false;
        }
        catch (ParseException e)
        {
            e.printStackTrace();
        }

        return true;
    }


    /**
     * IP限制检查
     *
     * @param ip
     * @return
     */
    public boolean checkIPAccessAuthority(String ip)
    {
        SysSetting sysSetting = sysSettingService.selectSysSetting();
        List<String> ipList = Arrays.asList(sysSetting.getIpList().split(";|；"));

        //黑名单限制
        if (sysSetting.getRestrictType() == 0)
        {
            if (ipList.contains(ip))
            {
                return false;
            }

        }
        else
        {
            //白名单限制
            if (!ipList.contains(ip))
            {
                return false;
            }
        }

        return true;
    }

    public void sendJsonMessage(HttpServletResponse response, Object obj) throws Exception {
        response.setContentType("application/json; charset=utf-8");
        PrintWriter writer = response.getWriter();
        writer.print(JSONObject.toJSONString(obj, SerializerFeature.WriteMapNullValue,
                                             SerializerFeature.WriteDateUseDateFormat));
        writer.close();
        response.flushBuffer();
    }

    public void writeSysAuditLog(HttpServletRequest request)
    {
        String userIp = IPTools.getIpAddr(request);
        String msg = String.format("目标地址：{%s}",request.getServletPath()) ;
        try
        {
            SysAuditLog sysAuditLog = new SysAuditLog();
            sysAuditLog.setAccount(request.getParameter("username"));
            sysAuditLog.setModuleName("访问IP异常");
            sysAuditLog.setCurrentTime(new Date());
            sysAuditLog.setUserIp(userIp);
            sysAuditLog.setAuditEventName(AuditEventName.IP_ABNORMAL.getName());
            sysAuditLog.setMessage(msg);
            sysAuditLog.setType(AuditEventType.SYS_EVENT.getName());
            sysAuditLog.setAuditEventGrade(AuditEventGrade.FATAL_ABNORMAL.getName());
            sysAuditLog.setId(UUID.randomUUID().toString());
            sysAuditLogService.addAndMonitoringLog(sysAuditLog);
        }
        catch (Exception ex)
        {
            String s = ex.getMessage();
        }
    }
}
