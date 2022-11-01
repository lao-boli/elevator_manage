package org.hqu.elevatorManage.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.hqu.elevatorManage.domain.entity.FaultRecord;
import org.hqu.elevatorManage.domain.dto.FaultRecordDTO;
import org.hqu.elevatorManage.domain.vo.FaultRecordVO;
import org.hqu.elevatorManage.domain.vo.StatisticsVO;

/**
 * <p>
 * 针对数据库表[faultRecord]的操作
 * </p>
 *
 * @author hqully <br>
 * @entity {@link FaultRecord}
 * @date 2022-10-28 09:45:59 <br>
 * @version 1.0
 */
@Mapper
public interface FaultRecordMapper {


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
    List<StatisticsVO> getTypeStatistics(@Param("unitId") String unitId, @Param("maintainCompanyId") String maintainCompanyId);

    /**
     * <p>
     * 根据[faultRecordDTO]的参数条件查询电梯故障记录列表
     * </p>
     *
     * @param faultRecordDTO 查询参数
     * @return {@link List<FaultRecordDTO>} 电梯故障记录DTO列表
     * @date 2022-10-28 09:45:59 <br>
     * @author hqully <br>
     */
    List<FaultRecordVO> listFaultRecords(FaultRecordDTO faultRecordDTO);

    /**
     * <p>
     * 添加电梯故障记录
     * </p>
     *
     * @param faultRecord 电梯故障记录实体类
     * @return {@link int}
     * @date 2022-10-28 09:45:59 <br>
     * @author hqully <br>
     */
    int addFaultRecord(FaultRecord faultRecord);

    /**
     * <p>
     * 更新电梯故障记录
     * </p>
     *
     * @param faultRecord 电梯故障记录
     * @return {@link int}
     * @date 2022-10-28 09:45:59 <br>
     * @author hqully <br>
     */
    int updateFaultRecord(FaultRecord faultRecord);
    
    /**
     * <p>
     * 通过[id]删除电梯故障记录
     * </p>
     *
     * @param id 电梯故障记录id
     * @return {@link int}
     * @date 2022-10-28 09:45:59 <br>
     * @author hqully <br>
     */
    int deleteFaultRecordById(@Param("id") String id);

}

