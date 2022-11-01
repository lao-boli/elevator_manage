package org.hqu.elevatorManage.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.hqu.elevatorManage.common.enums.ResultEnum;
import org.hqu.elevatorManage.common.exception.DAOException;
import org.hqu.elevatorManage.common.exception.ResultException;
import org.hqu.elevatorManage.domain.entity.Elevator;
import org.hqu.elevatorManage.domain.dto.ElevatorDTO;
import org.hqu.elevatorManage.domain.vo.ElevatorVO;
import org.hqu.elevatorManage.domain.dto.PageDTO;
import org.hqu.elevatorManage.domain.vo.StatisticsVO;
import org.hqu.elevatorManage.service.ElevatorService;
import org.hqu.elevatorManage.mapper.ElevatorMapper;
import org.hqu.elevatorManage.service.impl.constant.MapperConst;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.BeanUtils;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

/**
 * <p>
 * 针对数据库表[elevator]的操作Service
 * </p>
 *
 * @entity {@link Elevator}
 * @date 2022-10-30 20:36:45 <br>
 * @author hqully <br>
 * @version 1.0
 */
@Slf4j
@Service
public class ElevatorServiceImpl implements ElevatorService {

    @Resource
    private ElevatorMapper elevatorMapper;


    @Override
    public List<StatisticsVO> getBrandStatistics(String unitId, String maintainCompanyId) {
        try {
            return elevatorMapper.getBrandStatistics(unitId, maintainCompanyId);
        } catch (Exception e) {
            log.error("LIST [elevator] FAIL\nINPUT PARAMS: {},{}\nREASON: {}", unitId,maintainCompanyId, e.toString());
            throw new ResultException(ResultEnum.ERROR, "获取电梯品牌的占比统计数据失败");
        }
    }

    @Override
    public PageInfo<ElevatorVO> pageElevators(PageDTO page, ElevatorDTO elevatorDTO) {
        try {
            PageHelper.startPage(page);
            List<ElevatorVO> elevatorList = elevatorMapper.listElevators(elevatorDTO);
            return new PageInfo<>(elevatorList);
        } catch (Exception e) {
            log.error("PAGE [elevator] FAIL\nINPUT OBJECT: {}\nREASON: {}", elevatorDTO, e.toString());
            throw new ResultException(ResultEnum.ERROR, "查询电梯分页列表失败");
        }
    }

    @Override
    public List<ElevatorVO> listElevators(ElevatorDTO elevatorDTO) {
        try {
            return elevatorMapper.listElevators(elevatorDTO);
        } catch (Exception e) {
            log.error("LIST [elevator] FAIL\nINPUT OBJECT: {}\nREASON: {}", elevatorDTO, e.toString());
            throw new ResultException(ResultEnum.ERROR, "查询电梯列表失败");
        }
    }

    @Override
    public int addElevator(ElevatorDTO elevatorDTO) {
        Elevator elevator = new Elevator();
        BeanUtils.copyProperties(elevatorDTO, elevator);

        elevator.setElevatorId(UUID.randomUUID().toString());
        int status;
        try {
            status = elevatorMapper.addElevator(elevator);
        } catch (DuplicateKeyException e) {
            log.warn("ADD [elevator] FAIL\nINPUT OBJECT: {}\nREASON: {}", elevatorDTO, e.toString());
            throw new ResultException(ResultEnum.DUPLICATE_KEY_CONFLICT, "添加电梯失败\n原因: 电梯id已存在");
        } catch (Exception e) {
            log.error("ADD [elevator] FAIL\nINPUT OBJECT: {}\nREASON: {}", elevatorDTO, e.toString());
            throw new ResultException(ResultEnum.ERROR, "添加电梯失败");
        }
        return status;
    }

    @Override
    public int updateElevator(ElevatorDTO elevatorDTO) {
        Elevator elevator = new Elevator();
        BeanUtils.copyProperties(elevatorDTO, elevator);

        int status;
        try {
            status = elevatorMapper.updateElevator(elevator);
            if (status == MapperConst.OBJECT_NULL) {
                throw new DAOException("this [elevator] record not exist");
            }
        }catch (DAOException e){
            log.warn("UPDATE [elevator] FAIL\nINPUT OBJECT: {}\nREASON: {}", elevatorDTO, e.toString());
            throw new ResultException(ResultEnum.RESULT_NULL, "更新电梯失败\n原因: 电梯不存在");
        }
        catch (Exception e) {
            log.error("UPDATE [elevator] FAIL\nINPUT OBJECT: {}\nREASON: {}", elevatorDTO, e.toString());
            throw new ResultException(ResultEnum.ERROR, "更新电梯失败");
        }
        return status;
    }

    @Override
    public int deleteElevatorById(String id) {
        int status;
        try {
            status = elevatorMapper.deleteElevatorById(id);
            if (status == MapperConst.OBJECT_NULL) {
                throw new DAOException("this [elevator] record not exist");
            }
        } catch (DAOException e) {
            log.warn("DELETE [elevator] FAIL\nINPUT OBJECT: {}\nREASON: {}", id, e.toString());
            throw new ResultException(ResultEnum.RESULT_NULL, "删除电梯失败\n原因: 电梯不存在");
        } catch (Exception e) {
            log.error("DELETE [elevator] FAIL\nINPUT OBJECT: {}\nREASON: {}", id, e.toString());
            throw new ResultException(ResultEnum.ERROR, "删除电梯失败");
        }
        return status;
    }

}



