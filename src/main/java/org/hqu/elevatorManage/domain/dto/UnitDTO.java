package org.hqu.elevatorManage.domain.dto;

import java.math.BigDecimal;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Length;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;

import lombok.Data;

/**
 * [Unit]DTO
 *
 * @author hqully
 * @date 2022-10-18 08:52:48
 */
@ApiModel(description = "设备部署园区表")
@Data
public class UnitDTO implements Serializable {

    private static final long serialVersionUID = -51697736565358047L;
    
    /**
     * 物理id
     */
    @ApiModelProperty("物理id")
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
    private String areaId;
    
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

