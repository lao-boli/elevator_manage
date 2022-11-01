package org.hqu.elevatorManage.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.hqu.elevatorManage.domain.entity.TrapOrder;
import org.hqu.elevatorManage.domain.dto.TrapOrderDTO;
import org.hqu.elevatorManage.domain.vo.TrapOrderVO;

/**
 * <p>
 * 针对数据库表[trapOrder]的操作
 * </p>
 *
 * @author hqully <br>
 * @entity {@link TrapOrder}
 * @date 2022-10-27 21:21:33 <br>
 * @version 1.0
 */
@Mapper
public interface TrapOrderMapper {

    /**
     * <p>
     * 根据[trapOrderDTO]的参数条件查询困人工单列表
     * </p>
     *
     * @param trapOrderDTO 查询参数
     * @return {@link List<TrapOrderDTO>} 困人工单DTO列表
     * @date 2022-10-27 21:21:33 <br>
     * @author hqully <br>
     */
    List<TrapOrderVO> listTrapOrders(TrapOrderDTO trapOrderDTO);

    /**
     * <p>
     * 添加困人工单
     * </p>
     *
     * @param trapOrder 困人工单实体类
     * @return {@link int}
     * @date 2022-10-27 21:21:33 <br>
     * @author hqully <br>
     */
    int addTrapOrder(TrapOrder trapOrder);

    /**
     * <p>
     * 更新困人工单
     * </p>
     *
     * @param trapOrder 困人工单
     * @return {@link int}
     * @date 2022-10-27 21:21:33 <br>
     * @author hqully <br>
     */
    int updateTrapOrder(TrapOrder trapOrder);
    
    /**
     * <p>
     * 通过[id]删除困人工单
     * </p>
     *
     * @param id 困人工单id
     * @return {@link int}
     * @date 2022-10-27 21:21:33 <br>
     * @author hqully <br>
     */
    int deleteTrapOrderById(@Param("id") String id);

}

