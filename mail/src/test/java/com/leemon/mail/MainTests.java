package com.leemon.mail;

import com.leemon.mail.config.MailConfig;
import com.leemon.mail.tool.Tool_Mail;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MainTests {

    @Autowired
    Tool_Mail mail;

    @Autowired
    MailConfig mailConfig;

    @Test
    public void contextLoads() {

        String[] mailReceiver = mailConfig.getMailReceiver();

        String subject = "测试";
        String content = "这是带附件的测试邮件,请注意格式";
        String filePath = "/Users/limenglong/IdeaProjects/SpringBootMulti/mail/README.md";

        //测试普通邮件
//        mail.sendSimpleMail(mailReceiver,subject,content);

        //测试html邮件
//        mail.sendHtmlMail(mailReceiver,subject,content);

        //测试带附件的邮件
        mail.sendAttachmentsMail(mailReceiver,subject,content,filePath);
    }

}
