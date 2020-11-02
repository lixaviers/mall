/*
 * Copyright (c) 2020.
 * 项目名称：素焉商城
 * 创建人：素焉
 * 开源地址: https://github.com/lixaviers/mall
 */
package com.suyan.mall.file;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@Slf4j
@ComponentScan(basePackages = {"com.suyan"})
@EnableFeignClients(value = {"com.suyan"})
@EnableWebMvc
public class FileApplicationMain {
    public static void main(String[] args) {
        SpringApplication.run(FileApplicationMain.class, args);
        log.info("file start ok");
    }
}
