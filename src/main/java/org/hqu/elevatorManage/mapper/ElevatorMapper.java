package org.hqu.elevatorManage.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.hqu.elevatorManage.domain.entity.Elevator;
import org.hqu.elevatorManage.domain.dto.ElevatorDTO;
import org.hqu.elevatorManage.domain.vo.ElevatorVO;
import org.hqu.elevatorManage.domain.vo.StatisticsVO;

/**
 * <p>
 * 针对数据库表[elevator]的操作
 * </p>
 *
 * @author hqully <br>
 * @entity {@link Elevator}
 * @date 2022-10-30 20:36:45 <br>
 * @version 1.0
 */
@Mapper
public interface ElevatorMapper {

    /**
     * <p>
     *     获取电梯品牌的占比统计数据
     * </p>
     * @param unitId 电梯所属单位
     * @param maintainCompanyId 电梯所属维保公司
     * @return {@link List<StatisticsVO>}
     * @date 2022-10-31 20:24:34 <br>
     * @author hqully <br>
     */
    List<StatisticsVO> getBrandStatistics(@Param("unitId") String unitId, @Param("maintainCompanyId") String maintainCompanyId);

    ElevatorVO getElevatorByElevatorId(@Param("elevatorId") String elevatorId);
    /**
     * <p>
     * 根据[elevatorDTO]的参数条件查询电梯列表
     * </p>
     *
     * @param elevatorDTO 查询参数
     * @return {@link List<ElevatorDTO>} 电梯DTO列表
     * @date 2022-10-30 20:36:45 <br>
     * @author hqully <br>
     */
    List<ElevatorVO> listElevators(ElevatorDTO elevatorDTO);

    /**
     * <p>
     * 添加电梯
     * </p>
     *
     * @param elevator 电梯实体类
     * @return {@link int}
     * @date 2022-10-30 20:36:45 <br>
     * @author hqully <br>
     */
    int addElevator(Elevator elevator);

    /**
     * <p>
     * 更新电梯
     * </p>
     *
     * @param elevator 电梯
     * @return {@link int}
     * @date 2022-10-30 20:36:45 <br>
     * @author hqully <br>
     */
    int updateElevator(Elevator elevator);
    
    /**
     * <p>
     * 通过[id]删除电梯
     * </p>
     *
     * @param id 电梯id
     * @return {@link int}
     * @date 2022-10-30 20:36:45 <br>
     * @author hqully <br>
     */
    int deleteElevatorById(@Param("id") String id);

}

