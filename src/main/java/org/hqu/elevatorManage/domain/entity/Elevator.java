package org.hqu.elevatorManage.domain.entity;

    
    
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Length;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;

import lombok.Data;

/**
 * [Elevator]实体类
 *
 * @author hqully
 * @date 2022-10-31 09:14:22
 */
@ApiModel(description = "电梯表")
@Data
public class Elevator implements Serializable {

    private static final long serialVersionUID = -56795838638214979L;
    
    /**
     * 主键id
     */
    @ApiModelProperty("主键id")
    @NotNull(message = "主键id不能为空")
    private Long id;
    
    /**
     * 电梯32位uuid
     */
    @ApiModelProperty("电梯32位uuid")
    @NotBlank(message = "电梯32位uuid不能为空")
    @Length(max = 255, message = "电梯32位uuid长度不能超过255")
    private String elevatorId;
    
    /**
     * 电梯名
     */
    @ApiModelProperty("电梯名")
    private String name;
    
    /**
     * 电梯安装位置
     */
    @ApiModelProperty("电梯安装位置")
    private String installPosition;
    
    /**
     * 使用场所
     */
    @ApiModelProperty("使用场所")
    private String usagePlace;
    
    /**
     * 注册码
     */
    @ApiModelProperty("注册码")
    private String registrationCode;
    
    /**
     * 安装公司
     */
    @ApiModelProperty("安装公司")
    private String installCompany;
    
    /**
     * 电梯品牌
     */
    @ApiModelProperty("电梯品牌")
    private String brand;
    
    /**
     * 电梯最大载重
     */
    @ApiModelProperty("电梯最大载重")
    private String maxBearing;
    
    /**
     * 额定载重量
     */
    @ApiModelProperty("额定载重量")
    private String ratedLoad;
    
    /**
     * 电梯层数
     */
    @ApiModelProperty("电梯层数")
    private String layer;
    
    /**
     * 电梯站数
     */
    @ApiModelProperty("电梯站数")
    private String station;
    
    /**
     * 监测设备id
     */
    @ApiModelProperty("监测设备id")
    private String terminalId;
    
    /**
     * 所在区域id
     */
    @ApiModelProperty("所在区域id")
    private String areaId;
    
    /**
     * 电梯状态
     */
    @ApiModelProperty("电梯状态")
    private Integer state;
    
    /**
     * 使用场所
     */
    @ApiModelProperty("使用场所")
    private String usageArea;
    
    /**
     * 资产编号
     */
    @ApiModelProperty("资产编号")
    private String assetId;
    
    /**
     * 控制柜型号
     */
    @ApiModelProperty("控制柜型号")
    private String controlCabinetType;
    
    /**
     * 控制柜编号
     */
    @ApiModelProperty("控制柜编号")
    private String controlCabinetId;
    
    /**
     * 紧急情况联系电话
     */
    @ApiModelProperty("紧急情况联系电话")
    private String emergencyPhone;
    
    /**
     * 安全管理员
     */
    @ApiModelProperty("安全管理员")
    private String safeManager;
    
    /**
     * 电梯司机
     */
    @ApiModelProperty("电梯司机")
    private String driver;
    
    /**
     * 电梯出厂日期
     */
    @ApiModelProperty("电梯出厂日期")
    private Date productionDate;
    
    /**
     * 电梯出厂编号
     */
    @ApiModelProperty("电梯出厂编号")
    private String productionId;
    
    /**
     * 电梯是否有摄像头
     */
    @ApiModelProperty("电梯是否有摄像头")
    private Boolean withCamera;
    
    /**
     * 电梯是否有有屏设备
     */
    @ApiModelProperty("电梯是否有有屏设备")
    private Boolean withScreenedDevice;
    
    /**
     * 电梯出厂编号
     */
    @ApiModelProperty("电梯出厂编号")
    private String productId;
    
    /**
     * 所属单位id
     */
    @ApiModelProperty("所属单位id")
    private String unitId;
    
    /**
     * 维保班组id
     */
    @ApiModelProperty("维保班组id")
    private String maintainGroupId;
    
    /**
     * 维修公司id
     */
    @ApiModelProperty("维修公司id")
    private String repairCompanyId;
    
    /**
     * 维修班组id
     */
    @ApiModelProperty("维修班组id")
    private String repairGroupId;
    
    /**
     * 救援电话
     */
    @ApiModelProperty("救援电话")
    private String rescuePhone;
    
    /**
     * 救援编号
     */
    @ApiModelProperty("救援编号")
    private String rescueId;
    
    /**
     * 电梯改造公司
     */
    @ApiModelProperty("电梯改造公司")
    private String reformCompany;
    
    /**
     * 代理商
     */
    @ApiModelProperty("代理商")
    private String agent;
    
    /**
     * 电梯类型
     */
    @ApiModelProperty("电梯类型")
    private String type;
    
    /**
     * 电梯速度
     */
    @ApiModelProperty("电梯速度")
    private BigDecimal ratedSpeed;
    
    /**
     * 电梯层门数
     */
    @ApiModelProperty("电梯层门数")
    private String doorNumber;
    
    /**
     * 电梯年检日期
     */
    @ApiModelProperty("电梯年检日期")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime annualInspectionDate;
    
    /**
     * 电梯安装日期
     */
    @ApiModelProperty("电梯安装日期")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime installDate;
    
    /**
     * 电梯出厂日期
     */
    @ApiModelProperty("电梯出厂日期")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime productDate;
    
    /**
     * 电梯改造日期
     */
    @ApiModelProperty("电梯改造日期")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime reformDate;
    
    /**
     * 维保公司id
     */
    @ApiModelProperty("维保公司id")
    private String maintainCompanyId;
    
    /**
     * 维保公司名称
     */
    @ApiModelProperty("维保公司名称")
    private String maintainCompanyName;
    
    /**
     * 维保班组名称
     */
    @ApiModelProperty("维保班组名称")
    private String maintainGroupName;
    
    /**
     * 维修公司名称
     */
    @ApiModelProperty("维修公司名称")
    private String repairCompanyName;
    
    /**
     * 维修班组名称
     */
    @ApiModelProperty("维修班组名称")
    private String repairGroupName;
    

}

