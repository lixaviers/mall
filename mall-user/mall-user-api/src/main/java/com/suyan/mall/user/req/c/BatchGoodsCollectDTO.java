package com.suyan.mall.user.req.c;

import com.suyan.service.BaseInterface;
import com.suyan.service.UpdateInterface;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Data
public class BatchGoodsCollectDTO implements Serializable {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 1L;


    /**
     * id列表
     */
    @ApiModelProperty(value = "id列表", hidden = true)
    @NotNull(message = "id不能为空")
    private List<Long> goodsIdList;

    /**
     * 用户唯一标识
     */
    @ApiModelProperty("用户唯一标识")
    @NotNull(message = "用户不能为空")
    private String uniqueUserId;



}