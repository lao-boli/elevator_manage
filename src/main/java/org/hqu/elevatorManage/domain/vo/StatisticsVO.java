package org.hqu.elevatorManage.domain.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 * 统计数据展示对象
 * <p>
 *
 * @author hqully
 * @version 1.0
 * @date 2022/10/31 20:09
 */
@Data
public class StatisticsVO  implements Serializable {

    private static final long serialVersionUID = 8540239418131414L;

    /**
     * 数据名称
     */
    @ApiModelProperty("数据名称")
    private String name;

    /**
     * 数据出现次数
     */
    @ApiModelProperty("数据出现次数")
    private Integer value;


}
