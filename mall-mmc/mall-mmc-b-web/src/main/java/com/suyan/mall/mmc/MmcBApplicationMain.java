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
@EnableFeignClients(value = {"com.suyan"})
@Slf4j
@ComponentScan(basePackages = {"com.suyan"})
@EnableWebMvc
@MapperScan(basePackages = {"com.suyan.mall.mmc.dao"})
@EnableTransactionManagement
public class MmcBApplicationMain {
    public static void main(String[] args) {
        SpringApplication.run(MmcBApplicationMain.class, args);
        log.info("mmc b start ok ");
    }
}
