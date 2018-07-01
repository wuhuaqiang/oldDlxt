package com.kylin.electricassistsys.utility.mail;

import javafx.util.Pair;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import java.io.File;
import java.util.List;
import java.util.Map;

/**
 * Created by Threecolors on 2018/3/2.
 */
public interface MailSender
{
//    /**
//     * 发送简单邮件
//     * @param simpleMailMessage 邮件信息
//     */
//    void sendSimpleMail(SimpleMailMessage simpleMailMessage);
//
//    /**
//     * 发送简单邮件
//     * @param sendTo 收件人地址
//     * @param titel  邮件标题
//     * @param content 邮件内容
//     * @param attachments<文件名，附件> 附件列表
//     */
//    void sendAttachmentsMail(String sendTo, String titel, String content, List<Pair<String, File>> attachments);

    void setJavaMailSender(JavaMailSender javaMailSender);

    /**
     * 发送模板邮件
     * @param sendTo 收件人地址
     * @param subject  邮件标题
     * @param templateName  模板名称
     * @param contentMap<key, 内容> 邮件内容
     * @param attachments<文件名，附件> 附件列表
     */
     void sendTemplateMail(String from,String[] sendTo,
                           String subject,
                           String templateName,
                           Map<String, Object> contentMap,
                           List<Pair<String, File>> attachments);
}
