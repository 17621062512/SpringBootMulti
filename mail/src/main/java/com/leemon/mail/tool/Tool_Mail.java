package com.leemon.mail.tool;

import com.leemon.mail.config.MailConfig;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.Arrays;

/**
 * @author limenglong
 * @create 2019-04-18 18:10
 * @desc 邮件发送工具类
 **/
@Component
public class Tool_Mail {

    private static final Logger log = LoggerFactory.getLogger(Tool_Mail.class);

    @Autowired
    private JavaMailSenderImpl mailSender;

    //发送普通文本邮件
    public void sendSimpleMail(String[] receiver, String subject, String content) {

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(mailSender.getUsername());
        message.setTo(receiver);
        message.setSubject(subject);
        message.setText(content);

        try {
            log.info("邮件发送人账户：" + mailSender.getUsername());
            log.info("邮件接收人账户：" + Arrays.toString(receiver));
            mailSender.send(message);
            log.info("普通文本邮件发送成功");
        } catch (Exception e) {
            log.info("普通文本邮件发送失败");
            log.info(e.getMessage());
        }
    }

    //发送HTML格式的邮件
    public void sendHtmlMail(String[] receiver, String subject, String content) {
        MimeMessage message = mailSender.createMimeMessage();

        try {
            MimeMessageHelper messageHelper = new MimeMessageHelper(message, true);
            messageHelper.setFrom(mailSender.getUsername());
            messageHelper.setTo(receiver);
            messageHelper.setSubject(subject);
            messageHelper.setText(content,true);

            log.info("邮件发送人账户：" + mailSender.getUsername());
            log.info("邮件接收人账户：" + Arrays.toString(receiver));
            mailSender.send(message);
            log.info("HTML格式邮件发送成功");
        } catch (MessagingException e) {
            log.info("HTML格式邮件发送失败");
            log.info(e.getMessage());

        }


    }

    //发送带附件的邮件
    public void sendAttachmentsMail(String[] receiver, String subject, String content, String filePath) {

        MimeMessage message = mailSender.createMimeMessage();

        try {
            MimeMessageHelper messageHelper = new MimeMessageHelper(message, true);
            messageHelper.setFrom(mailSender.getUsername());
            messageHelper.setTo(receiver);
            messageHelper.setSubject(subject);
            messageHelper.setText(content);

            FileSystemResource resource = new FileSystemResource(new File(filePath));
            String fileName = StringUtils.substring(filePath,filePath.lastIndexOf(File.separator));
            messageHelper.addAttachment(fileName,resource);

            log.info("邮件发送人账户：" + mailSender.getUsername());
            log.info("邮件接收人账户：" + Arrays.toString(receiver));
            mailSender.send(message);
            log.info("带附件的邮件发送成功");
        } catch (MessagingException e) {
            log.info("带附件的邮件发送失败");
            log.info(e.getMessage());

        }

    }
}
