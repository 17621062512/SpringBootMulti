package com.leemon.mail.config;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @author limenglong
 * @create 2019-04-18 18:09
 * @desc 邮件配置
 **/
@Configuration
public class MailConfig {
    private static final Logger log = LoggerFactory.getLogger(MailConfig.class);

    @Value("${mail.send.to}")
    private String receiver;

    /**
     * 获取邮件接收人
     *
     * @return String[]
     */
    public String[] getMailReceiver() {
        log.info("初始化邮件接收人。。。");
        try {
            //TODO 可以做邮箱校验
            String[] receivers = StringUtils.split(receiver, ",");
            log.info("初始化邮件接收人成功");
            return receivers;
        } catch (Exception e) {
            log.info("初始化邮件接收人失败");
            return new String[0];
        }
    }
}
