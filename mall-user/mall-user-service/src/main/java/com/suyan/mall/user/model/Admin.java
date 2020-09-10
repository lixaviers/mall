package com.suyan.mall.user.model;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class Admin {

    
    /**
     * ID
     */
    private Long id;
    
    /**
     * 用户唯一标识
     */
    private String uniqueUserId;
    
    /**
     * 用户账号
     */
    private String userName;
    
    /**
     * 用户昵称
     */
    private String nickName;
    
    /**
     * 手机号
     */
    private String mobile;
    
    /**
     * 邮箱账号
     */
    private String email;
    
    /**
     * 密码
     */
    private String userPwd;
    
    /**
     * 状态
     */
    private Byte userStatus;
    
    /**
     * 备注
     */
    private String remark;
    
    /**
     * 创建时间
     */
    private LocalDateTime createTime;
    
    /**
     * 更新时间
     */
    private LocalDateTime updateTime;
    
    /**
     * 是否删除：0.未删除，1.已删除
     */
    private Boolean isDeleted;
    

    /**
     * -------------------------------------------------
     * 上面字段由工具自动生成，请在下面添加扩充字段
     * -------------------------------------------------
     */


}