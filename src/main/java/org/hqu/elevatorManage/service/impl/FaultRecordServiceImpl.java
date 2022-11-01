package org.hqu.elevatorManage.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.hqu.elevatorManage.common.enums.ResultEnum;
import org.hqu.elevatorManage.common.exception.DAOException;
import org.hqu.elevatorManage.common.exception.ResultException;
import org.hqu.elevatorManage.domain.entity.FaultRecord;
import org.hqu.elevatorManage.domain.dto.FaultRecordDTO;
import org.hqu.elevatorManage.domain.vo.FaultRecordVO;
import org.hqu.elevatorManage.domain.dto.PageDTO;
import org.hqu.elevatorManage.domain.vo.StatisticsVO;
import org.hqu.elevatorManage.service.FaultRecordService;
import org.hqu.elevatorManage.mapper.FaultRecordMapper;
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
 * 针对数据库表[faultRecord]的操作Service
 * </p>
 *
 * @entity {@link FaultRecord}
 * @date 2022-10-28 09:45:59 <br>
 * @author hqully <br>
 * @version 1.0
 */
@Slf4j
@Service
public class FaultRecordServiceImpl implements FaultRecordService {

    @Resource
    private FaultRecordMapper faultRecordMapper;

    @Override
    public List<StatisticsVO> getTypeStatistics(String unitId, String maintainCompanyId) {
        try {
            return faultRecordMapper.getTypeStatistics(unitId, maintainCompanyId);
        } catch (Exception e) {
            log.error("LIST [elevator] FAIL\nINPUT PARAMS: {},{}\nREASON: {}", unitId,maintainCompanyId, e.toString());
            throw new ResultException(ResultEnum.ERROR, "获取故障类型的统计数据失败");
        }
    }

    @Override
    public PageInfo<FaultRecordVO> pageFaultRecords(PageDTO page, FaultRecordDTO faultRecordDTO) {
        try {
            PageHelper.startPage(page);
            List<FaultRecordVO> faultRecordList = faultRecordMapper.listFaultRecords(faultRecordDTO);
            return new PageInfo<>(faultRecordList);
        } catch (Exception e) {
            log.error("PAGE [faultRecord] FAIL\nINPUT OBJECT: {}\nREASON: {}", faultRecordDTO, e.toString());
            throw new ResultException(ResultEnum.ERROR, "查询电梯故障记录分页列表失败");
        }
    }

    @Override
    public List<FaultRecordVO> listFaultRecords(FaultRecordDTO faultRecordDTO) {
        try {
            return faultRecordMapper.listFaultRecords(faultRecordDTO);
        } catch (Exception e) {
            log.error("LIST [faultRecord] FAIL\nINPUT OBJECT: {}\nREASON: {}", faultRecordDTO, e.toString());
            throw new ResultException(ResultEnum.ERROR, "查询电梯故障记录列表失败");
        }
    }

    @Override
    public int addFaultRecord(FaultRecordDTO faultRecordDTO) {
        FaultRecord faultRecord = new FaultRecord();
        BeanUtils.copyProperties(faultRecordDTO, faultRecord);

        faultRecord.setRecordId(DAOUtil.generatePrimaryKey("F"));
        int status;
        try {
            status = faultRecordMapper.addFaultRecord(faultRecord);
        } catch (DuplicateKeyException e) {
            log.warn("ADD [faultRecord] FAIL\nINPUT OBJECT: {}\nREASON: {}", faultRecordDTO, e.toString());
            throw new ResultException(ResultEnum.DUPLICATE_KEY_CONFLICT, "添加电梯故障记录失败\n原因: 电梯故障记录id已存在");
        } catch (Exception e) {
            log.error("ADD [faultRecord] FAIL\nINPUT OBJECT: {}\nREASON: {}", faultRecordDTO, e.toString());
            throw new ResultException(ResultEnum.ERROR, "添加电梯故障记录失败");
        }
        return status;
    }

    @Override
    public int updateFaultRecord(FaultRecordDTO faultRecordDTO) {
        FaultRecord faultRecord = new FaultRecord();
        BeanUtils.copyProperties(faultRecordDTO, faultRecord);

        int status;
        try {
            status = faultRecordMapper.updateFaultRecord(faultRecord);
            if (status == MapperConst.OBJECT_NULL) {
                throw new DAOException("this [faultRecord] record not exist");
            }
        }catch (DAOException e){
            log.warn("UPDATE [faultRecord] FAIL\nINPUT OBJECT: {}\nREASON: {}", faultRecordDTO, e.toString());
            throw new ResultException(ResultEnum.RESULT_NULL, "更新电梯故障记录失败\n原因: 电梯故障记录不存在");
        }
        catch (Exception e) {
            log.error("UPDATE [faultRecord] FAIL\nINPUT OBJECT: {}\nREASON: {}", faultRecordDTO, e.toString());
            throw new ResultException(ResultEnum.ERROR, "更新电梯故障记录失败");
        }
        return status;
    }

    @Override
    public int deleteFaultRecordById(String id) {
        int status;
        try {
            status = faultRecordMapper.deleteFaultRecordById(id);
            if (status == MapperConst.OBJECT_NULL) {
                throw new DAOException("this [faultRecord] record not exist");
            }
        } catch (DAOException e) {
            log.warn("DELETE [faultRecord] FAIL\nINPUT OBJECT: {}\nREASON: {}", id, e.toString());
            throw new ResultException(ResultEnum.RESULT_NULL, "删除电梯故障记录失败\n原因: 电梯故障记录不存在");
        } catch (Exception e) {
            log.error("DELETE [faultRecord] FAIL\nINPUT OBJECT: {}\nREASON: {}", id, e.toString());
            throw new ResultException(ResultEnum.ERROR, "删除电梯故障记录失败");
        }
        return status;
    }

}



