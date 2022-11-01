package org.hqu.elevatorManage.domain.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Length;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;

import lombok.Data;

/**
 * [Role]DTO
 *
 * @author hqully
 * @date 2022-10-19 19:13:13
 */
@ApiModel(description = "系统角色表")
@Data
public class RoleDTO implements Serializable {

    private static final long serialVersionUID = -90789748638891967L;
    
    /**
     * 物理id
     */
    @ApiModelProperty("物理id")
    @NotNull(message = "物理id不能为空")
    private Long id;
    
    /**
     * 角色名称
     */
    @ApiModelProperty("角色名称")
    @NotBlank(message = "角色名称不能为空")
    @Length(max = 20, message = "角色名称长度不能超过20")
    private String name;
    
    /**
     * 角色id
     */
    @ApiModelProperty("角色id")
    @NotBlank(message = "角色id不能为空")
    @Length(max = 255, message = "角色id长度不能超过255")
    private String roleId;
    

}

