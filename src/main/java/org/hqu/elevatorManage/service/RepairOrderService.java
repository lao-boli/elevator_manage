package org.hqu.elevatorManage.service;

import com.github.pagehelper.PageInfo;
import org.hqu.elevatorManage.domain.entity.RepairOrder;
import org.hqu.elevatorManage.domain.dto.RepairOrderDTO;
import org.hqu.elevatorManage.domain.dto.PageDTO;
import org.hqu.elevatorManage.domain.vo.RepairOrderVO;

import java.util.List;

/**
 * <p>
 * 针对数据库表[repairOrderDTO]的操作Service
 * </p>
 *
 * @entity {@link RepairOrderDTO}
 * @date 2022-10-27 20:50:46 <br>
 * @author hqully <br>
 * @version 1.0
 */

public interface RepairOrderService {

     /**
      * <p>
      *     根据[repairOrderDTO]的参数分页条件查询维修订单列表
      * </p>
      * @param page    分页参数
      * @param repairOrderDTO 查询对象条件参数
      * @return {@link PageInfo<RepairOrderVO>} 维修订单VO分页列表
      * @date 2022-10-27 20:50:46 <br>
      * @author hqully <br>
      */
     PageInfo<RepairOrderVO> pageRepairOrders(PageDTO page, RepairOrderDTO repairOrderDTO);

     /**
      * <p>
      *     根据[repairOrderDTO]的参数条件查询维修订单
      * </p>
      * @param repairOrderDTO 查询对象
      * @return {@link List<RepairOrderVO>} 维修订单VO列表
      * @date 2022-10-27 20:50:46 <br>
      * @author hqully <br>
      */
     List<RepairOrderVO> listRepairOrders(RepairOrderDTO repairOrderDTO);


     /**
      * <p>
      *     添加维修订单
      * </p>
      * @param repairOrderDTO 维修订单DTO
      * @return {@link int}
      * @date 2022-10-27 20:50:46 <br>
      * @author hqully <br>
      */
     int addRepairOrder(RepairOrderDTO repairOrderDTO);

     /**
      * <p>
      *     更新维修订单
      * </p>
      * @param repairOrderDTO 维修订单DTO
      * @return {@link int}
      * @date 2022-10-27 20:50:46 <br>
      * @author hqully <br>
      */
     int updateRepairOrder(RepairOrderDTO repairOrderDTO);

     /**
      * <p>
      *     通过[id]删除维修订单
      * </p>
      * @param id 维修订单id
      * @return {@link int}
      * @date 2022-10-27 20:50:46 <br>
      * @author hqully <br>
      */
     int deleteRepairOrderById(String id);

}
