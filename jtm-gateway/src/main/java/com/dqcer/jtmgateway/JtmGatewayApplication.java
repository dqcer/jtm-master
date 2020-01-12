package com.dqcer.jtmgateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class JtmGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(JtmGatewayApplication.class, args);
    }

}
