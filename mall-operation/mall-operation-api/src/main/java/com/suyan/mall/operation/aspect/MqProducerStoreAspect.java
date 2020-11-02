/*
 * Copyright (c) 2018. paascloud.net All Rights Reserved.
 * 项目名称：paascloud快速搭建企业级分布式微服务平台
 * 类名称：MqProducerStoreAspect.java
 * 创建人：刘兆明
 * 联系方式：paascloud.net@gmail.com
 * 开源地址: https://github.com/paascloud
 * 博客地址: http://blog.paascloud.net
 * 项目官网: http://paascloud.net
 */

/*
 * Copyright (c) 2020.
 * 项目名称：素焉商城
 * 创建人：素焉
 * 开源地址: https://github.com/lixaviers/mall
 */
package com.suyan.mall.operation.aspect;

import com.suyan.exception.CommonException;
import com.suyan.mall.operation.annotation.MqProducerStore;
import com.suyan.mall.operation.enums.DelayLevelEnum;
import com.suyan.mall.operation.enums.MqSendTypeEnum;
import com.suyan.mall.operation.req.MqMessageDataDTO;
import com.suyan.mall.operation.service.IMqMessageService;
import com.suyan.result.ResultCode;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.lang.reflect.Method;


/**
 * 消息生产者切面
 *
 * @author paascloud.net @gmail.com
 */
@Slf4j
@Aspect
@Component
public class MqProducerStoreAspect {
    @Resource
    private IMqMessageService mqMessageService;

    @Value("${rocketmq.producer-group}")
    private String producerGroup;

    /**
     * Add exe time annotation pointcut.
     */
    @Pointcut("@annotation(com.suyan.mall.operation.annotation.MqProducerStore)")
    public void mqProducerStoreAnnotationPointcut() {
    }

    /**
     * Add exe time method object.
     */
    @Around(value = "mqProducerStoreAnnotationPointcut()")
    public Object processMqProducerStoreJoinPoint(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("processMqProducerStoreJoinPoint - 线程id={}", Thread.currentThread().getId());
        Object result;
        Object[] args = joinPoint.getArgs();
        MqProducerStore annotation = getAnnotation(joinPoint);
        MqSendTypeEnum type = annotation.sendType();
        byte orderType = annotation.orderType().orderType();
        DelayLevelEnum delayLevelEnum = annotation.delayLevel();
        if (args.length == 0) {
            throw new CommonException(ResultCode.MESSAGE_900_ERROR);
        }
        MqMessageDataDTO domain = null;
        for (Object object : args) {
            if (object instanceof MqMessageDataDTO) {
                domain = (MqMessageDataDTO) object;
                break;
            }
        }

        if (domain == null) {
            throw new CommonException(ResultCode.MESSAGE_900_ERROR);
        }

        domain.setOrderType(orderType);
        domain.setMessageGroup(producerGroup);
        if (type == MqSendTypeEnum.WAIT_CONFIRM) {
            if (delayLevelEnum != DelayLevelEnum.ZERO) {
                domain.setDelayLevel(delayLevelEnum.delayLevel());
            }
            mqMessageService.saveWaitConfirmMessage(domain);
        }
        result = joinPoint.proceed();
        if (type == MqSendTypeEnum.SAVE_AND_SEND) {
            mqMessageService.saveAndSendMessage(domain);
        } else {
//            final MqMessageDataDTO finalDomain = domain;
//            taskExecutor.execute(() -> mqMessageService.confirmAndSendMessage(finalDomain.getMessageKey()));
        }
        return result;
    }

    private static MqProducerStore getAnnotation(JoinPoint joinPoint) {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        return method.getAnnotation(MqProducerStore.class);
    }
}
