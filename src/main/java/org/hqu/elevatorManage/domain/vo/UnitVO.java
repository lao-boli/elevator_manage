package org.hqu.elevatorManage.domain.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * [Unit]VO
 *
 * @author hqully
 * @date 2022-10-18 08:52:48
 */
@ApiModel(description = "设备部署园区表")
@Data
public class UnitVO implements Serializable {

    private static final long serialVersionUID = 653780224755394070L;
    
    /**
     * 物理id
     */
    @ApiModelProperty("物理id")
    @NotNull(message = "物理id不能为空")
    private Long id;
    
    /**
     * 单位id
     */
    @ApiModelProperty("单位id")
    private String unitId;
    
    /**
     * 单位名称
     */
    @ApiModelProperty("单位名称")
    private String name;
    
    /**
     * 所属行政区划id
     */
    @ApiModelProperty("所属行政区划id")
    private String regionId;
    
    /**
     * 省
     */
    @ApiModelProperty("省")
    private String province;
    
    /**
     * 市
     */
    @ApiModelProperty("市")
    private String city;
    
    /**
     * 区
     */
    @ApiModelProperty("区")
    private String district;
    
    /**
     * 街道
     */
    @ApiModelProperty("街道")
    private String street;
    
    /**
     * 单位地址
     */
    @ApiModelProperty("单位地址")
    private String address;
    
    /**
     * 单位所在地纬度
     */
    @ApiModelProperty("单位所在地纬度")
    private BigDecimal lat;
    
    /**
     * 单位所在地经度
     */
    @ApiModelProperty("单位所在地经度")
    private BigDecimal lng;
    

}

