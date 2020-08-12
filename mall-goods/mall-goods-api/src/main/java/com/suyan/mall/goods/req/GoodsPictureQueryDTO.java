package com.suyan.mall.goods.req;

import com.suyan.query.QueryDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class GoodsPictureQueryDTO extends QueryDTO {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("商品id")
    private Long goodsId;

    @ApiModelProperty("商品id列表")
    private List<Long> goodsIdList;

    @ApiModelProperty("图片地址")
    private String pictureAddress;

    @ApiModelProperty("图片地址列表")
    private List<String> pictureAddressList;

    @ApiModelProperty("图片地址模糊字段")
    private String pictureAddressLike;



    /**
     * -------------------------------------------------
     * 上面字段由工具自动生成，请在下面添加扩充字段
     * -------------------------------------------------
     */


}