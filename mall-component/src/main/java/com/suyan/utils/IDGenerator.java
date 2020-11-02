/*
 * Copyright (c) 2020.
 * 项目名称：素焉商城
 * 创建人：素焉
 * 开源地址: https://github.com/lixaviers/mall
 */
package com.suyan.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * ID 生成器
 * based on twitter snowflake
 * https://github.com/twitter-archive/snowflake/tree/snowflake-2010
 *
 */
public class IDGenerator {
    public IDGenerator() {
        twitterSnowFlake = new TwitterSnowFlake();
    }

    public IDGenerator(Long idWorker) {
        twitterSnowFlake = new TwitterSnowFlake(idWorker);
    }

    TwitterSnowFlake twitterSnowFlake;

    /**
     * 生成ID
     *
     * @return
     */
    public Long genId() {
        return twitterSnowFlake.next();
    }

    /**
     * 生成多个ID
     *
     * @return
     */
    public List<Long> genId(int count) {
        List<Long> pks = new ArrayList<>(count);
        for (int i = 0; i < count; i++) {
            pks.add(twitterSnowFlake.next());
        }
        return pks;
    }
}