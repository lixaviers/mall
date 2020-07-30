package com.suyan.query;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@ApiModel("分页输出结果基类")
@Data
public class QueryResultVO<E> implements Serializable {
    private static final long serialVersionUID = 8189778548888809030L;

    /**
     * @Fields pageNum : 第几页
     */
    @ApiModelProperty("第几页")
    private int pageNo;

    /**
     * @Fields pageNum : 是否有下一页
     */
    private boolean hasNextPage = true;

    /**
     * @Fields pageSize : 每页多少数据
     */
    @ApiModelProperty("每页多少数据")
    private int pageSize;

    /**
     * @Fields totalPages : 总页数
     */
    @ApiModelProperty("总页数")
    private int totalPages;

    /**
     * @Fields totalRecords : 总记录数
     */
    @ApiModelProperty("总记录数")
    private long totalRecords;

    /**
     * @Fields records : 返回记录列表
     */
    @ApiModelProperty("返回记录列表")
    private List<E> records;


    public boolean getHasNextPage() {
        if (this.totalRecords > (this.pageNo * this.pageSize)) {
            this.setHasNextPage(true);
            return true;
        } else {
            this.setHasNextPage(false);
            return false;
        }
    }

    public void setHasNextPage(boolean hasNextPage) {
        this.hasNextPage = hasNextPage;
    }

}
