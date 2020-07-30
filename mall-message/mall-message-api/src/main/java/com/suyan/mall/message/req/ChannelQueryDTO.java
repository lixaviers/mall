package com.suyan.mall.message.req;

import com.suyan.query.QueryDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class ChannelQueryDTO extends QueryDTO {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("id")
    private Integer id;

    @ApiModelProperty("id列表")
    private List<Integer> idList;

    @ApiModelProperty("渠道编码")
    private String channelCode;

    @ApiModelProperty("渠道编码列表")
    private List<String> channelCodeList;

    @ApiModelProperty("渠道编码模糊字段")
    private String channelCodeLike;

    @ApiModelProperty("渠道名称")
    private String channelName;

    @ApiModelProperty("渠道名称列表")
    private List<String> channelNameList;

    @ApiModelProperty("渠道名称模糊字段")
    private String channelNameLike;

    @ApiModelProperty("联系人")
    private String contactName;

    @ApiModelProperty("联系人列表")
    private List<String> contactNameList;

    @ApiModelProperty("联系人模糊字段")
    private String contactNameLike;

    @ApiModelProperty("安全秘钥key")
    private String secretKey;

    @ApiModelProperty("安全秘钥key列表")
    private List<String> secretKeyList;

    @ApiModelProperty("安全秘钥key模糊字段")
    private String secretKeyLike;

    @ApiModelProperty("支持类型")
    private String supportType;

    @ApiModelProperty("支持类型列表")
    private List<String> supportTypeList;

    @ApiModelProperty("支持类型模糊字段")
    private String supportTypeLike;

    @ApiModelProperty("备注")
    private String remark;

    @ApiModelProperty("备注列表")
    private List<String> remarkList;

    @ApiModelProperty("备注模糊字段")
    private String remarkLike;

    @ApiModelProperty("创建时间起")
    private LocalDateTime createTimeFrom;

    @ApiModelProperty("创建时间止")
    private LocalDateTime createTimeTo;

    @ApiModelProperty("创建人")
    private String createUser;

    @ApiModelProperty("创建人列表")
    private List<String> createUserList;

    @ApiModelProperty("创建人模糊字段")
    private String createUserLike;

    @ApiModelProperty("创建人名称")
    private String createUserName;

    @ApiModelProperty("创建人名称列表")
    private List<String> createUserNameList;

    @ApiModelProperty("创建人名称模糊字段")
    private String createUserNameLike;

    @ApiModelProperty("更新时间起")
    private LocalDateTime updateTimeFrom;

    @ApiModelProperty("更新时间止")
    private LocalDateTime updateTimeTo;

    @ApiModelProperty("是否删除：0.未删除，1.已删除")
    private Boolean isDeleted;

    @ApiModelProperty("是否删除：0.未删除，1.已删除列表")
    private List<Boolean> isDeletedList;


    /**
     * -------------------------------------------------
     * 上面字段由工具自动生成，请在下面添加扩充字段
     * -------------------------------------------------
     */


}