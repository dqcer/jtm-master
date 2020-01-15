package com.dqcer.platformauth;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

@Slf4j
@EnableEurekaClient
@EnableFeignClients
@MapperScan("com.dqcer.platformauth.web.dao")
@SpringBootApplication
public class PlatformAuthApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(PlatformAuthApplication.class, args);
        ConfigurableEnvironment environment = run.getEnvironment();
        String serverPort = environment.getProperty("server.port");
        log.info("\n----------------------------------------------------------\n\t" +
                "Application platform-auth running! Access URLs:\n\t" +
                "Local: \t\thttp://localhost:" + serverPort + "/\n\t" +
                "----------------------------------------------------------");
    }

}
