package org.hqu.elevatorManage.domain.dto;

import java.time.LocalDateTime;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Length;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;

import lombok.Data;

/**
 * [User]DTO
 *
 * @author hqully
 * @date 2022-10-16 17:05:20
 */
@ApiModel(description = "用户账号表")
@Data
public class UserDTO implements Serializable {

    private static final long serialVersionUID = -12390963112485644L;
    
    /**
     * 物理id
     */
    @ApiModelProperty("物理id")
    private Long id;
    
    /**
     * 用户id
     */
    @ApiModelProperty("用户id")
    @Length(max = 255, message = "用户id长度不能超过255")
    private String userId;
    
    /**
     * 用户名
     */
    @ApiModelProperty("用户名")
    @NotBlank(message = "用户名不能为空")
    @Length(max = 20, message = "用户名长度不能超过20")
    private String username;
    
    /**
     * 用户昵称
     */
    @ApiModelProperty("用户昵称")
    private String nickName;
    
    /**
     * 密码
     */
    @ApiModelProperty("密码")
    @NotBlank(message = "密码不能为空")
    @Length(max = 255, message = "密码长度不能超过255")
    private String password;
    
    /**
     * 加密盐值
     */
    @ApiModelProperty("加密盐值")
    private String salt;
    
    /**
     * 角色id
     */
    @ApiModelProperty("角色id")
    @NotNull(message = "角色id不能为空")
    private String roleId;
    
    /**
     * 用户头像url
     */
    @ApiModelProperty("用户头像url")
    private String avatar;
    
    /**
     * 用户邮箱
     */
    @ApiModelProperty("用户邮箱")
    private String email;
    
    /**
     * 用户性别
     */
    @ApiModelProperty("用户性别")
    private Integer gender;
    
    /**
     * 用户手机号
     */
    @ApiModelProperty("用户手机号")
    private String phone;
    
    /**
     * 账号所属公司id
     */
    @ApiModelProperty("账号所属公司id")
    @NotNull(message = "用户公司不能为空")
    private String companyId;
    
    /**
     * 用户创建时间
     */
    @ApiModelProperty("用户创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime createTime;
    
    /**
     * 用户状态(停用为0,正常为1)
     */
    @ApiModelProperty("用户状态(停用为0,正常为1)")
    private Integer state;
    

}

