/*
 * Copyright (c) 2020.
 * 项目名称：素焉商城
 * 创建人：素焉
 * 开源地址: https://github.com/lixaviers/mall
 */
package com.suyan.mall.operation.convertor;

import com.suyan.mall.operation.model.MqMessageData;
import com.suyan.mall.operation.req.MqMessageDataDTO;
import org.springframework.cglib.beans.BeanCopier;

import java.util.ArrayList;
import java.util.List;

/**
 * @CopyRright (c): <素焉代码生成工具>
 * @Comments: <对象相互转换>
 */
public abstract class MqMessageDataConvertor {

    private static final BeanCopier beanCopierForMqMessageData = BeanCopier.create(MqMessageDataDTO.class, MqMessageData.class, false);

    public static MqMessageData toMqMessageData(MqMessageDataDTO mqMessageDataDTO) {
        MqMessageData mqMessageData = new MqMessageData();
        beanCopierForMqMessageData.copy(mqMessageDataDTO, mqMessageData, null);
        return mqMessageData;
    }

    public static List<MqMessageData> toMqMessageDataList(List<MqMessageDataDTO> mqMessageDataDTOList) {
        if (mqMessageDataDTOList == null || mqMessageDataDTOList.isEmpty()) {
            return null;
        }
        List<MqMessageData> mqMessageDataList = new ArrayList<MqMessageData>(mqMessageDataDTOList.size());
        for (MqMessageDataDTO mqMessageDataDTO : mqMessageDataDTOList) {
            mqMessageDataList.add(toMqMessageData(mqMessageDataDTO));
        }
        return mqMessageDataList;
    }

}