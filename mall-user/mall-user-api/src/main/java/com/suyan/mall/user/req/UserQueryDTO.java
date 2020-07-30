package com.suyan.mall.user.req;

import com.suyan.query.QueryDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class UserQueryDTO extends QueryDTO {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("ID")
    private Long id;

    @ApiModelProperty("ID列表")
    private List<Long> idList;

    @ApiModelProperty("用户唯一标识")
    private String uniqueUserId;

    @ApiModelProperty("用户唯一标识列表")
    private List<String> uniqueUserIdList;

    @ApiModelProperty("用户唯一标识模糊字段")
    private String uniqueUserIdLike;

    @ApiModelProperty("用户账号")
    private String userName;

    @ApiModelProperty("用户账号列表")
    private List<String> userNameList;

    @ApiModelProperty("用户账号模糊字段")
    private String userNameLike;

    @ApiModelProperty("用户昵称")
    private String nickName;

    @ApiModelProperty("用户昵称列表")
    private List<String> nickNameList;

    @ApiModelProperty("用户昵称模糊字段")
    private String nickNameLike;

    @ApiModelProperty("手机号")
    private String mobile;

    @ApiModelProperty("手机号列表")
    private List<String> mobileList;

    @ApiModelProperty("手机号模糊字段")
    private String mobileLike;

    @ApiModelProperty("邮箱账号")
    private String email;

    @ApiModelProperty("邮箱账号列表")
    private List<String> emailList;

    @ApiModelProperty("邮箱账号模糊字段")
    private String emailLike;

    @ApiModelProperty("密码")
    private String userPwd;

    @ApiModelProperty("密码列表")
    private List<String> userPwdList;

    @ApiModelProperty("密码模糊字段")
    private String userPwdLike;

    @ApiModelProperty("来源")
    private Byte userSource;

    @ApiModelProperty("来源列表")
    private List<Byte> userSourceList;

    @ApiModelProperty("状态")
    private Byte userStatus;

    @ApiModelProperty("状态列表")
    private List<Byte> userStatusList;

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

    @ApiModelProperty("创建时间起")
    private LocalDateTime createTimeFrom;

    @ApiModelProperty("创建时间止")
    private LocalDateTime createTimeTo;

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