package com.suyan.mall.operation.resp;

import com.suyan.utils.CollectionsUtil;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@ApiModel("类目")
public class CategoryVO implements Serializable {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 1L;


    /**
     * id
     */
    @ApiModelProperty("id")
    private Integer id;

    /**
     * 父类id
     */
    @ApiModelProperty("父类id")
    private Integer parentId;

    /**
     * 类目名称
     */
    @ApiModelProperty("类目名称")
    private String categoryName;

    /**
     * 排序
     */
    @ApiModelProperty("排序")
    private Integer sortNumber;

    /**
     * 创建时间
     */
    @ApiModelProperty("创建时间")
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    @ApiModelProperty("更新时间")
    private LocalDateTime updateTime;


    /**
     * -------------------------------------------------
     * 上面字段由工具自动生成，请在下面添加扩充字段
     * -------------------------------------------------
     */


    /**
     * 子类目集合
     */
    private List<CategoryVO> childCategoryList;

    /**
     * 增加子类目
     */
    public void addChildCategoryList(CategoryVO categoryVO) {
        if (CollectionsUtil.isEmpty(childCategoryList)) {
            childCategoryList = new ArrayList<>();
        }
        childCategoryList.add(categoryVO);
    }


}