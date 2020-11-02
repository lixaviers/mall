/*
 * Copyright (c) 2020.
 * 项目名称：素焉商城
 * 创建人：素焉
 * 开源地址: https://github.com/lixaviers/mall
 */
package com.suyan.mall.mmc;

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
@EnableFeignClients(value = {"com.suyan"})
@EnableWebMvc
@MapperScan(basePackages = {"com.suyan.mall.mmc.dao"})
@EnableTransactionManagement
@ComponentScan(value = {"com.suyan"})
public class MmcCApplicationMain {
    public static void main(String[] args) {
        SpringApplication.run(MmcCApplicationMain.class, args);
        log.info(" mmc c start ok ");
    }
}
