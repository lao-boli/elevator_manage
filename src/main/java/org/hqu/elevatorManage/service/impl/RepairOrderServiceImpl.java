package org.hqu.elevatorManage.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.hqu.elevatorManage.common.enums.ResultEnum;
import org.hqu.elevatorManage.common.exception.DAOException;
import org.hqu.elevatorManage.common.exception.ResultException;
import org.hqu.elevatorManage.domain.entity.RepairOrder;
import org.hqu.elevatorManage.domain.dto.RepairOrderDTO;
import org.hqu.elevatorManage.domain.vo.RepairOrderVO;
import org.hqu.elevatorManage.domain.dto.PageDTO;
import org.hqu.elevatorManage.service.RepairOrderService;
import org.hqu.elevatorManage.mapper.RepairOrderMapper;
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
 * 针对数据库表[repairOrder]的操作Service
 * </p>
 *
 * @entity {@link RepairOrder}
 * @date 2022-10-27 20:50:46 <br>
 * @author hqully <br>
 * @version 1.0
 */
@Slf4j
@Service
public class RepairOrderServiceImpl implements RepairOrderService {

    @Resource
    private RepairOrderMapper repairOrderMapper;

    @Override
    public PageInfo<RepairOrderVO> pageRepairOrders(PageDTO page, RepairOrderDTO repairOrderDTO) {
        try {
            PageHelper.startPage(page);
            List<RepairOrderVO> repairOrderList = repairOrderMapper.listRepairOrders(repairOrderDTO);
            return new PageInfo<>(repairOrderList);
        } catch (Exception e) {
            log.error("PAGE [repairOrder] FAIL\nINPUT OBJECT: {}\nREASON: {}", repairOrderDTO, e.toString());
            throw new ResultException(ResultEnum.ERROR, "查询维修订单分页列表失败");
        }
    }

    @Override
    public List<RepairOrderVO> listRepairOrders(RepairOrderDTO repairOrderDTO) {
        try {
            return repairOrderMapper.listRepairOrders(repairOrderDTO);
        } catch (Exception e) {
            log.error("LIST [repairOrder] FAIL\nINPUT OBJECT: {}\nREASON: {}", repairOrderDTO, e.toString());
            throw new ResultException(ResultEnum.ERROR, "查询维修订单列表失败");
        }
    }

    @Override
    public int addRepairOrder(RepairOrderDTO repairOrderDTO) {
        RepairOrder repairOrder = new RepairOrder();
        BeanUtils.copyProperties(repairOrderDTO, repairOrder);

        repairOrder.setOrderId(DAOUtil.generatePrimaryKey("R"));

        int status;
        try {
            status = repairOrderMapper.addRepairOrder(repairOrder);
        } catch (DuplicateKeyException e) {
            log.warn("ADD [repairOrder] FAIL\nINPUT OBJECT: {}\nREASON: {}", repairOrderDTO, e.toString());
            throw new ResultException(ResultEnum.DUPLICATE_KEY_CONFLICT, "添加维修订单失败\n原因: 维修订单id已存在");
        } catch (Exception e) {
            log.error("ADD [repairOrder] FAIL\nINPUT OBJECT: {}\nREASON: {}", repairOrderDTO, e.toString());
            throw new ResultException(ResultEnum.ERROR, "添加维修订单失败");
        }
        return status;
    }

    @Override
    public int updateRepairOrder(RepairOrderDTO repairOrderDTO) {
        RepairOrder repairOrder = new RepairOrder();
        BeanUtils.copyProperties(repairOrderDTO, repairOrder);

        int status;
        try {
            status = repairOrderMapper.updateRepairOrder(repairOrder);
            if (status == MapperConst.OBJECT_NULL) {
                throw new DAOException("this [repairOrder] record not exist");
            }
        }catch (DAOException e){
            log.warn("UPDATE [repairOrder] FAIL\nINPUT OBJECT: {}\nREASON: {}", repairOrderDTO, e.toString());
            throw new ResultException(ResultEnum.RESULT_NULL, "更新维修订单失败\n原因: 维修订单不存在");
        }
        catch (Exception e) {
            log.error("UPDATE [repairOrder] FAIL\nINPUT OBJECT: {}\nREASON: {}", repairOrderDTO, e.toString());
            throw new ResultException(ResultEnum.ERROR, "更新维修订单失败");
        }
        return status;
    }

    @Override
    public int deleteRepairOrderById(String id) {
        int status;
        try {
            status = repairOrderMapper.deleteRepairOrderById(id);
            if (status == MapperConst.OBJECT_NULL) {
                throw new DAOException("this [repairOrder] record not exist");
            }
        } catch (DAOException e) {
            log.warn("DELETE [repairOrder] FAIL\nINPUT OBJECT: {}\nREASON: {}", id, e.toString());
            throw new ResultException(ResultEnum.RESULT_NULL, "删除维修订单失败\n原因: 维修订单不存在");
        } catch (Exception e) {
            log.error("DELETE [repairOrder] FAIL\nINPUT OBJECT: {}\nREASON: {}", id, e.toString());
            throw new ResultException(ResultEnum.ERROR, "删除维修订单失败");
        }
        return status;
    }

}



