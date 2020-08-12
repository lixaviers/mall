package com.suyan.mall.goods.resp;

import lombok.Data;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@Data
@ApiModel("商品图片")
public class GoodsPictureVO implements Serializable {

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
    private String pictureAddress;


    /**
     * -------------------------------------------------
     * 上面字段由工具自动生成，请在下面添加扩充字段
     * -------------------------------------------------
     */


}