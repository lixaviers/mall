package com.suyan.mall.user.model;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class GoodsCollect {


    /**
     * id
     */
    private Long id;

    /**
     * 用户唯一标识
     */
    private String uniqueUserId;

    /**
     * 店铺id
     */
    private Long shopId;

    /**
     * 商品id
     */
    private Long goodsId;

    /**
     * 商品加入时的价格
     */
    private BigDecimal goodsPrice;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 是否删除
     */
    private Boolean isDeleted;


    /**
     * -------------------------------------------------
     * 上面字段由工具自动生成，请在下面添加扩充字段
     * -------------------------------------------------
     */


    /**
     * 收藏数
     */
    private Integer collectNumber;

    /**
     * 删除标志
     */
    private Boolean deleteFlag;

}