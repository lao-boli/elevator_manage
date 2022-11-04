package org.hqu.elevatorManage.domain.dto;

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
 * [AbnormalRecord]DTO
 *
 * @author hqully
 * @date 2022-10-28 15:27:31
 */
@ApiModel(description = "电梯故障记录表")
@Data
public class AbnormalRecordDTO implements Serializable {

    private static final long serialVersionUID = -24491098113247849L;
    
    /**
     * 物理id
     */
    @ApiModelProperty("物理id")
    private Long id;
    
    /**
     * 异常记录id
     */
    @ApiModelProperty("异常记录id")
    @Length(max = 255, message = "异常记录id长度不能超过255")
    private String recordId;
    
    /**
     * 电梯uuid
     */
    @ApiModelProperty("电梯uuid")
    @NotBlank(message = "电梯uuid不能为空")
    @Length(max = 255, message = "电梯uuid长度不能超过255")
    private String elevatorId;
    
    /**
     * 终端id
     */
    @ApiModelProperty("终端id")
    @NotBlank(message = "终端id不能为空")
    @Length(max = 255, message = "终端id长度不能超过255")
    private String terminalId;
    
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
     * 异常发生楼层
     */
    @ApiModelProperty("异常发生楼层")
    private String floor;
    
    /**
     * 发生时间
     */
    @ApiModelProperty("发生时间")
    @NotNull(message = "发生时间不能为空")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime occurTime;

    /**
     * 发生时间区间开始
     */
    @ApiModelProperty("发生时间区间开始")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime occurStartTime;

    /**
     * 发生时间区间结束
     */
    @ApiModelProperty("发生时间区间结束")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime occurEndTime;

    /**
     * 结束时间
     */
    @ApiModelProperty("结束时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime endTime;
    
    /**
     * 异常类型
     */
    @ApiModelProperty("异常类型")
    private String type;
    
    /**
     * 异常状态
     */
    @ApiModelProperty("异常状态")
    private Integer state;

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

