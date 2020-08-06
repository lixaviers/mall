package com.suyan.mall.mmc.req;

import com.suyan.service.BaseInterface;
import com.suyan.service.UpdateInterface;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class BargainActivityDTO implements Serializable {

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
     * 店铺id
     */
    @ApiModelProperty("店铺id")
    @NotNull(message = "店铺id不能为空", groups = BaseInterface.class)
    private Long shopId;
        
    /**
     * 活动名称
     */
    @ApiModelProperty("活动名称")
    @NotNull(message = "活动名称不能为空", groups = BaseInterface.class)
    @Size(max = 64, message = "活动名称不能超过64位", groups = BaseInterface.class)
    private String activityName;
        
    /**
     * 开始时间
     */
    @ApiModelProperty("开始时间")
    private LocalDateTime startTime;
        
    /**
     * 结束时间
     */
    @ApiModelProperty("结束时间")
    private LocalDateTime endTime;
        
    /**
     * 活动规则
     */
    @ApiModelProperty("活动规则")
    @Size(max = 2000, message = "活动规则不能超过2000位", groups = BaseInterface.class)
    private String activityRule;
        
    /**
     * 活动状态
     */
    @ApiModelProperty("活动状态")
    private Byte activityStatus;
        

    /**
     * -------------------------------------------------
     * 上面字段由工具自动生成，请在下面添加扩充字段
     * -------------------------------------------------
     */


}