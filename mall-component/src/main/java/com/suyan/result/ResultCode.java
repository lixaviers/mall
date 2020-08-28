package com.suyan.result;

public enum ResultCode {

    /**
     * 操作成功标识
     */
    SUCCESS(200, "Success"),

    C301(301, "资源已被移除"),
    C303(303, "重定向"),

    C401(401, "没有此操作权限"),
    C403(403, "访问受限"),
    C404(404, "资源未找到"),
    C405(405, "请求方法错误"),
    C400(400, "参数列表错误"),
    C415(415, "不支持的数据（媒体类型）"),
    C429(429, "请求过多被限制"),

    SYS_ERROR(500, "当前网络不稳定，请稍后重试"),
    C501(501, "接口未实现"),
    TOO_MANY_REQUESTS(506, "请求过多"),
    SYS_OPT_ERROR(507, "操作失败，请刷新页面重试"),

    NO_LOGGED_IN(600, "用户未登录"),
    SESSION_INVALID_ERROR(601, "登录失效，请重新登录"),
    LOGIN_ERROR(602, "用户名和密码不匹配"),
    USER_DELETE_ERROR(603, "您的账号已经被删除，请联系管理员"),
    USER_DISABLE_ERROR(604, "您的账号已经被禁用，请联系管理员"),
    USER_SHOP_ERROR(605, "请选择店铺"),

    //----------------------------------------
    // 通用异常
    // 区间：700-799
    //----------------------------------------
    COMMON_PARAM_NULL(700, "必要参数[%s]为空"),
    COMMON_PARAM_INVALID(701, "%s无效"),
    CONTAINS_ILLEGAL_CHARACTERS(702, "%s含有非法字符"),
    DATA_NOT_EXIST(703, "%s不存在"),
    NO_PERMISSION_OPERATE(704, "没有%s的操作权限"),
    CAN_NOT_BE_OPERATE(705, "%s不能%s"),
    FIELD_NOT_ALLOWED_EMPTY(706, "%s不能为空"),
    FIELD_VALUE_MUST_LARGE_THAN(707, "%s必须大于%s"),
    FIELD_VALUE_MUST_LESS_THAN(708, "%s必须小于%s"),
    DATA_EXIST(709, "%s已存在"),
    FIELD_NOT_EMAIL(710, "%s格式错误"),
    FIELD_NOT_MOBILE(711, "%s格式错误"),
    FIELD_NOT_ID_NUM(712, "%s格式错误"),
    FIELD_NOT_DATE(713, "%s格式错误"),
    FIELD_LENGTH_MUST_LESS(714, "%s必须小于%d"),
    FIELD_LENGTH_MUST_MORE(715, "%s必须大于%d"),
    FIELD_LENGTH_MUST_BETWEEN(716, "%s长度必须大于%d和小于%d"),
    FILED_NOT_IN_ENUM_VALUES(717, "不支持的%s"),
    FIELD_NOT_BOTH_BE_EMPTY(718, "%s不能同时为空"),
    MUST_BE_INTEGER_MULTIPLE(719, "%s必须是%s的整数倍"),
    UPLOAD_FILE_ERROR(720, "上传文件出错，%s"),
    FIELD_VALUE_MUST_GE_THAN(721, "%s必须大于等于%s"),
    FIELD_VALUE_MUST_LE_THAN(722, "%s必须小于等于%s"),
    FIELD_VALUE_MUST_DONE(723, "%s还未%s"),
    TIME_MUST_LARGE_THAN(724, "%s必须晚于%s"),
    TIME_VALUE_MUST_LESS_THAN(725, "%s必须早于%s"),
    INVALID_CHANGE_STATUS(726, "%s更新状态非法"),
    LENGTH_MUST_LESS(727, "%s必须小于%s"),
    LENGTH_MUST_MORE(728, "%s必须大于%s"),
    NO_DATA_FOUND(729, "暂无数据"),

    //----------------------------------------
    // api调用异常
    // 区间：800-899
    //----------------------------------------
    API_INVLID_SIGN(800, "签名错误"),
    API_INVLID_FROM(801, "没有权限访问"),
    API_INVLID_DATA(802, "请求%s数据错误"),
    API_INVLID_DATA_FORMAT(803, "数据格式不符合要求"),
    API_INVLID_API(804, "api【%s】不存在"),
    EXTERNAL_SYSTEM_ERROR(805, "调用外部系统[%s]出错"),

    /**
     * 公用错误
     */
    COMMON_MESSAGE(1000, "%s"),

    ;


    public int code;
    public String desc;

    ResultCode(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
