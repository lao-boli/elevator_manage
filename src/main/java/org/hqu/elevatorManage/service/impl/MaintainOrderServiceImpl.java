package org.hqu.elevatorManage.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.hqu.elevatorManage.common.enums.ResultEnum;
import org.hqu.elevatorManage.common.exception.DAOException;
import org.hqu.elevatorManage.common.exception.ResultException;
import org.hqu.elevatorManage.domain.entity.MaintainOrder;
import org.hqu.elevatorManage.domain.dto.MaintainOrderDTO;
import org.hqu.elevatorManage.domain.vo.MaintainOrderVO;
import org.hqu.elevatorManage.domain.dto.PageDTO;
import org.hqu.elevatorManage.service.MaintainOrderService;
import org.hqu.elevatorManage.mapper.MaintainOrderMapper;
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
 * 针对数据库表[maintainOrder]的操作Service
 * </p>
 *
 * @entity {@link MaintainOrder}
 * @date 2022-10-27 19:35:31 <br>
 * @author hqully <br>
 * @version 1.0
 */
@Slf4j
@Service
public class MaintainOrderServiceImpl implements MaintainOrderService {

    @Resource
    private MaintainOrderMapper maintainOrderMapper;

    @Override
    public PageInfo<MaintainOrderVO> pageMaintainOrders(PageDTO page, MaintainOrderDTO maintainOrderDTO) {
        try {
            PageHelper.startPage(page);
            List<MaintainOrderVO> maintainOrderList = maintainOrderMapper.listMaintainOrders(maintainOrderDTO);
            return new PageInfo<>(maintainOrderList);
        } catch (Exception e) {
            log.error("PAGE [maintainOrder] FAIL\nINPUT OBJECT: {}\nREASON: {}", maintainOrderDTO, e.toString());
            throw new ResultException(ResultEnum.ERROR, "查询维保订单分页列表失败");
        }
    }

    @Override
    public List<MaintainOrderVO> listMaintainOrders(MaintainOrderDTO maintainOrderDTO) {
        try {
            return maintainOrderMapper.listMaintainOrders(maintainOrderDTO);
        } catch (Exception e) {
            log.error("LIST [maintainOrder] FAIL\nINPUT OBJECT: {}\nREASON: {}", maintainOrderDTO, e.toString());
            throw new ResultException(ResultEnum.ERROR, "查询维保订单列表失败");
        }
    }

    @Override
    public int addMaintainOrder(MaintainOrderDTO maintainOrderDTO) {
        MaintainOrder maintainOrder = new MaintainOrder();
        BeanUtils.copyProperties(maintainOrderDTO, maintainOrder);

        maintainOrder.setOrderId(DAOUtil.generatePrimaryKey("MT"));

        int status;
        try {
            status = maintainOrderMapper.addMaintainOrder(maintainOrder);
        } catch (DuplicateKeyException e) {
            log.warn("ADD [maintainOrder] FAIL\nINPUT OBJECT: {}\nREASON: {}", maintainOrderDTO, e.toString());
            throw new ResultException(ResultEnum.DUPLICATE_KEY_CONFLICT, "添加维保订单失败\n原因: 维保订单id已存在");
        } catch (Exception e) {
            log.error("ADD [maintainOrder] FAIL\nINPUT OBJECT: {}\nREASON: {}", maintainOrderDTO, e.toString());
            throw new ResultException(ResultEnum.ERROR, "添加维保订单失败");
        }
        return status;
    }

    @Override
    public int updateMaintainOrder(MaintainOrderDTO maintainOrderDTO) {
        MaintainOrder maintainOrder = new MaintainOrder();
        BeanUtils.copyProperties(maintainOrderDTO, maintainOrder);

        int status;
        try {
            status = maintainOrderMapper.updateMaintainOrder(maintainOrder);
            if (status == MapperConst.OBJECT_NULL) {
                throw new DAOException("this [maintainOrder] record not exist");
            }
        }catch (DAOException e){
            log.warn("UPDATE [maintainOrder] FAIL\nINPUT OBJECT: {}\nREASON: {}", maintainOrderDTO, e.toString());
            throw new ResultException(ResultEnum.RESULT_NULL, "更新维保订单失败\n原因: 维保订单不存在");
        }
        catch (Exception e) {
            log.error("UPDATE [maintainOrder] FAIL\nINPUT OBJECT: {}\nREASON: {}", maintainOrderDTO, e.toString());
            throw new ResultException(ResultEnum.ERROR, "更新维保订单失败");
        }
        return status;
    }

    @Override
    public int deleteMaintainOrderById(String id) {
        int status;
        try {
            status = maintainOrderMapper.deleteMaintainOrderById(id);
            if (status == MapperConst.OBJECT_NULL) {
                throw new DAOException("this [maintainOrder] record not exist");
            }
        } catch (DAOException e) {
            log.warn("DELETE [maintainOrder] FAIL\nINPUT OBJECT: {}\nREASON: {}", id, e.toString());
            throw new ResultException(ResultEnum.RESULT_NULL, "删除维保订单失败\n原因: 维保订单不存在");
        } catch (Exception e) {
            log.error("DELETE [maintainOrder] FAIL\nINPUT OBJECT: {}\nREASON: {}", id, e.toString());
            throw new ResultException(ResultEnum.ERROR, "删除维保订单失败");
        }
        return status;
    }

}



