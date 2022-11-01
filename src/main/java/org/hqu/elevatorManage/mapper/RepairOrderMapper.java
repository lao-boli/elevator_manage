package org.hqu.elevatorManage.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.hqu.elevatorManage.domain.entity.RepairOrder;
import org.hqu.elevatorManage.domain.dto.RepairOrderDTO;
import org.hqu.elevatorManage.domain.vo.RepairOrderVO;

/**
 * <p>
 * 针对数据库表[repairOrder]的操作
 * </p>
 *
 * @author hqully <br>
 * @entity {@link RepairOrder}
 * @date 2022-10-27 20:50:46 <br>
 * @version 1.0
 */
@Mapper
public interface RepairOrderMapper {

    /**
     * <p>
     * 根据[repairOrderDTO]的参数条件查询维修订单列表
     * </p>
     *
     * @param repairOrderDTO 查询参数
     * @return {@link List<RepairOrderDTO>} 维修订单DTO列表
     * @date 2022-10-27 20:50:46 <br>
     * @author hqully <br>
     */
    List<RepairOrderVO> listRepairOrders(RepairOrderDTO repairOrderDTO);

    /**
     * <p>
     * 添加维修订单
     * </p>
     *
     * @param repairOrder 维修订单实体类
     * @return {@link int}
     * @date 2022-10-27 20:50:46 <br>
     * @author hqully <br>
     */
    int addRepairOrder(RepairOrder repairOrder);

    /**
     * <p>
     * 更新维修订单
     * </p>
     *
     * @param repairOrder 维修订单
     * @return {@link int}
     * @date 2022-10-27 20:50:46 <br>
     * @author hqully <br>
     */
    int updateRepairOrder(RepairOrder repairOrder);
    
    /**
     * <p>
     * 通过[id]删除维修订单
     * </p>
     *
     * @param id 维修订单id
     * @return {@link int}
     * @date 2022-10-27 20:50:46 <br>
     * @author hqully <br>
     */
    int deleteRepairOrderById(@Param("id") String id);

}

