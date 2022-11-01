package org.hqu.elevatorManage.domain.entity;

import java.math.BigDecimal;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

import lombok.Data;

/**
 * [Park]实体类
 *
 * @author liulingyu
 * @since 2022-10-06 10:05:05
 */
@ApiModel(description = "设备部署园区表")
@Data
public class Park implements Serializable {

    private static final long serialVersionUID = 759236288010976019L;
    
    /**
     * 
     */
    @ApiModelProperty("")
    @NotNull(message = "不能为空")
    private Long id;
    
    /**
     * 园区名称
     */
    @ApiModelProperty("园区名称")
    private String name;
    
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
    private String zone;
    
    /**
     * 街道
     */
    @ApiModelProperty("街道")
    private String street;
    
    /**
     * 园区地址
     */
    @ApiModelProperty("园区地址")
    private String address;
    
    /**
     * 园区所在地纬度
     */
    @ApiModelProperty("园区所在地纬度")
    private BigDecimal lat;
    
    /**
     * 园区所在地经度
     */
    @ApiModelProperty("园区所在地经度")
    private BigDecimal lng;
    
    /**
     * 所属行政区划id
     */
    @ApiModelProperty("所属行政区划id")
    private String areaId;
    

}

