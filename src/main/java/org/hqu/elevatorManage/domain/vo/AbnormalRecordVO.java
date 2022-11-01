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
 * [AbnormalRecord]VO
 *
 * @author hqully
 * @date 2022-10-28 09:45:59
 */
@ApiModel(description = "电梯故障记录表")
@Data
public class AbnormalRecordVO implements Serializable {

    private static final long serialVersionUID = -29914497972649310L;
    
    /**
     * 物理id
     */
    @ApiModelProperty("物理id")
    @NotNull(message = "物理id不能为空")
    private Long id;
    
    /**
     * 异常记录id
     */
    @ApiModelProperty("异常记录id")
    @NotBlank(message = "异常记录id不能为空")
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
    

}

