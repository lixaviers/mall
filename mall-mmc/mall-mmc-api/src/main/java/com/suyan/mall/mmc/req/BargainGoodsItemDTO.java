package com.suyan.mall.mmc.req;

import com.suyan.service.BaseInterface;
import com.suyan.service.UpdateInterface;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class BargainGoodsItemDTO implements Serializable {

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
     * 砍价商品id
     */
    @ApiModelProperty("砍价商品id")
    @NotNull(message = "砍价商品id不能为空", groups = BaseInterface.class)
    private Long bargainGoodsId;
        
    /**
     * 最小人数
     */
    @ApiModelProperty("最小人数")
    @NotNull(message = "最小人数不能为空", groups = BaseInterface.class)
    private Integer numberMin;
        
    /**
     * 最大人数
     */
    @ApiModelProperty("最大人数")
    private Integer numberMax;
        
    /**
     * 最小比例
     */
    @ApiModelProperty("最小比例")
    private BigDecimal promotionMin;
        
    /**
     * 最大比例
     */
    @ApiModelProperty("最大比例")
    private BigDecimal promotionMax;
        
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