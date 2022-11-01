package org.hqu.elevatorManage.domain.entity;

    
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
 * [RepairOrder]实体类
 *
 * @author hqully
 * @date 2022-10-27 20:50:46
 */
@ApiModel(description = "维修工单表")
@Data
public class RepairOrder implements Serializable {

    private static final long serialVersionUID = 138251356114270641L;
    
    /**
     * 物理id
     */
    @ApiModelProperty("物理id")
    @NotNull(message = "物理id不能为空")
    private Long id;
    
    /**
     * 工单号
     */
    @ApiModelProperty("工单号")
    @NotNull(message = "工单号不能为空")
    private String orderId;
    
    /**
     * 电梯uuid
     */
    @ApiModelProperty("电梯uuid")
    private String elevatorId;
    
    /**
     * 终端id
     */
    @ApiModelProperty("终端id")
    private String terminalId;
    
    /**
     * 报告者id
     */
    @ApiModelProperty("报告者id")
    private String reporterId;
    
    /**
     * 维修公司id
     */
    @ApiModelProperty("维修公司id")
    private String companyId;
    
    /**
     * 维修公司名称(查询冗余)
     */
    @ApiModelProperty("维修公司名称(查询冗余)")
    private String companyName;
    
    /**
     * 维修班组id
     */
    @ApiModelProperty("维修班组id")
    private String groupId;
    
    /**
     * 维修班组名称(查询冗余)
     */
    @ApiModelProperty("维修班组名称(查询冗余)")
    private String groupName;
    
    /**
     * 故障描述
     */
    @ApiModelProperty("故障描述")
    private String description;
    
    /**
     * 故障原因
     */
    @ApiModelProperty("故障原因")
    private String reason;
    
    /**
     * 故障类型
     */
    @ApiModelProperty("故障类型")
    private String type;
    
    /**
     * 维修时间
     */
    @ApiModelProperty("维修时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime repairTime;
    
    /**
     * 确认时间
     */
    @ApiModelProperty("确认时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime confirmTime;
    
    /**
     * 维修备注
     */
    @ApiModelProperty("维修备注")
    private String remark;
    
    /**
     * 工单状态
     */
    @ApiModelProperty("工单状态")
    private Integer state;
    
    /**
     * 是否误报
     */
    @ApiModelProperty("是否误报")
    private Boolean misreport;
    

}

