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
 * [MaintainOrder]DTO
 *
 * @author hqully
 * @date 2022-10-27 19:35:31
 */
@ApiModel(description = "维修工单表")
@Data
public class MaintainOrderDTO implements Serializable {

    private static final long serialVersionUID = 783949278630490493L;
    
    /**
     * 物理id
     */
    @ApiModelProperty("物理id")
    private Long id;
    
    /**
     * 工单号
     */
    @ApiModelProperty("工单号")
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
     * 维保间隔
     */
    @ApiModelProperty("维保间隔")
    private String duration;
    
    /**
     * 维保类型(半月保养、季度保养、半年保养、年度保养)
     */
    @ApiModelProperty("维保类型(半月保养、季度保养、半年保养、年度保养)")
    private String type;
    
    /**
     * 领取时间
     */
    @ApiModelProperty("领取时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime receiveTime;
    
    /**
     * 确认时间
     */
    @ApiModelProperty("确认时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime finishTime;
    
    /**
     * 计划时间
     */
    @ApiModelProperty("计划时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime planTime;
    
    /**
     * 工单接收人
     */
    @ApiModelProperty("工单接收人")
    private String recipient;
    
    /**
     * 工单状态
     */
    @ApiModelProperty("工单状态")
    private Integer state;
    
    /**
     * 是否领取
     */
    @ApiModelProperty("是否领取")
    private Boolean received;
    
    /**
     * 备注
     */
    @ApiModelProperty("备注")
    private String remark;

    // for query

    /**
     * 领取时间区间开始
     */
    @ApiModelProperty("领取时间区间开始")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime receiveStartTime;

    /**
     * 领取时间区间结束
     */
    @ApiModelProperty("领取时间区间结束")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime receiveEndTime;

    /**
     * 完成时间区间开始
     */
    @ApiModelProperty("完成时间区间开始")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime finishStartTime;

    /**
     * 完成时间区间结束
     */
    @ApiModelProperty("完成时间区间结束")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime finishEndTime;

    /**
     * 计划时间区间开始
     */
    @ApiModelProperty("计划时间区间开始")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime planStartTime;

    /**
     * 计划时间区间结束
     */
    @ApiModelProperty("计划时间区间结束")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime planEndTime;

}

