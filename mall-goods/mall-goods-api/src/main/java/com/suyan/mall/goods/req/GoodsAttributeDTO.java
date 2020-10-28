package com.suyan.mall.goods.req;

import com.suyan.service.BaseInterface;
import com.suyan.service.UpdateInterface;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Data
public class GoodsAttributeDTO implements Serializable {

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
     * 商品类目属性id
     */
    @ApiModelProperty("商品类目属性id")
    @NotNull(message = "商品类目属性id不能为空", groups = BaseInterface.class)
    private Long attributeId;

    /**
     * 商品类目属性名称
     */
    @ApiModelProperty("商品类目属性名称")
    private String attributeName;

    /**
     * 商品类目属性值id
     */
    @ApiModelProperty("商品类目属性值id")
    @NotNull(message = "商品类目属性值id不能为空", groups = BaseInterface.class)
    private Long attributeValueId;

    /**
     * 商品类目属性值名称
     */
    @ApiModelProperty("商品类目属性值名称")
    @Size(max = 100, message = "商品类目属性值名称不能超过100位", groups = BaseInterface.class)
    private String attributeValueName;


}