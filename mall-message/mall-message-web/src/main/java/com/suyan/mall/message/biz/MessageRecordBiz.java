/*
 * Copyright (c) 2020.
 * 项目名称：素焉商城
 * 创建人：素焉
 * 开源地址: https://github.com/lixaviers/mall
 */
package com.suyan.mall.message.biz;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.suyan.mall.message.constant.SmsSendProviderEnum;
import com.suyan.mall.message.constant.SmsSendStatusEnum;
import com.suyan.mall.message.constant.SmsSendTypeEnum;
import com.suyan.mall.message.dao.MessageRecordMapper;
import com.suyan.mall.message.model.MessageRecord;
import com.suyan.mall.message.req.MessageRecordQueryDTO;
import com.suyan.mall.message.req.SmsMessageDTO;
import com.suyan.query.QueryResultVO;
import com.suyan.utils.IDGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

@Service("messageRecordBiz")
public class MessageRecordBiz {

    @Value("${sms.open:false}")
    private boolean open;
    @Value("${sms.verify.content:您的验证码为：%s，请于15分钟内输入验证，请勿向他人泄露。若非本人操作，请忽略！}")
    private String verifyContent;

    @Autowired
    private MessageRecordMapper messageRecordMapper;

    @Autowired
    private IDGenerator idGenerator;

    /**
     * 发送验证码短信
     *
     * @return
     */
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, rollbackFor = Exception.class)
    public void sendVerCode(SmsMessageDTO smsMessageDTO) {
        String msgId = null;
        String msgResult = null;
        Byte sendStatus = SmsSendStatusEnum.FAILURE.getValue();
        String content = "【素焉商城】" + String.format(verifyContent, smsMessageDTO.getVerCode());
        MessageRecord messageRecord = new MessageRecord();
        messageRecord.setId(idGenerator.genId());
        messageRecord.setMobile(smsMessageDTO.getMobile());
        messageRecord.setSendType(SmsSendTypeEnum.VER_CODE.getValue());
        messageRecord.setChannelId(smsMessageDTO.getChannelId());
        messageRecord.setContent(content);
        messageRecord.setSendStatus(sendStatus);
        messageRecord.setMsgId(msgId);
        messageRecord.setMsgResult(msgResult);
        messageRecord.setSendProvider(SmsSendProviderEnum.TEST.getValue());
        messageRecordMapper.insertBatch(Arrays.asList(messageRecord));
    }


    /**
     * 分页查询SMS短信消息记录信息
     *
     * @param messageRecordQuery
     * @return
     */
    @Transactional(readOnly = true)
    public QueryResultVO<MessageRecord> queryMessageRecord(MessageRecordQueryDTO messageRecordQuery) {
        QueryResultVO<MessageRecord> queryResult = new QueryResultVO<MessageRecord>();
        // 使用分页插件PageHelper实现分页功能
        PageHelper.startPage(messageRecordQuery.getPageNo(), messageRecordQuery.getPageSize());
        List<MessageRecord> messageRecordList = messageRecordMapper.queryMessageRecord(messageRecordQuery);
        PageInfo<MessageRecord> pageInfo = new PageInfo<MessageRecord>(messageRecordList);
        queryResult.setPageNo(pageInfo.getPageNum());
        queryResult.setPageSize(pageInfo.getPageSize());
        queryResult.setTotalPages(pageInfo.getPages());
        queryResult.setTotalRecords(pageInfo.getTotal());
        queryResult.setRecords(messageRecordList);
        return queryResult;
    }

}