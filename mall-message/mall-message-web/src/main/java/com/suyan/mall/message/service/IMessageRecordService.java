package com.suyan.mall.message.service;

import com.suyan.mall.message.req.MessageRecordQueryDTO;
import com.suyan.mall.message.req.SmsMessageDTO;
import com.suyan.mall.message.resp.MessageRecordVO;
import com.suyan.query.QueryResultVO;
import com.suyan.result.Result;

/**
 * @CopyRright (c): <素焉代码生成工具>
 */
public interface IMessageRecordService {

    /**
     * 发送验证码短信
     *
     * @param smsMessageDTO
     * @return
     */
    Result<String> sendVerCode(SmsMessageDTO smsMessageDTO);

    /**
     * 分页查询SMS短信消息记录信息
     *
     * @param messageRecordQueryDTO
     * @return
     */
    QueryResultVO<MessageRecordVO> queryMessageRecord(MessageRecordQueryDTO messageRecordQueryDTO);

}