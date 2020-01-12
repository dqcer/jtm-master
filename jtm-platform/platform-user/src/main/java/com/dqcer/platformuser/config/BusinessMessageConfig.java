package com.dqcer.platformuser.config;

import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

/**
 *  业务消息配置
 *
 * @author dongqin
 * @description
 * @date 13:22 2020/1/12
 */
@Configuration
public class BusinessMessageConfig {

    @Bean
    public PropertiesFactoryBean businessMessage() {
        PropertiesFactoryBean propertiesFactoryBean = new PropertiesFactoryBean();
        propertiesFactoryBean.setLocation(new ClassPathResource("config/business-message.properties"));
        return propertiesFactoryBean;
    }
}
