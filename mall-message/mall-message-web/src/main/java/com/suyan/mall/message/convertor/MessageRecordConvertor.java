/*
 * Copyright (c) 2020.
 * 项目名称：素焉商城
 * 创建人：素焉
 * 开源地址: https://github.com/lixaviers/mall
 */
package com.suyan.mall.message.convertor;

import com.suyan.mall.message.model.MessageRecord;
import com.suyan.mall.message.req.MessageRecordDTO;
import com.suyan.mall.message.resp.MessageRecordVO;
import com.suyan.query.QueryResultVO;
import org.springframework.cglib.beans.BeanCopier;

import java.util.ArrayList;
import java.util.List;

public abstract class MessageRecordConvertor {

    private static final BeanCopier beanCopierForMessageRecordVO = BeanCopier.create(MessageRecord.class, MessageRecordVO.class, false);
    private static final BeanCopier beanCopierForMessageRecord = BeanCopier.create(MessageRecordDTO.class, MessageRecord.class, false);

    public static MessageRecordVO toMessageRecordVO(MessageRecord messageRecord) {
        if (messageRecord == null) {
            return null;
        }
        MessageRecordVO messageRecordVO = new MessageRecordVO();
        beanCopierForMessageRecordVO.copy(messageRecord, messageRecordVO, null);
        return messageRecordVO;
    }

    public static MessageRecord toMessageRecord(MessageRecordDTO messageRecordDTO) {
        MessageRecord messageRecord = new MessageRecord();
        beanCopierForMessageRecord.copy(messageRecordDTO, messageRecord, null);
        return messageRecord;
    }

    public static List<MessageRecordVO> toMessageRecordVOList(List<MessageRecord> messageRecordList) {
        if (messageRecordList == null || messageRecordList.isEmpty()) {
            return null;
        }
        List<MessageRecordVO> messageRecordInfoList = new ArrayList<MessageRecordVO>(messageRecordList.size());
        for (MessageRecord messageRecord : messageRecordList) {
            messageRecordInfoList.add(toMessageRecordVO(messageRecord));
        }
        return messageRecordInfoList;
    }

    public static List<MessageRecord> toMessageRecordList(List<MessageRecordDTO> messageRecordDTOList) {
        if (messageRecordDTOList == null || messageRecordDTOList.isEmpty()) {
            return null;
        }
        List<MessageRecord> messageRecordList = new ArrayList<MessageRecord>(messageRecordDTOList.size());
        for (MessageRecordDTO messageRecordDTO : messageRecordDTOList) {
            messageRecordList.add(toMessageRecord(messageRecordDTO));
        }
        return messageRecordList;
    }

    public static QueryResultVO<MessageRecordVO> toQueryResult(QueryResultVO<MessageRecord> queryResult) {
        QueryResultVO<MessageRecordVO> queryResultInfo = new QueryResultVO<MessageRecordVO>();
        queryResultInfo.setPageNo(queryResult.getPageNo());
        queryResultInfo.setPageSize(queryResult.getPageSize());
        queryResultInfo.setTotalPages(queryResult.getTotalPages());
        queryResultInfo.setTotalRecords(queryResult.getTotalRecords());
        queryResultInfo.setRecords(toMessageRecordVOList(queryResult.getRecords()));
        return queryResultInfo;
    }
}