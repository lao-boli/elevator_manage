package org.hqu.elevatorManage.domain.dto;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import javax.validation.constraints.NotNull;

/**
 * <p>
 * 修改密码用数据传输对象
 * <p>
 *
 * @author hqully
 * @version 1.0
 * @date 2022/10/20 10:31
 */
@Data
public class PasswordDTO {

    /**
     * 要修改用户的用户id
     */
    @NotNull(message = "用户id不能为空")
    private String userId;

    /**
     * 旧密码
     */
    @NotNull(message = "旧密码不能为空")
    private String oldPassword;

    /**
     * 新密码
     */
    @NotNull(message = "新密码不能为空")
    private String newPassword;

    /**
     * 新密码的盐值
     */
    private String salt;

}
