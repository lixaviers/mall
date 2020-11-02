/*
 * Copyright (c) 2020.
 * 项目名称：素焉商城
 * 创建人：素焉
 * 开源地址: https://github.com/lixaviers/mall
 */
package com.suyan.constants;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * The class mq topic constants.
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class RocketMqTopicConstant {

    /**
     * The enum Uac mq topic enum.
     */
    public enum MqTopicEnum {
        /**
         * 发送短信.
         */
        USER_LOGIN("USER_LOGIN", "用户登录"),
        ;

        MqTopicEnum(String topic, String topicName) {
            this.topic = topic;
            this.topicName = topicName;
        }

        String topic;

        String topicName;

        public String getTopic() {
            return topic;
        }

        public String getTopicName() {
            return topicName;
        }
    }


    /**
     * The enum Uac mq tag enum.
     */
    public enum MqTagEnum {

        /**
         * 用户登录
         */
        USER_LOGIN("USER_LOGIN", MqTopicEnum.USER_LOGIN),
        ;

        String tag;
        String topic;
        String tagName;

        MqTagEnum(String tag, MqTopicEnum mqTopicEnum) {
            this.tag = tag;
            this.topic = mqTopicEnum.getTopic();
            this.tagName = mqTopicEnum.getTopicName();
        }

        public String getTag() {
            return tag;
        }

        public String getTopic() {
            return topic;
        }
    }

}
