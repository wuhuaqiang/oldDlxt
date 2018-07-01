package com.kylin.electricassistsys.utility.mail;

import freemarker.template.Template;
import javafx.util.Pair;
import org.apache.commons.collections4.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * Created by Threecolors on 2018/3/2.
 */
@Service
public class MailSenderImpl implements  MailSender
{
    @Autowired
    private FreeMarkerConfigurer freeMarkerConfigurer;

    public JavaMailSender getJavaMailSender()
    {
        return javaMailSender;
    }

    public void setJavaMailSender(JavaMailSender javaMailSender)
    {
        this.javaMailSender = javaMailSender;
    }

    private  JavaMailSender javaMailSender;



//    @Async("mailAsync")
//    @Override
//    public void sendSimpleMail(SimpleMailMessage simpleMailMessage)
//    {
//        javaMailSender.send(simpleMailMessage);
//    }
//
//
//
//    @Async("mailAsync")
//    @Override
//    public void sendAttachmentsMail(String sendTo,
//                                    String titel,
//                                    String content,
//                                    List<Pair<String, File>> attachments)
//    {
//        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
//        try
//        {
//            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
//            helper.setFrom(Sender);
//            helper.setTo(Sender);
//            helper.setSubject("标题：发送Html内容");
//        }
//        catch (MessagingException e)
//        {
//            e.printStackTrace();
//        }
//
//        javaMailSender.send(mimeMessage);
//    }

    @Async("mailAsync")
    @Override
    public void sendTemplateMail(String from,String[] sendTo,
                                 String subject,
                                 String templateName,
                                 Map<String, Object> contentMap,
                                 List<Pair<String, File>> attachments)
    {
        try {
            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true,"UTF-8");
            helper.setFrom(new InternetAddress(from));
            helper.setTo(sendTo);
            helper.setSubject(subject);

            Template template = freeMarkerConfigurer.getConfiguration().getTemplate(templateName);
            String html = FreeMarkerTemplateUtils.processTemplateIntoString(template, contentMap);
            helper.setText(html, true);

            for (Pair<String, File> attachment : attachments)
            {
                FileSystemResource file = new FileSystemResource(attachment.getValue());
                helper.addAttachment(attachment.getKey(), file);
            }

            javaMailSender.send(message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
