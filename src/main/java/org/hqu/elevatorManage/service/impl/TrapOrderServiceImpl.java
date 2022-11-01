package org.hqu.elevatorManage.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.hqu.elevatorManage.common.enums.ResultEnum;
import org.hqu.elevatorManage.common.exception.DAOException;
import org.hqu.elevatorManage.common.exception.ResultException;
import org.hqu.elevatorManage.domain.entity.TrapOrder;
import org.hqu.elevatorManage.domain.dto.TrapOrderDTO;
import org.hqu.elevatorManage.domain.vo.ElevatorVO;
import org.hqu.elevatorManage.domain.vo.TrapOrderVO;
import org.hqu.elevatorManage.domain.dto.PageDTO;
import org.hqu.elevatorManage.mapper.ElevatorMapper;
import org.hqu.elevatorManage.service.TrapOrderService;
import org.hqu.elevatorManage.mapper.TrapOrderMapper;
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
 * 针对数据库表[trapOrder]的操作Service
 * </p>
 *
 * @author hqully <br>
 * @version 1.0
 * @entity {@link TrapOrder}
 * @date 2022-10-27 21:21:33 <br>
 */
@Slf4j
@Service
public class TrapOrderServiceImpl implements TrapOrderService {

    @Resource
    private TrapOrderMapper trapOrderMapper;

    @Resource
    private ElevatorMapper elevatorMapper;

    @Override
    public PageInfo<TrapOrderVO> pageTrapOrders(PageDTO page, TrapOrderDTO trapOrderDTO) {
        try {
            PageHelper.startPage(page);
            List<TrapOrderVO> trapOrderList = trapOrderMapper.listTrapOrders(trapOrderDTO);
            return new PageInfo<>(trapOrderList);
        } catch (Exception e) {
            log.error("PAGE [trapOrder] FAIL\nINPUT OBJECT: {}\nREASON: {}", trapOrderDTO, e.toString());
            throw new ResultException(ResultEnum.ERROR, "查询困人工单分页列表失败");
        }
    }

    @Override
    public List<TrapOrderVO> listTrapOrders(TrapOrderDTO trapOrderDTO) {
        try {
            return trapOrderMapper.listTrapOrders(trapOrderDTO);
        } catch (Exception e) {
            log.error("LIST [trapOrder] FAIL\nINPUT OBJECT: {}\nREASON: {}", trapOrderDTO, e.toString());
            throw new ResultException(ResultEnum.ERROR, "查询困人工单列表失败");
        }
    }

    @Override
    public int addTrapOrder(TrapOrderDTO trapOrderDTO) {
        TrapOrder trapOrder = new TrapOrder();
        BeanUtils.copyProperties(trapOrderDTO, trapOrder);

        trapOrder.setOrderId(DAOUtil.generatePrimaryKey("T"));
        int status;
        try {
            // 获取电梯信息
            ElevatorVO elevator = elevatorMapper.getElevatorByElevatorId(trapOrder.getElevatorId());
            // 复制电梯的部分信息到工单中
            copyElevatorProperties(trapOrder,elevator);
            status = trapOrderMapper.addTrapOrder(trapOrder);
        } catch (DuplicateKeyException e) {
            log.warn("ADD [trapOrder] FAIL\nINPUT OBJECT: {}\nREASON: {}", trapOrderDTO, e.toString());
            throw new ResultException(ResultEnum.DUPLICATE_KEY_CONFLICT, "添加困人工单失败\n原因: 困人工单id已存在");
        } catch (Exception e) {
            log.error("ADD [trapOrder] FAIL\nINPUT OBJECT: {}\nREASON: {}", trapOrderDTO, e.toString());
            throw new ResultException(ResultEnum.ERROR, "添加困人工单失败");
        }
        return status;
    }

    @Override
    public int updateTrapOrder(TrapOrderDTO trapOrderDTO) {
        TrapOrder trapOrder = new TrapOrder();
        BeanUtils.copyProperties(trapOrderDTO, trapOrder);

        int status;
        try {
            status = trapOrderMapper.updateTrapOrder(trapOrder);
            if (status == MapperConst.OBJECT_NULL) {
                throw new DAOException("this [trapOrder] record not exist");
            }
        } catch (DAOException e) {
            log.warn("UPDATE [trapOrder] FAIL\nINPUT OBJECT: {}\nREASON: {}", trapOrderDTO, e.toString());
            throw new ResultException(ResultEnum.RESULT_NULL, "更新困人工单失败\n原因: 困人工单不存在");
        } catch (Exception e) {
            log.error("UPDATE [trapOrder] FAIL\nINPUT OBJECT: {}\nREASON: {}", trapOrderDTO, e.toString());
            throw new ResultException(ResultEnum.ERROR, "更新困人工单失败");
        }
        return status;
    }

    @Override
    public int deleteTrapOrderById(String id) {
        int status;
        try {
            status = trapOrderMapper.deleteTrapOrderById(id);
            if (status == MapperConst.OBJECT_NULL) {
                throw new DAOException("this [trapOrder] record not exist");
            }
        } catch (DAOException e) {
            log.warn("DELETE [trapOrder] FAIL\nINPUT OBJECT: {}\nREASON: {}", id, e.toString());
            throw new ResultException(ResultEnum.RESULT_NULL, "删除困人工单失败\n原因: 困人工单不存在");
        } catch (Exception e) {
            log.error("DELETE [trapOrder] FAIL\nINPUT OBJECT: {}\nREASON: {}", id, e.toString());
            throw new ResultException(ResultEnum.ERROR, "删除困人工单失败");
        }
        return status;
    }

    private void copyElevatorProperties(TrapOrder trapOrder, ElevatorVO elevator) {
        trapOrder.setCompanyId(elevator.getMaintainCompanyId());
        trapOrder.setCompanyName(elevator.getMaintainCompanyName());
        trapOrder.setGroupName(elevator.getMaintainGroupName());
        trapOrder.setGroupId(elevator.getMaintainGroupId());
    }

}



