package org.hqu.elevatorManage.domain.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * [Company]实体类
 *
 * @author hqully
 * @date 2022-11-02 15:52:59
 */
@ApiModel(description = "公司表")
@Data
public class Company implements Serializable {

    private static final long serialVersionUID = 459356957026191630L;
    
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
    private String regionId;
    
    /**
     * 公司状态
     */
    @ApiModelProperty("公司状态")
    private Integer state;
    
    /**
     * 公司类型(维保公司/维修公司)
     */
    @ApiModelProperty("公司类型(维保公司/维修公司)")
    private String type;
    
    /**
     * 邮政编码
     */
    @ApiModelProperty("邮政编码")
    private String postalCode;
    
    /**
     * 联系方式
     */
    @ApiModelProperty("联系方式")
    private String contactInfo;
    
    /**
     * 负责人
     */
    @ApiModelProperty("负责人")
    private String manager;



}

