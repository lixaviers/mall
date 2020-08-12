package com.suyan.mall.goods.req;

import com.suyan.service.BaseInterface;
import com.suyan.service.UpdateInterface;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class GoodsSkuInventoryLogDTO implements Serializable {

    /**
     * serialVersionUID
     */ 
    private static final long serialVersionUID = 1L;

        
    /**
     * id
     */
    @ApiModelProperty(value = "id", hidden = true)
    @NotNull(message = "id不能为空", groups = UpdateInterface.class)
    private Long id;
        
    /**
     * 商品编码
     */
    @ApiModelProperty("商品编码")
    @NotNull(message = "商品编码不能为空", groups = BaseInterface.class)
    @Size(max = 32, message = "商品编码不能超过32位", groups = BaseInterface.class)
    private String goodsSkuCode;
        
    /**
     * 库存方式 1.占用 2.归还
     */
    @ApiModelProperty("库存方式 1.占用 2.归还")
    @NotNull(message = "库存方式 1.占用 2.归还不能为空", groups = BaseInterface.class)
    private Byte inventoryWay;
        
    /**
     * 占用库存
     */
    @ApiModelProperty("占用库存")
    @NotNull(message = "占用库存不能为空", groups = BaseInterface.class)
    private Integer inventory;
        
    /**
     * 类型 3.砍价
     */
    @ApiModelProperty("类型 3.砍价")
    @NotNull(message = "类型 3.砍价不能为空", groups = BaseInterface.class)
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
    @Size(max = 255, message = "关联描述不能超过255位", groups = BaseInterface.class)
    private String associatedDesc;
        
    /**
     * 备注
     */
    @ApiModelProperty("备注")
    @Size(max = 255, message = "备注不能超过255位", groups = BaseInterface.class)
    private String remark;
        
    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间", hidden = true)
    private LocalDateTime createTime;
        
    /**
     * 更新时间
     */
    @ApiModelProperty(value = "更新时间", hidden = true)
    private LocalDateTime updateTime;


    /**
     * -------------------------------------------------
     * 上面字段由工具自动生成，请在下面添加扩充字段
     * -------------------------------------------------
     */


}