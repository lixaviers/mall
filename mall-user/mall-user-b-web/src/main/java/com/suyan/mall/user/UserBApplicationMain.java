/*
 * Copyright (c) 2020.
 * 项目名称：素焉商城
 * 创建人：素焉
 * 开源地址: https://github.com/lixaviers/mall
 */
package com.suyan.mall.user;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@Slf4j
@ComponentScan(basePackages = {"com.suyan"})
@EnableFeignClients(value = {"com.suyan"})
@EnableWebMvc
@MapperScan(basePackages = {"com.suyan.mall.user.dao"})
@EnableTransactionManagement
public class UserBApplicationMain {
    public static void main(String[] args) {
        SpringApplication.run(UserBApplicationMain.class, args);
        log.info(" user b start ok ");
    }
}
