package org.hqu.elevatorManage.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.hqu.elevatorManage.domain.entity.AbnormalRecord;
import org.hqu.elevatorManage.domain.dto.AbnormalRecordDTO;
import org.hqu.elevatorManage.domain.vo.AbnormalRecordVO;
import org.hqu.elevatorManage.domain.vo.StatisticsVO;

/**
 * <p>
 * 针对数据库表[abnormalRecord]的操作
 * </p>
 *
 * @author hqully <br>
 * @entity {@link AbnormalRecord}
 * @date 2022-10-28 09:45:59 <br>
 * @version 1.0
 */
@Mapper
public interface AbnormalRecordMapper {


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
     * 根据[abnormalRecordDTO]的参数条件查询电梯异常记录列表
     * </p>
     *
     * @param abnormalRecordDTO 查询参数
     * @return {@link List<AbnormalRecordDTO>} 电梯异常记录DTO列表
     * @date 2022-10-28 09:45:59 <br>
     * @author hqully <br>
     */
    List<AbnormalRecordVO> listAbnormalRecords(AbnormalRecordDTO abnormalRecordDTO);

    /**
     * <p>
     * 添加电梯异常记录
     * </p>
     *
     * @param abnormalRecord 电梯异常记录实体类
     * @return {@link int}
     * @date 2022-10-28 09:45:59 <br>
     * @author hqully <br>
     */
    int addAbnormalRecord(AbnormalRecord abnormalRecord);

    /**
     * <p>
     * 更新电梯异常记录
     * </p>
     *
     * @param abnormalRecord 电梯异常记录
     * @return {@link int}
     * @date 2022-10-28 09:45:59 <br>
     * @author hqully <br>
     */
    int updateAbnormalRecord(AbnormalRecord abnormalRecord);
    
    /**
     * <p>
     * 通过[id]删除电梯异常记录
     * </p>
     *
     * @param id 电梯异常记录id
     * @return {@link int}
     * @date 2022-10-28 09:45:59 <br>
     * @author hqully <br>
     */
    int deleteAbnormalRecordById(@Param("id") String id);

}

