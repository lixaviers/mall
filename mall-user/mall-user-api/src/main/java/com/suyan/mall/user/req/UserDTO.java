package com.suyan.mall.user.req;

import com.suyan.service.BaseInterface;
import com.suyan.service.UpdateInterface;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Data
public class UserDTO implements Serializable {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 1L;


    /**
     * ID
     */
    @ApiModelProperty(value = "ID", hidden = true)
    @NotNull(message = "ID不能为空", groups = UpdateInterface.class)
    private Long id;

    /**
     * 用户唯一标识
     */
    @ApiModelProperty("用户唯一标识")
    @NotNull(message = "用户唯一标识不能为空", groups = BaseInterface.class)
    @Size(max = 32, message = "用户唯一标识不能超过32位", groups = BaseInterface.class)
    private String uniqueUserId;

    /**
     * 用户账号
     */
    @ApiModelProperty("用户账号")
    @NotNull(message = "用户账号不能为空", groups = BaseInterface.class)
    @Size(max = 32, message = "用户账号不能超过32位", groups = BaseInterface.class)
    private String userName;

    /**
     * 用户昵称
     */
    @ApiModelProperty("用户昵称")
    @NotNull(message = "用户昵称不能为空", groups = BaseInterface.class)
    @Size(max = 64, message = "用户昵称不能超过64位", groups = BaseInterface.class)
    private String nickName;

    /**
     * 手机号
     */
    @ApiModelProperty("手机号")
    @NotNull(message = "手机号不能为空", groups = {StoreLogin.class, StoreRegister.class, UserLogin.class, UserRegister.class})
    @Size(max = 16, message = "手机号不能超过16位", groups = {StoreLogin.class, StoreRegister.class})
    private String mobile;

    /**
     * 邮箱账号
     */
    @ApiModelProperty("邮箱账号")
    @Size(max = 32, message = "邮箱账号不能超过32位", groups = BaseInterface.class)
    private String email;

    /**
     * 密码
     */
    @ApiModelProperty("密码")
    @NotNull(message = "密码不能为空", groups = {StoreLogin.class, StoreRegister.class, UserLogin.class, UserRegister.class})
    @Size(max = 30, message = "密码不能超过30位", groups = {StoreRegister.class})
    private String userPwd;

    /**
     * 来源
     */
    @ApiModelProperty("来源")
    @NotNull(message = "来源不能为空", groups = BaseInterface.class)
    private Byte userSource;

    /**
     * 状态
     */
    @ApiModelProperty("状态")
    @NotNull(message = "状态不能为空", groups = BaseInterface.class)
    private Byte userStatus;

    /**
     * 备注
     */
    @ApiModelProperty("备注")
    @Size(max = 500, message = "备注不能超过500位", groups = BaseInterface.class)
    private String remark;

    /**
     * 创建人
     */
    @ApiModelProperty(value = "创建人", hidden = true)
    private String createUser;

    /**
     * 创建人名称
     */
    @ApiModelProperty(value = "创建人名称", hidden = true)
    private String createUserName;


    /**
     * -------------------------------------------------
     * 上面字段由工具自动生成，请在下面添加扩充字段
     * -------------------------------------------------
     */

    /**
     * 短信验证码
     */
    @NotNull(message = "短信验证码不能为空", groups = {StoreRegister.class, UserRegister.class})
    private String smsVerCode;

    /**
     * 店铺id
     */
    @ApiModelProperty("店铺id")
    @NotNull(message = "店铺不能为空", groups = {UserLogin.class})
    private Long shopId;


    /**
     * 用户登录验证接口
     */
    public interface UserLogin {
    }

    /**
     * 用户注册验证接口
     */
    public interface UserRegister {
    }

    /**
     * 商户登录验证接口
     */
    public interface StoreLogin {
    }

    /**
     * 商户注册验证接口
     */
    public interface StoreRegister {
    }

}