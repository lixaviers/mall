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
public class GoodsBrandDTO implements Serializable {

    /**
     * serialVersionUID
     */ 
    private static final long serialVersionUID = 1L;

        
    /**
     * id
     */
    @ApiModelProperty(value = "id", hidden = true)
    @NotNull(message = "id不能为空", groups = UpdateInterface.class)
    private Integer id;
        
    /**
     * 品牌名称
     */
    @ApiModelProperty("品牌名称")
    @NotNull(message = "品牌名称不能为空", groups = BaseInterface.class)
    @Size(max = 64, message = "品牌名称不能超过64位", groups = BaseInterface.class)
    private String brandName;
        
    /**
     * 品牌logo
     */
    @ApiModelProperty("品牌logo")
    @Size(max = 255, message = "品牌logo不能超过255位", groups = BaseInterface.class)
    private String brandLogo;
        
    /**
     * 品牌介绍
     */
    @ApiModelProperty("品牌介绍")
    @Size(max = 1000, message = "品牌介绍不能超过1000位", groups = BaseInterface.class)
    private String brandIntroduce;
        
    /**
     * 是否启用
     */
    @ApiModelProperty("是否启用")
    @NotNull(message = "是否启用不能为空", groups = BaseInterface.class)
    private Boolean isEnable;
        
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
     * 是否删除
     */
    @ApiModelProperty(value = "是否删除", hidden = true)
    private Boolean isDeleted;


    /**
     * -------------------------------------------------
     * 上面字段由工具自动生成，请在下面添加扩充字段
     * -------------------------------------------------
     */


}