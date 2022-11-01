package org.hqu.elevatorManage.domain.entity;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Length;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;

import lombok.Data;

/**
 * [WorkerGroup]实体类
 *
 * @author hqully
 * @date 2022-10-29 20:00:16
 */
@ApiModel(description = "班组表")
@Data
public class WorkerGroup implements Serializable {

    private static final long serialVersionUID = 477500390908811377L;
    
    /**
     * 物理id
     */
    @ApiModelProperty("物理id")
    @NotNull(message = "物理id不能为空")
    private Long id;
    
    /**
     * 组代号
     */
    @ApiModelProperty("组代号")
    @NotNull(message = "组代号不能为空")
    private String groupId;
    
    /**
     * 所属公司id
     */
    @ApiModelProperty("所属公司id")
    @NotNull(message = "所属公司id不能为空")
    private String companyId;
    
    /**
     * 组名称
     */
    @ApiModelProperty("组名称")
    private String name;
    
    /**
     * 组人数
     */
    @ApiModelProperty("组人数")
    private Integer number;
    
    /**
     * 组领导
     */
    @ApiModelProperty("组领导")
    private String leader;
    
    /**
     * 联系方式
     */
    @ApiModelProperty("联系方式")
    private String contactInfo;
    
    /**
     * 备注
     */
    @ApiModelProperty("备注")
    private String remark;
    
    /**
     * 组状态
     */
    @ApiModelProperty("组状态")
    private Integer state;
    

}

