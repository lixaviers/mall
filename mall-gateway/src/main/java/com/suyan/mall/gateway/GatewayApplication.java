package com.suyan.mall.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan(value = {"com.suyan"})
public class GatewayApplication {
    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(new Class[]{GatewayApplication.class});
        application.run(args);
    }
}