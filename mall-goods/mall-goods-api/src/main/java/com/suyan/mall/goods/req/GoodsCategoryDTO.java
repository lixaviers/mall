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
public class GoodsCategoryDTO implements Serializable {

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
     * 父类id
     */
    @ApiModelProperty("父类id")
    @NotNull(message = "父类id不能为空", groups = BaseInterface.class)
    private Integer parentId;

    /**
     * 类目名称
     */
    @ApiModelProperty("类目名称")
    @NotNull(message = "类目名称不能为空", groups = BaseInterface.class)
    @Size(max = 32, message = "类目名称不能超过32位", groups = BaseInterface.class)
    private String categoryName;

    /**
     * 类型 1.前台 2.后台
     */
    @ApiModelProperty("类型 1.前台 2.后台")
    @NotNull(message = "类型 1.前台 2.后台不能为空", groups = BaseInterface.class)
    private Byte categoryType;

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
     * -------------------------------------------------
     * 上面字段由工具自动生成，请在下面添加扩充字段
     * -------------------------------------------------
     */


}