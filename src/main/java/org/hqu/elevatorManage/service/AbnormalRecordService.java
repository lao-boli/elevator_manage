package org.hqu.elevatorManage.service;

import com.github.pagehelper.PageInfo;
import org.hqu.elevatorManage.domain.entity.AbnormalRecord;
import org.hqu.elevatorManage.domain.dto.AbnormalRecordDTO;
import org.hqu.elevatorManage.domain.vo.AbnormalRecordVO;
import org.hqu.elevatorManage.domain.dto.PageDTO;
import org.hqu.elevatorManage.domain.vo.StatisticsVO;

import java.util.List;

/**
 * <p>
 * 针对数据库表[abnormalRecordDTO]的操作Service
 * </p>
 *
 * @entity {@link AbnormalRecordDTO}
 * @date 2022-10-28 09:45:59 <br>
 * @author hqully <br>
 * @version 1.0
 */

public interface AbnormalRecordService {


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
      *     根据[abnormalRecordDTO]的参数分页条件查询电梯异常记录列表
      * </p>
      * @param page    分页参数
      * @param abnormalRecordDTO 查询对象条件参数
      * @return {@link PageInfo<AbnormalRecordVO>} 电梯异常记录VO分页列表
      * @date 2022-10-28 09:45:59 <br>
      * @author hqully <br>
      */
     PageInfo<AbnormalRecordVO> pageAbnormalRecords(PageDTO page, AbnormalRecordDTO abnormalRecordDTO);

     /**
      * <p>
      *     根据[abnormalRecordDTO]的参数条件查询电梯异常记录
      * </p>
      * @param abnormalRecordDTO 查询对象
      * @return {@link List<AbnormalRecordVO>} 电梯异常记录VO列表
      * @date 2022-10-28 09:45:59 <br>
      * @author hqully <br>
      */
     List<AbnormalRecordVO> listAbnormalRecords(AbnormalRecordDTO abnormalRecordDTO);


     /**
      * <p>
      *     添加电梯异常记录
      * </p>
      * @param abnormalRecordDTO 电梯异常记录DTO
      * @return {@link int}
      * @date 2022-10-28 09:45:59 <br>
      * @author hqully <br>
      */
     int addAbnormalRecord(AbnormalRecordDTO abnormalRecordDTO);

     /**
      * <p>
      *     更新电梯异常记录
      * </p>
      * @param abnormalRecordDTO 电梯异常记录DTO
      * @return {@link int}
      * @date 2022-10-28 09:45:59 <br>
      * @author hqully <br>
      */
     int updateAbnormalRecord(AbnormalRecordDTO abnormalRecordDTO);

     /**
      * <p>
      *     通过[id]删除电梯异常记录
      * </p>
      * @param id 电梯异常记录id
      * @return {@link int}
      * @date 2022-10-28 09:45:59 <br>
      * @author hqully <br>
      */
     int deleteAbnormalRecordById(String id);

}
