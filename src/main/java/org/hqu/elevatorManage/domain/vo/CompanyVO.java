package org.hqu.elevatorManage.domain.vo;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Length;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;

import lombok.Data;

/**
 * [Company]VO
 *
 * @author hqully
 * @date 2022-10-19 20:17:51
 */
@ApiModel(description = "公司表")
@Data
public class CompanyVO implements Serializable {

    private static final long serialVersionUID = -47334590360179781L;
    
    /**
     * 物理id
     */
    @ApiModelProperty("物理id")
    @NotNull(message = "物理id不能为空")
    private Long id;
    
    /**
     * 公司id
     */
    @ApiModelProperty("公司id")
    private String companyId;
    
    /**
     * 公司名称
     */
    @ApiModelProperty("公司名称")
    private String name;
    
    /**
     * 公司地址
     */
    @ApiModelProperty("公司地址")
    private String address;
    
    /**
     * 公司分管区域代码
     */
    @ApiModelProperty("公司分管区域代码")
    private String areaId;
    
    /**
     * 公司状态
     */
    @ApiModelProperty("公司状态")
    private Integer state;
    
    /**
     * 公司类型(1为维保公司，2为维修公司)
     */
    @ApiModelProperty("公司类型(1为维保公司，2为维修公司)")
    private Integer type;
    

}

