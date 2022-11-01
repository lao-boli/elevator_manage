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
 * [AnnualInspectionOrder]实体类
 *
 * @author hqully
 * @date 2022-10-30 19:21:29
 */
@ApiModel(description = "维修工单表")
@Data
public class AnnualInspectionOrder implements Serializable {

    private static final long serialVersionUID = 714233651401091138L;
    
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
     * 类型
     */
    @ApiModelProperty("类型")
    private Integer type;
    
    /**
     * 创建时间
     */
    @ApiModelProperty("创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime createTime;
    
    /**
     * 年检时间
     */
    @ApiModelProperty("年检时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime inspectionTime;
    
    /**
     * 完成时间
     */
    @ApiModelProperty("完成时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime finishTime;
    
    /**
     * 确认时间
     */
    @ApiModelProperty("确认时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime confirmTime;
    
    /**
     * 工单状态
     */
    @ApiModelProperty("工单状态")
    private Integer state;
    
    /**
     * 备注
     */
    @ApiModelProperty("备注")
    private String remark;
    

}

