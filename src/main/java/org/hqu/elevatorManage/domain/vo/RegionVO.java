package org.hqu.elevatorManage.domain.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * [Region]VO
 *
 * @author hqully
 * @date 2022-11-02 21:42:03
 */
@ApiModel(description = "行政区域表")
@Data
public class RegionVO implements Serializable {

    private static final long serialVersionUID = 146428474348571315L;
    
    /**
     * 物理id
     */
    @ApiModelProperty("物理id")
    @NotNull(message = "物理id不能为空")
    private Long id;
    
    /**
     * 所属行政区划id
     */
    @ApiModelProperty("所属行政区划id")
    @NotBlank(message = "所属行政区划id不能为空")
    @Length(max = 255, message = "所属行政区划id长度不能超过255")
    private String regionId;
    
    /**
     * 省行政区划编号
     */
    @ApiModelProperty("省行政区划编号")
    private String provinceId;
    
    /**
     * 省名称
     */
    @ApiModelProperty("省名称")
    private String provinceName;
    
    /**
     * 市行政区划编号
     */
    @ApiModelProperty("市行政区划编号")
    private String cityId;
    
    /**
     * 市名称
     */
    @ApiModelProperty("市名称")
    private String cityName;
    
    /**
     * 区/县行政区划编号
     */
    @ApiModelProperty("区/县行政区划编号")
    private String districtId;
    
    /**
     * 区/县名称
     */
    @ApiModelProperty("区/县名称")
    private String districtName;
    
    /**
     * 乡/镇/街道行政区划编号
     */
    @ApiModelProperty("乡/镇/街道行政区划编号")
    private String townId;
    
    /**
     * 乡/镇/街道名称
     */
    @ApiModelProperty("乡/镇/街道名称")
    private String townName;
    

}

