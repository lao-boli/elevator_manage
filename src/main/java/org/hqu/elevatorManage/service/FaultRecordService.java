package org.hqu.elevatorManage.service;

import com.github.pagehelper.PageInfo;
import org.hqu.elevatorManage.domain.entity.FaultRecord;
import org.hqu.elevatorManage.domain.dto.FaultRecordDTO;
import org.hqu.elevatorManage.domain.vo.FaultRecordVO;
import org.hqu.elevatorManage.domain.dto.PageDTO;
import org.hqu.elevatorManage.domain.vo.StatisticsVO;

import java.util.List;

/**
 * <p>
 * 针对数据库表[faultRecordDTO]的操作Service
 * </p>
 *
 * @entity {@link FaultRecordDTO}
 * @date 2022-10-28 09:45:59 <br>
 * @author hqully <br>
 * @version 1.0
 */

public interface FaultRecordService {

     /**
      * <p>
      *     获取故障类型占比统计数据
      * </p>
      * @param unitId 电梯所属单位
      * @param maintainCompanyId 电梯所属维保公司
      * @return {@link List<StatisticsVO>}
      * @date 2022-10-31 20:24:34 <br>
      * @author hqully <br>
      */
     List<StatisticsVO> getTypeStatistics(String unitId, String maintainCompanyId);

     /**
      * <p>
      *     根据[faultRecordDTO]的参数分页条件查询电梯故障记录列表
      * </p>
      * @param page    分页参数
      * @param faultRecordDTO 查询对象条件参数
      * @return {@link PageInfo<FaultRecordVO>} 电梯故障记录VO分页列表
      * @date 2022-10-28 09:45:59 <br>
      * @author hqully <br>
      */
     PageInfo<FaultRecordVO> pageFaultRecords(PageDTO page, FaultRecordDTO faultRecordDTO);

     /**
      * <p>
      *     根据[faultRecordDTO]的参数条件查询电梯故障记录
      * </p>
      * @param faultRecordDTO 查询对象
      * @return {@link List<FaultRecordVO>} 电梯故障记录VO列表
      * @date 2022-10-28 09:45:59 <br>
      * @author hqully <br>
      */
     List<FaultRecordVO> listFaultRecords(FaultRecordDTO faultRecordDTO);


     /**
      * <p>
      *     添加电梯故障记录
      * </p>
      * @param faultRecordDTO 电梯故障记录DTO
      * @return {@link int}
      * @date 2022-10-28 09:45:59 <br>
      * @author hqully <br>
      */
     int addFaultRecord(FaultRecordDTO faultRecordDTO);

     /**
      * <p>
      *     更新电梯故障记录
      * </p>
      * @param faultRecordDTO 电梯故障记录DTO
      * @return {@link int}
      * @date 2022-10-28 09:45:59 <br>
      * @author hqully <br>
      */
     int updateFaultRecord(FaultRecordDTO faultRecordDTO);

     /**
      * <p>
      *     通过[id]删除电梯故障记录
      * </p>
      * @param id 电梯故障记录id
      * @return {@link int}
      * @date 2022-10-28 09:45:59 <br>
      * @author hqully <br>
      */
     int deleteFaultRecordById(String id);

}
