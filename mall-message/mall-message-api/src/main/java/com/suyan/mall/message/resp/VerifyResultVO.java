package com.suyan.mall.message.resp;

import lombok.Data;

/**
 * 验证码发送结果
 */
@Data
public class VerifyResultVO {

    /**
     * 返回本次任务的序列ID
     */
    private String taskID;

    /**
     * 错误信息
     */
    private String error;


}
