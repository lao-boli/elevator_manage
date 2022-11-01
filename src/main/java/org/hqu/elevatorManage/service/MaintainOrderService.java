package org.hqu.elevatorManage.service;

import com.github.pagehelper.PageInfo;
import org.hqu.elevatorManage.domain.entity.MaintainOrder;
import org.hqu.elevatorManage.domain.dto.MaintainOrderDTO;
import org.hqu.elevatorManage.domain.dto.PageDTO;
import org.hqu.elevatorManage.domain.vo.MaintainOrderVO;

import java.util.List;

/**
 * <p>
 * 针对数据库表[maintainOrderDTO]的操作Service
 * </p>
 *
 * @entity {@link MaintainOrderDTO}
 * @date 2022-10-27 19:35:31 <br>
 * @author hqully <br>
 * @version 1.0
 */

public interface MaintainOrderService {

     /**
      * <p>
      *     根据[maintainOrderDTO]的参数分页条件查询维保订单列表
      * </p>
      * @param page    分页参数
      * @param maintainOrderDTO 查询对象条件参数
      * @return {@link PageInfo<MaintainOrderVO>} 维保订单VO分页列表
      * @date 2022-10-27 19:35:31 <br>
      * @author hqully <br>
      */
     PageInfo<MaintainOrderVO> pageMaintainOrders(PageDTO page, MaintainOrderDTO maintainOrderDTO);

     /**
      * <p>
      *     根据[maintainOrderDTO]的参数条件查询维保订单
      * </p>
      * @param maintainOrderDTO 查询对象
      * @return {@link List<MaintainOrderVO>} 维保订单VO列表
      * @date 2022-10-27 19:35:31 <br>
      * @author hqully <br>
      */
     List<MaintainOrderVO> listMaintainOrders(MaintainOrderDTO maintainOrderDTO);


     /**
      * <p>
      *     添加维保订单
      * </p>
      * @param maintainOrderDTO 维保订单DTO
      * @return {@link int}
      * @date 2022-10-27 19:35:31 <br>
      * @author hqully <br>
      */
     int addMaintainOrder(MaintainOrderDTO maintainOrderDTO);

     /**
      * <p>
      *     更新维保订单
      * </p>
      * @param maintainOrderDTO 维保订单DTO
      * @return {@link int}
      * @date 2022-10-27 19:35:31 <br>
      * @author hqully <br>
      */
     int updateMaintainOrder(MaintainOrderDTO maintainOrderDTO);

     /**
      * <p>
      *     通过[id]删除维保订单
      * </p>
      * @param id 维保订单id
      * @return {@link int}
      * @date 2022-10-27 19:35:31 <br>
      * @author hqully <br>
      */
     int deleteMaintainOrderById(String id);

}
