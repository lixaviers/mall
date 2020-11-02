/*
 * Copyright (c) 2020.
 * 项目名称：素焉商城
 * 创建人：素焉
 * 开源地址: https://github.com/lixaviers/mall
 */
package com.suyan.mall.operation.annotation;


import com.suyan.mall.operation.enums.DelayLevelEnum;
import com.suyan.mall.operation.enums.MqOrderTypeEnum;
import com.suyan.mall.operation.enums.MqSendTypeEnum;

import java.lang.annotation.*;


/**
 * 保存生产者消息
 * 参考：https://github.com/paascloud
 * 可以参考文章：https://paascloud.net/2018/03/18/java-env/rocketmq/rocketmq-reliable-message-consistency/
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface MqProducerStore {

    MqSendTypeEnum sendType() default MqSendTypeEnum.SAVE_AND_SEND;

    MqOrderTypeEnum orderType() default MqOrderTypeEnum.ORDER;

    DelayLevelEnum delayLevel() default DelayLevelEnum.ZERO;

}
