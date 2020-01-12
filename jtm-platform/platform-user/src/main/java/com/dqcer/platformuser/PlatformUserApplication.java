package com.dqcer.platformuser;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

@Slf4j
@EnableEurekaClient
@MapperScan("com.dqcer.platformuser.web.dao")
@SpringBootApplication
public class PlatformUserApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(PlatformUserApplication.class, args);
        ConfigurableEnvironment environment = run.getEnvironment();
        String serverPort = environment.getProperty("server.port");
        log.info("\n----------------------------------------------------------\n\t" +
                "Application platform-user running! Access URLs:\n\t" +
                "Local: \t\thttp://localhost:" + serverPort + "/\n\t" +
                "----------------------------------------------------------");
    }

}
