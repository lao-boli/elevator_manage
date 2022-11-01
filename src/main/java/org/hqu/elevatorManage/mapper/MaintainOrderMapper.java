package org.hqu.elevatorManage.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.hqu.elevatorManage.domain.entity.MaintainOrder;
import org.hqu.elevatorManage.domain.dto.MaintainOrderDTO;
import org.hqu.elevatorManage.domain.vo.MaintainOrderVO;

/**
 * <p>
 * 针对数据库表[maintainOrder]的操作
 * </p>
 *
 * @author hqully <br>
 * @entity {@link MaintainOrder}
 * @date 2022-10-27 19:35:31 <br>
 * @version 1.0
 */
@Mapper
public interface MaintainOrderMapper {

    /**
     * <p>
     * 根据[maintainOrderDTO]的参数条件查询维保订单列表
     * </p>
     *
     * @param maintainOrderDTO 查询参数
     * @return {@link List<MaintainOrderDTO>} 维保订单DTO列表
     * @date 2022-10-27 19:35:31 <br>
     * @author hqully <br>
     */
    List<MaintainOrderVO> listMaintainOrders(MaintainOrderDTO maintainOrderDTO);

    /**
     * <p>
     * 添加维保订单
     * </p>
     *
     * @param maintainOrder 维保订单实体类
     * @return {@link int}
     * @date 2022-10-27 19:35:31 <br>
     * @author hqully <br>
     */
    int addMaintainOrder(MaintainOrder maintainOrder);

    /**
     * <p>
     * 更新维保订单
     * </p>
     *
     * @param maintainOrder 维保订单
     * @return {@link int}
     * @date 2022-10-27 19:35:31 <br>
     * @author hqully <br>
     */
    int updateMaintainOrder(MaintainOrder maintainOrder);
    
    /**
     * <p>
     * 通过[id]删除维保订单
     * </p>
     *
     * @param id 维保订单id
     * @return {@link int}
     * @date 2022-10-27 19:35:31 <br>
     * @author hqully <br>
     */
    int deleteMaintainOrderById(@Param("id") String id);

}

