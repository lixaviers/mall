package com.suyan.mall.goods.req;

import com.suyan.service.BaseInterface;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Size;
import java.io.Serializable;

@Data
public class GoodsPictureDTO implements Serializable {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 1L;


    /**
     * 商品id
     */
    @ApiModelProperty("商品id")
    private Long goodsId;

    /**
     * 图片地址
     */
    @ApiModelProperty("图片地址")
    @Size(max = 255, message = "图片地址不能超过255位", groups = BaseInterface.class)
    private String pictureAddress;


    /**
     * -------------------------------------------------
     * 上面字段由工具自动生成，请在下面添加扩充字段
     * -------------------------------------------------
     */


}