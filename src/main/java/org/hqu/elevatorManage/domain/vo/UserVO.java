package org.hqu.elevatorManage.domain.vo;

import java.time.LocalDateTime;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Length;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

/**
 * [User]VO
 *
 * @author hqully
 * @date 2022-10-16 17:05:20
 */
@ApiModel(description = "用户账号表")
@Data
public class UserVO implements Serializable {

    private static final long serialVersionUID = 171292387396665316L;
    
    /**
     * 物理id
     */
    @ApiModelProperty("物理id")
    @NotNull(message = "物理id不能为空")
    private Long id;
    
    /**
     * 用户id
     */
    @ApiModelProperty("用户id")
    @NotBlank(message = "用户id不能为空")
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
    private String roleId;


    /**
     * 账号角色组
     */
    private List<String> roles;
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
    private String companyId;

    /**
     * 账号所属公司名称
     */
    @ApiModelProperty("账号所属公司名称")
    private String companyName;

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

