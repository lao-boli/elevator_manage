package org.hqu.elevatorManage.domain.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * [RepairOrder]VO
 *
 * @author hqully
 * @date 2022-10-27 20:50:46
 */
@ApiModel(description = "维修工单表")
@Data
public class RepairOrderVO implements Serializable {

    private static final long serialVersionUID = 608333297229113888L;
    
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
    @NotBlank(message = "工单号不能为空")
    @Length(max = 255, message = "工单号长度不能超过255")
    private String orderId;
    
    /**
     * 电梯uuid
     */
    @ApiModelProperty("电梯uuid")
    private String elevatorId;

    /**
     * 电梯名称
     */
    @ApiModelProperty("电梯名称")
    private String elevatorName;

    /**
     * 电梯注册代码
     */
    @ApiModelProperty("电梯注册代码")
    private String registrationCode;

    /**
     * 电梯安装位置
     */
    @ApiModelProperty("电梯安装位置")
    private String installPosition;

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
     * 工单创建时间
     */
    @ApiModelProperty("工单创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime createTime;

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

    // for show

    /**
     * 电梯所属单位名称
     */
    @ApiModelProperty("电梯所属单位名称")
    private String unitName;

}

