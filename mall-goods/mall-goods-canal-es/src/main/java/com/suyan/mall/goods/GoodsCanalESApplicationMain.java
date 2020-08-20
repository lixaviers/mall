package com.suyan.mall.goods;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@Slf4j
@ComponentScan(basePackages = {"com.suyan"})
@EnableWebMvc
@MapperScan(basePackages = {"com.suyan.mall.goods.dao"})
@EnableTransactionManagement
public class GoodsCanalESApplicationMain {
    public static void main(String[] args) {
        System.setProperty("es.set.netty.runtime.available.processors", "false");
        SpringApplication.run(GoodsCanalESApplicationMain.class, args);
        log.info("goods canal es start ok ");
    }
}
