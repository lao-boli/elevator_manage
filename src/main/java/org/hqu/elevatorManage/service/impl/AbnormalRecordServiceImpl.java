package org.hqu.elevatorManage.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.hqu.elevatorManage.common.enums.ResultEnum;
import org.hqu.elevatorManage.common.exception.DAOException;
import org.hqu.elevatorManage.common.exception.ResultException;
import org.hqu.elevatorManage.domain.entity.AbnormalRecord;
import org.hqu.elevatorManage.domain.dto.AbnormalRecordDTO;
import org.hqu.elevatorManage.domain.vo.AbnormalRecordVO;
import org.hqu.elevatorManage.domain.dto.PageDTO;
import org.hqu.elevatorManage.domain.vo.StatisticsVO;
import org.hqu.elevatorManage.service.AbnormalRecordService;
import org.hqu.elevatorManage.mapper.AbnormalRecordMapper;
import org.hqu.elevatorManage.service.impl.constant.MapperConst;
import lombok.extern.slf4j.Slf4j;

import org.hqu.elevatorManage.utils.DAOUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 针对数据库表[abnormalRecord]的操作Service
 * </p>
 *
 * @entity {@link AbnormalRecord}
 * @date 2022-10-28 09:45:59 <br>
 * @author hqully <br>
 * @version 1.0
 */
@Slf4j
@Service
public class AbnormalRecordServiceImpl implements AbnormalRecordService {

    @Resource
    private AbnormalRecordMapper abnormalRecordMapper;


    @Override
    public List<StatisticsVO> getTypeStatistics(String unitId, String maintainCompanyId) {
        try {
            return abnormalRecordMapper.getTypeStatistics(unitId, maintainCompanyId);
        } catch (Exception e) {
            log.error("LIST [abnormal Type] FAIL\nINPUT PARAMS: {},{}\nREASON: {}", unitId,maintainCompanyId, e.toString());
            throw new ResultException(ResultEnum.ERROR, "获取异常类型的统计数据失败");
        }
    }

    @Override
    public PageInfo<AbnormalRecordVO> pageAbnormalRecords(PageDTO page, AbnormalRecordDTO abnormalRecordDTO) {
        try {
            PageHelper.startPage(page);
            List<AbnormalRecordVO> abnormalRecordList = abnormalRecordMapper.listAbnormalRecords(abnormalRecordDTO);
            return new PageInfo<>(abnormalRecordList);
        } catch (Exception e) {
            log.error("PAGE [abnormalRecord] FAIL\nINPUT OBJECT: {}\nREASON: {}", abnormalRecordDTO, e.toString());
            throw new ResultException(ResultEnum.ERROR, "查询电梯异常记录分页列表失败");
        }
    }

    @Override
    public List<AbnormalRecordVO> listAbnormalRecords(AbnormalRecordDTO abnormalRecordDTO) {
        try {
            return abnormalRecordMapper.listAbnormalRecords(abnormalRecordDTO);
        } catch (Exception e) {
            log.error("LIST [abnormalRecord] FAIL\nINPUT OBJECT: {}\nREASON: {}", abnormalRecordDTO, e.toString());
            throw new ResultException(ResultEnum.ERROR, "查询电梯异常记录列表失败");
        }
    }

    @Override
    public int addAbnormalRecord(AbnormalRecordDTO abnormalRecordDTO) {
        AbnormalRecord abnormalRecord = new AbnormalRecord();
        BeanUtils.copyProperties(abnormalRecordDTO, abnormalRecord);

        abnormalRecord.setRecordId(DAOUtil.generatePrimaryKey("A"));
        int status;
        try {
            status = abnormalRecordMapper.addAbnormalRecord(abnormalRecord);
        } catch (DuplicateKeyException e) {
            log.warn("ADD [abnormalRecord] FAIL\nINPUT OBJECT: {}\nREASON: {}", abnormalRecordDTO, e.toString());
            throw new ResultException(ResultEnum.DUPLICATE_KEY_CONFLICT, "添加电梯异常记录失败\n原因: 电梯异常记录id已存在");
        } catch (Exception e) {
            log.error("ADD [abnormalRecord] FAIL\nINPUT OBJECT: {}\nREASON: {}", abnormalRecordDTO, e.toString());
            throw new ResultException(ResultEnum.ERROR, "添加电梯异常记录失败");
        }
        return status;
    }

    @Override
    public int updateAbnormalRecord(AbnormalRecordDTO abnormalRecordDTO) {
        AbnormalRecord abnormalRecord = new AbnormalRecord();
        BeanUtils.copyProperties(abnormalRecordDTO, abnormalRecord);

        int status;
        try {
            status = abnormalRecordMapper.updateAbnormalRecord(abnormalRecord);
            if (status == MapperConst.OBJECT_NULL) {
                throw new DAOException("this [abnormalRecord] record not exist");
            }
        }catch (DAOException e){
            log.warn("UPDATE [abnormalRecord] FAIL\nINPUT OBJECT: {}\nREASON: {}", abnormalRecordDTO, e.toString());
            throw new ResultException(ResultEnum.RESULT_NULL, "更新电梯异常记录失败\n原因: 电梯异常记录不存在");
        }
        catch (Exception e) {
            log.error("UPDATE [abnormalRecord] FAIL\nINPUT OBJECT: {}\nREASON: {}", abnormalRecordDTO, e.toString());
            throw new ResultException(ResultEnum.ERROR, "更新电梯异常记录失败");
        }
        return status;
    }

    @Override
    public int deleteAbnormalRecordById(String id) {
        int status;
        try {
            status = abnormalRecordMapper.deleteAbnormalRecordById(id);
            if (status == MapperConst.OBJECT_NULL) {
                throw new DAOException("this [abnormalRecord] record not exist");
            }
        } catch (DAOException e) {
            log.warn("DELETE [abnormalRecord] FAIL\nINPUT OBJECT: {}\nREASON: {}", id, e.toString());
            throw new ResultException(ResultEnum.RESULT_NULL, "删除电梯异常记录失败\n原因: 电梯异常记录不存在");
        } catch (Exception e) {
            log.error("DELETE [abnormalRecord] FAIL\nINPUT OBJECT: {}\nREASON: {}", id, e.toString());
            throw new ResultException(ResultEnum.ERROR, "删除电梯异常记录失败");
        }
        return status;
    }

}



