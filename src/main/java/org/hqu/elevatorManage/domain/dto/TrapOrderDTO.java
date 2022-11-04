package org.hqu.elevatorManage.domain.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * [TrapOrder]DTO
 *
 * @author hqully
 * @date 2022-10-27 21:21:33
 */
@ApiModel(description = "电梯困人工单表")
@Data
public class TrapOrderDTO implements Serializable {

    private static final long serialVersionUID = -25139445858351331L;
    
    /**
     * 物理id
     */
    @ApiModelProperty("物理id")
    private Long id;
    
    /**
     * 工单号
     */
    @ApiModelProperty("工单号")
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
     * 工单创建时间
     */
    @ApiModelProperty("工单创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime createTime;

    /**
     * 困人时间
     */
    @ApiModelProperty("困人时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime trapTime;

    /**
     * 领取时间
     */
    @ApiModelProperty("领取时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime receiveTime;

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

    // for query

    /**
     * 工单创建时间区间开始
     */
    @ApiModelProperty("工单创建时间区间开始")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime createStartTime;

    /**
     * 工单创建时间区间结束
     */
    @ApiModelProperty("工单创建时间区间结束")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime createEndTime;

    /**
     * 困人时间区间开始
     */
    @ApiModelProperty("困人时间区间开始")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime trapStartTime;

    /**
     * 困人时间区间结束
     */
    @ApiModelProperty("困人时间区间结束")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime trapEndTime;
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
     * 工作人员到达时间区间开始
     */
    @ApiModelProperty("工作人员到达时间区间开始")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime arriveStartTime;

    /**
     * 工作人员到达时间区间结束
     */
    @ApiModelProperty("工作人员到达时间区间结束")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime arriveEndTime;

    /**
     * 救援结束时间区间开始
     */
    @ApiModelProperty("救援结束时间区间开始")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime finishStartTime;

    /**
     * 救援结束时间区间结束
     */
    @ApiModelProperty("救援结束时间区间结束")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime finishEndTime;

    // for query
    /**
     * 省行政区划编号
     */
    @ApiModelProperty("省行政区划编号")
    private String provinceId;

    /**
     * 市行政区划编号
     */
    @ApiModelProperty("市行政区划编号")
    private String cityId;

    /**
     * 区/县行政区划编号
     */
    @ApiModelProperty("区/县行政区划编号")
    private String districtId;

    /**
     * 乡/镇/街道行政区划编号
     */
    @ApiModelProperty("乡/镇/街道行政区划编号")
    private String townId;
}

