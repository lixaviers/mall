package com.suyan.mall.goods.resp;

import lombok.Data;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@ApiModel("商品sku库存日志")
public class GoodsSkuInventoryLogVO implements Serializable {

    /**   
     * serialVersionUID
     */ 
    private static final long serialVersionUID = 1L;


    /**
     * id
     */
    @ApiModelProperty("id")
    private Long id;

    /**
     * 商品编码
     */
    @ApiModelProperty("商品编码")
    private String goodsSkuCode;

    /**
     * 库存方式 1.占用 2.归还
     */
    @ApiModelProperty("库存方式 1.占用 2.归还")
    private Byte inventoryWay;

    /**
     * 占用库存
     */
    @ApiModelProperty("占用库存")
    private Integer inventory;

    /**
     * 类型 3.砍价
     */
    @ApiModelProperty("类型 3.砍价")
    private Byte logType;

    /**
     * 关联id
     */
    @ApiModelProperty("关联id")
    private Long associatedId;

    /**
     * 关联描述
     */
    @ApiModelProperty("关联描述")
    private String associatedDesc;

    /**
     * 备注
     */
    @ApiModelProperty("备注")
    private String remark;

    /**
     * 创建时间
     */
    @ApiModelProperty("创建时间")
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    @ApiModelProperty("更新时间")
    private LocalDateTime updateTime;


    /**
     * -------------------------------------------------
     * 上面字段由工具自动生成，请在下面添加扩充字段
     * -------------------------------------------------
     */


}