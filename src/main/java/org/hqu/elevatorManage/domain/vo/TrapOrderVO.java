package org.hqu.elevatorManage.domain.vo;

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
 * [TrapOrder]VO
 *
 * @author hqully
 * @date 2022-10-27 21:21:33
 */
@ApiModel(description = "电梯困人工单表")
@Data
public class TrapOrderVO implements Serializable {

    private static final long serialVersionUID = 833775040418131414L;
    
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
     * 维保公司id
     */
    @ApiModelProperty("维保公司id")
    private String companyId;
    
    /**
     * 维保公司名称(查询冗余)
     */
    @ApiModelProperty("维保公司名称(查询冗余)")
    private String companyName;
    
    /**
     * 维保班组id
     */
    @ApiModelProperty("维保班组id")
    private String groupId;
    
    /**
     * 维保班组名称(查询冗余)
     */
    @ApiModelProperty("维保班组名称(查询冗余)")
    private String groupName;
    
    /**
     * 困人时间
     */
    @ApiModelProperty("困人时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime trapTime;
    
    /**
     * 工作人员到达时间
     */
    @ApiModelProperty("工作人员到达时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime arriveTime;
    
    /**
     * 解困时间
     */
    @ApiModelProperty("解困时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime finishTime;
    
    /**
     * 持续时间,使用秒数存储
     */
    @ApiModelProperty("持续时间,使用秒数存储")
    private Long duration;
    
    /**
     * 是否误报
     */
    @ApiModelProperty("是否误报")
    private Boolean misreport;
    
    /**
     * 工单状态
     */
    @ApiModelProperty("工单状态")
    private Integer state;
    

}

