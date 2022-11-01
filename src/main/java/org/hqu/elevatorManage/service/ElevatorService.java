package org.hqu.elevatorManage.service;

import com.github.pagehelper.PageInfo;
import org.hqu.elevatorManage.domain.entity.Elevator;
import org.hqu.elevatorManage.domain.dto.ElevatorDTO;
import org.hqu.elevatorManage.domain.vo.ElevatorVO;
import org.hqu.elevatorManage.domain.dto.PageDTO;
import org.hqu.elevatorManage.domain.vo.StatisticsVO;

import java.util.List;

/**
 * <p>
 * 针对数据库表[elevatorDTO]的操作Service
 * </p>
 *
 * @entity {@link ElevatorDTO}
 * @date 2022-10-30 20:36:45 <br>
 * @author hqully <br>
 * @version 1.0
 */

public interface ElevatorService {

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
     List<StatisticsVO> getBrandStatistics(String unitId, String maintainCompanyId);

     /**
      * <p>
      *     根据[elevatorDTO]的参数分页条件查询电梯列表
      * </p>
      * @param page    分页参数
      * @param elevatorDTO 查询对象条件参数
      * @return {@link PageInfo<ElevatorVO>} 电梯VO分页列表
      * @date 2022-10-30 20:36:45 <br>
      * @author hqully <br>
      */
     PageInfo<ElevatorVO> pageElevators(PageDTO page, ElevatorDTO elevatorDTO);

     /**
      * <p>
      *     根据[elevatorDTO]的参数条件查询电梯
      * </p>
      * @param elevatorDTO 查询对象
      * @return {@link List<ElevatorVO>} 电梯VO列表
      * @date 2022-10-30 20:36:45 <br>
      * @author hqully <br>
      */
     List<ElevatorVO> listElevators(ElevatorDTO elevatorDTO);


     /**
      * <p>
      *     添加电梯
      * </p>
      * @param elevatorDTO 电梯DTO
      * @return {@link int}
      * @date 2022-10-30 20:36:45 <br>
      * @author hqully <br>
      */
     int addElevator(ElevatorDTO elevatorDTO);

     /**
      * <p>
      *     更新电梯
      * </p>
      * @param elevatorDTO 电梯DTO
      * @return {@link int}
      * @date 2022-10-30 20:36:45 <br>
      * @author hqully <br>
      */
     int updateElevator(ElevatorDTO elevatorDTO);

     /**
      * <p>
      *     通过[id]删除电梯
      * </p>
      * @param id 电梯id
      * @return {@link int}
      * @date 2022-10-30 20:36:45 <br>
      * @author hqully <br>
      */
     int deleteElevatorById(String id);

}
