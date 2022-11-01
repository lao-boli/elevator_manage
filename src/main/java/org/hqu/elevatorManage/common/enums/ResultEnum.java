package org.hqu.elevatorManage.common.enums;


import lombok.Getter;

/**
 * <p>
 * 后台返回结果集枚举
 * </p>
 * @author liulingyu
 * @date 2022-05-07 15:43
 * @version 1.0
 */
@Getter
public enum ResultEnum  {

    /**
     * 通用状态
     */
    SUCCESS(20000, "成功"),
    ERROR(40000, "错误"),

    /**
     * 账户问题
     */
    USER_EXIST(40001, "该用户名已经存在"),
    USER_PWD_NULL(40002, "密码不能为空"),
    USER_INEQUALITY(40003, "两次密码不一致"),
    USER_OLD_PWD_ERROR(40004, "原来密码不正确"),
    USER_NAME_PWD_NULL(40005, "用户名和密码不能为空"),
    USER_CAPTCHA_ERROR(40006, "验证码错误"),
    USER_LOGOUT(40007, "用户已退出登录"),
    USER_PWD_SAME(40008, "新密码不能与旧密码相同"),
    NO_PERMISSIONS(40001, "权限不足！"),

    /**
     * 数据库问题
     */
    PRIMARY_KEY_CONFLICT(50001,"主键冲突"),
    DUPLICATE_KEY_CONFLICT(50002,"键冲突"),
    RESULT_NULL(50002,"返回数据为空");

    private Integer code;

    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
