package org.hqu.elevatorManage.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.hqu.elevatorManage.domain.entity.AnnualInspectionOrder;
import org.hqu.elevatorManage.domain.dto.AnnualInspectionOrderDTO;
import org.hqu.elevatorManage.domain.vo.AnnualInspectionOrderVO;

/**
 * <p>
 * 针对数据库表[annualInspectionOrder]的操作
 * </p>
 *
 * @author hqully <br>
 * @entity {@link AnnualInspectionOrder}
 * @date 2022-10-30 19:21:29 <br>
 * @version 1.0
 */
@Mapper
public interface AnnualInspectionOrderMapper {

    /**
     * <p>
     * 根据[annualInspectionOrderDTO]的参数条件查询年检工单列表
     * </p>
     *
     * @param annualInspectionOrderDTO 查询参数
     * @return {@link List<AnnualInspectionOrderDTO>} 年检工单DTO列表
     * @date 2022-10-30 19:21:29 <br>
     * @author hqully <br>
     */
    List<AnnualInspectionOrderVO> listAnnualInspectionOrders(AnnualInspectionOrderDTO annualInspectionOrderDTO);

    /**
     * <p>
     * 添加年检工单
     * </p>
     *
     * @param annualInspectionOrder 年检工单实体类
     * @return {@link int}
     * @date 2022-10-30 19:21:29 <br>
     * @author hqully <br>
     */
    int addAnnualInspectionOrder(AnnualInspectionOrder annualInspectionOrder);

    /**
     * <p>
     * 更新年检工单
     * </p>
     *
     * @param annualInspectionOrder 年检工单
     * @return {@link int}
     * @date 2022-10-30 19:21:29 <br>
     * @author hqully <br>
     */
    int updateAnnualInspectionOrder(AnnualInspectionOrder annualInspectionOrder);
    
    /**
     * <p>
     * 通过[id]删除年检工单
     * </p>
     *
     * @param id 年检工单id
     * @return {@link int}
     * @date 2022-10-30 19:21:29 <br>
     * @author hqully <br>
     */
    int deleteAnnualInspectionOrderById(@Param("id") String id);

}

