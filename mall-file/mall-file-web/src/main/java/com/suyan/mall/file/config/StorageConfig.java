/*
 * Copyright (c) 2020.
 * 项目名称：素焉商城
 * 创建人：素焉
 * 开源地址: https://github.com/lixaviers/mall
 */
package com.suyan.mall.file.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Data
public class StorageConfig {

    /**
     * 默认10M
     */
    @Value("${file.max.upload.size:10485760}")
    private int maxUploadFileSize;

    /**
     * 七牛云配置
     */
    @Value("${file.qiniu.accessKey:1}")
    private String accessKey;
    @Value("${file.qiniu.secretKey:1}")
    private String secretKey;
    @Value("${file.qiniu.bucketName:1}")
    private String bucketName;
    @Value("${file.qiniu.domain:1}")
    private String domain;

}
