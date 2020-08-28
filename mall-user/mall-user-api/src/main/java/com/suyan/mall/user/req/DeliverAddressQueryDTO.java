package com.suyan.mall.user.req;

import com.suyan.query.QueryDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class DeliverAddressQueryDTO extends QueryDTO {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("id")
    private Long id;

    @ApiModelProperty("id列表")
    private List<Long> idList;

    @ApiModelProperty("用户唯一标识")
    private String uniqueUserId;

    @ApiModelProperty("用户唯一标识列表")
    private List<String> uniqueUserIdList;

    @ApiModelProperty("用户唯一标识模糊字段")
    private String uniqueUserIdLike;

    @ApiModelProperty("收货人")
    private String consignee;

    @ApiModelProperty("收货人列表")
    private List<String> consigneeList;

    @ApiModelProperty("收货人模糊字段")
    private String consigneeLike;

    @ApiModelProperty("手机号")
    private String mobile;

    @ApiModelProperty("手机号列表")
    private List<String> mobileList;

    @ApiModelProperty("手机号模糊字段")
    private String mobileLike;

    @ApiModelProperty("邮政编码")
    private String zipCode;

    @ApiModelProperty("邮政编码列表")
    private List<String> zipCodeList;

    @ApiModelProperty("邮政编码模糊字段")
    private String zipCodeLike;

    @ApiModelProperty("省份编码")
    private String provinceCode;

    @ApiModelProperty("省份编码列表")
    private List<String> provinceCodeList;

    @ApiModelProperty("省份编码模糊字段")
    private String provinceCodeLike;

    @ApiModelProperty("省份名称")
    private String provinceName;

    @ApiModelProperty("省份名称列表")
    private List<String> provinceNameList;

    @ApiModelProperty("省份名称模糊字段")
    private String provinceNameLike;

    @ApiModelProperty("城市编码")
    private String cityCode;

    @ApiModelProperty("城市编码列表")
    private List<String> cityCodeList;

    @ApiModelProperty("城市编码模糊字段")
    private String cityCodeLike;

    @ApiModelProperty("城市名称")
    private String cityName;

    @ApiModelProperty("城市名称列表")
    private List<String> cityNameList;

    @ApiModelProperty("城市名称模糊字段")
    private String cityNameLike;

    @ApiModelProperty("区编码")
    private String areaCode;

    @ApiModelProperty("区编码列表")
    private List<String> areaCodeList;

    @ApiModelProperty("区编码模糊字段")
    private String areaCodeLike;

    @ApiModelProperty("区名称")
    private String areaName;

    @ApiModelProperty("区名称列表")
    private List<String> areaNameList;

    @ApiModelProperty("区名称模糊字段")
    private String areaNameLike;

    @ApiModelProperty("详细地址")
    private String detailedAddress;

    @ApiModelProperty("详细地址列表")
    private List<String> detailedAddressList;

    @ApiModelProperty("详细地址模糊字段")
    private String detailedAddressLike;

    @ApiModelProperty("地址")
    private String address;

    @ApiModelProperty("地址列表")
    private List<String> addressList;

    @ApiModelProperty("地址模糊字段")
    private String addressLike;

    @ApiModelProperty("是否默认")
    private Boolean isDefault;

    @ApiModelProperty("是否默认列表")
    private List<Boolean> isDefaultList;

    @ApiModelProperty("创建时间起")
    private LocalDateTime createTimeFrom;

    @ApiModelProperty("创建时间止")
    private LocalDateTime createTimeTo;

    @ApiModelProperty("更新时间起")
    private LocalDateTime updateTimeFrom;

    @ApiModelProperty("更新时间止")
    private LocalDateTime updateTimeTo;

    @ApiModelProperty("是否删除")
    private Boolean isDeleted;

    @ApiModelProperty("是否删除列表")
    private List<Boolean> isDeletedList;



    /**
     * -------------------------------------------------
     * 上面字段由工具自动生成，请在下面添加扩充字段
     * -------------------------------------------------
     */


}