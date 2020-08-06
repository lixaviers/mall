package com.suyan.mall.mmc.req;

import com.suyan.service.BaseInterface;
import com.suyan.service.UpdateInterface;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class BargainGoodsDTO implements Serializable {

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
     * 砍价活动id
     */
    @ApiModelProperty("砍价活动id")
    @NotNull(message = "砍价活动id不能为空", groups = BaseInterface.class)
    private Long bargainActivityId;

    /**
     * 有效期类型 1.24h 2.48h 3.72h
     */
    @ApiModelProperty("有效期类型 1.24h 2.48h 3.72h")
    @NotNull(message = "有效期类型 1.24h 2.48h 3.72h不能为空", groups = BaseInterface.class)
    private Byte validityDateType;

    /**
     * 商品编码
     */
    @ApiModelProperty("商品编码")
    @NotNull(message = "商品编码不能为空", groups = BaseInterface.class)
    @Size(max = 32, message = "商品编码不能超过32位", groups = BaseInterface.class)
    private String goodsSkuCode;

    /**
     * 价格
     */
    @ApiModelProperty("价格")
    @NotNull(message = "价格不能为空", groups = BaseInterface.class)
    private BigDecimal price;

    /**
     * 库存
     */
    @ApiModelProperty("库存")
    @NotNull(message = "库存不能为空", groups = BaseInterface.class)
    private Integer inventory;


    /**
     * -------------------------------------------------
     * 上面字段由工具自动生成，请在下面添加扩充字段
     * -------------------------------------------------
     */


}