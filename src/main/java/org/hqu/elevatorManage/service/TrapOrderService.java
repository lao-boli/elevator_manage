package org.hqu.elevatorManage.service;

import com.github.pagehelper.PageInfo;
import org.hqu.elevatorManage.domain.entity.TrapOrder;
import org.hqu.elevatorManage.domain.dto.TrapOrderDTO;
import org.hqu.elevatorManage.domain.dto.PageDTO;
import org.hqu.elevatorManage.domain.vo.TrapOrderVO;

import java.util.List;

/**
 * <p>
 * 针对数据库表[trapOrderDTO]的操作Service
 * </p>
 *
 * @entity {@link TrapOrderDTO}
 * @date 2022-10-27 21:21:33 <br>
 * @author hqully <br>
 * @version 1.0
 */

public interface TrapOrderService {

     /**
      * <p>
      *     根据[trapOrderDTO]的参数分页条件查询困人工单列表
      * </p>
      * @param page    分页参数
      * @param trapOrderDTO 查询对象条件参数
      * @return {@link PageInfo<TrapOrderVO>} 困人工单VO分页列表
      * @date 2022-10-27 21:21:33 <br>
      * @author hqully <br>
      */
     PageInfo<TrapOrderVO> pageTrapOrders(PageDTO page, TrapOrderDTO trapOrderDTO);

     /**
      * <p>
      *     根据[trapOrderDTO]的参数条件查询困人工单
      * </p>
      * @param trapOrderDTO 查询对象
      * @return {@link List<TrapOrderVO>} 困人工单VO列表
      * @date 2022-10-27 21:21:33 <br>
      * @author hqully <br>
      */
     List<TrapOrderVO> listTrapOrders(TrapOrderDTO trapOrderDTO);


     /**
      * <p>
      *     添加困人工单
      * </p>
      * @param trapOrderDTO 困人工单DTO
      * @return {@link int}
      * @date 2022-10-27 21:21:33 <br>
      * @author hqully <br>
      */
     int addTrapOrder(TrapOrderDTO trapOrderDTO);

     /**
      * <p>
      *     更新困人工单
      * </p>
      * @param trapOrderDTO 困人工单DTO
      * @return {@link int}
      * @date 2022-10-27 21:21:33 <br>
      * @author hqully <br>
      */
     int updateTrapOrder(TrapOrderDTO trapOrderDTO);

     /**
      * <p>
      *     通过[id]删除困人工单
      * </p>
      * @param id 困人工单id
      * @return {@link int}
      * @date 2022-10-27 21:21:33 <br>
      * @author hqully <br>
      */
     int deleteTrapOrderById(String id);

}
