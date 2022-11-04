package org.hqu.elevatorManage.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.hqu.elevatorManage.common.enums.ResultEnum;
import org.hqu.elevatorManage.common.exception.DAOException;
import org.hqu.elevatorManage.common.exception.ResultException;
import org.hqu.elevatorManage.domain.dto.AnnualInspectionOrderDTO;
import org.hqu.elevatorManage.domain.dto.PageDTO;
import org.hqu.elevatorManage.domain.entity.AnnualInspectionOrder;
import org.hqu.elevatorManage.domain.vo.AnnualInspectionOrderVO;
import org.hqu.elevatorManage.mapper.AnnualInspectionOrderMapper;
import org.hqu.elevatorManage.service.AnnualInspectionOrderService;
import org.hqu.elevatorManage.service.impl.constant.MapperConst;
import org.hqu.elevatorManage.utils.DAOUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 * 针对数据库表[annualInspectionOrder]的操作Service
 * </p>
 *
 * @entity {@link AnnualInspectionOrder}
 * @date 2022-10-30 19:21:29 <br>
 * @author hqully <br>
 * @version 1.0
 */
@Slf4j
@Service
public class AnnualInspectionOrderServiceImpl implements AnnualInspectionOrderService {

    @Resource
    private AnnualInspectionOrderMapper annualInspectionOrderMapper;

    @Override
    public PageInfo<AnnualInspectionOrderVO> pageAnnualInspectionOrders(PageDTO page, AnnualInspectionOrderDTO annualInspectionOrderDTO) {
        try {
            PageHelper.startPage(page);
            List<AnnualInspectionOrderVO> annualInspectionOrderList = annualInspectionOrderMapper.listAnnualInspectionOrders(annualInspectionOrderDTO);
            return new PageInfo<>(annualInspectionOrderList);
        } catch (Exception e) {
            log.error("PAGE [annualInspectionOrder] FAIL\nINPUT OBJECT: {}\nREASON: {}", annualInspectionOrderDTO, e.toString());
            throw new ResultException(ResultEnum.ERROR, "查询年检工单分页列表失败");
        }
    }

    @Override
    public List<AnnualInspectionOrderVO> listAnnualInspectionOrders(AnnualInspectionOrderDTO annualInspectionOrderDTO) {
        try {
            return annualInspectionOrderMapper.listAnnualInspectionOrders(annualInspectionOrderDTO);
        } catch (Exception e) {
            log.error("LIST [annualInspectionOrder] FAIL\nINPUT OBJECT: {}\nREASON: {}", annualInspectionOrderDTO, e.toString());
            throw new ResultException(ResultEnum.ERROR, "查询年检工单列表失败");
        }
    }

    @Override
    public int addAnnualInspectionOrder(AnnualInspectionOrderDTO annualInspectionOrderDTO) {
        AnnualInspectionOrder annualInspectionOrder = new AnnualInspectionOrder();
        BeanUtils.copyProperties(annualInspectionOrderDTO, annualInspectionOrder);

        annualInspectionOrder.setOrderId(DAOUtil.generatePrimaryKey("AI"));
        annualInspectionOrder.setCreateTime(LocalDateTime.now());

        int status;
        try {
            status = annualInspectionOrderMapper.addAnnualInspectionOrder(annualInspectionOrder);
        } catch (DuplicateKeyException e) {
            log.warn("ADD [annualInspectionOrder] FAIL\nINPUT OBJECT: {}\nREASON: {}", annualInspectionOrderDTO, e.toString());
            throw new ResultException(ResultEnum.DUPLICATE_KEY_CONFLICT, "添加年检工单失败\n原因: 年检工单id已存在");
        } catch (Exception e) {
            log.error("ADD [annualInspectionOrder] FAIL\nINPUT OBJECT: {}\nREASON: {}", annualInspectionOrderDTO, e.toString());
            throw new ResultException(ResultEnum.ERROR, "添加年检工单失败");
        }
        return status;
    }

    @Override
    public int updateAnnualInspectionOrder(AnnualInspectionOrderDTO annualInspectionOrderDTO) {
        AnnualInspectionOrder annualInspectionOrder = new AnnualInspectionOrder();
        BeanUtils.copyProperties(annualInspectionOrderDTO, annualInspectionOrder);

        int status;
        try {
            status = annualInspectionOrderMapper.updateAnnualInspectionOrder(annualInspectionOrder);
            if (status == MapperConst.OBJECT_NULL) {
                throw new DAOException("this [annualInspectionOrder] record not exist");
            }
        }catch (DAOException e){
            log.warn("UPDATE [annualInspectionOrder] FAIL\nINPUT OBJECT: {}\nREASON: {}", annualInspectionOrderDTO, e.toString());
            throw new ResultException(ResultEnum.RESULT_NULL, "更新年检工单失败\n原因: 年检工单不存在");
        }
        catch (Exception e) {
            log.error("UPDATE [annualInspectionOrder] FAIL\nINPUT OBJECT: {}\nREASON: {}", annualInspectionOrderDTO, e.toString());
            throw new ResultException(ResultEnum.ERROR, "更新年检工单失败");
        }
        return status;
    }

    @Override
    public int deleteAnnualInspectionOrderById(String id) {
        int status;
        try {
            status = annualInspectionOrderMapper.deleteAnnualInspectionOrderById(id);
            if (status == MapperConst.OBJECT_NULL) {
                throw new DAOException("this [annualInspectionOrder] record not exist");
            }
        } catch (DAOException e) {
            log.warn("DELETE [annualInspectionOrder] FAIL\nINPUT OBJECT: {}\nREASON: {}", id, e.toString());
            throw new ResultException(ResultEnum.RESULT_NULL, "删除年检工单失败\n原因: 年检工单不存在");
        } catch (Exception e) {
            log.error("DELETE [annualInspectionOrder] FAIL\nINPUT OBJECT: {}\nREASON: {}", id, e.toString());
            throw new ResultException(ResultEnum.ERROR, "删除年检工单失败");
        }
        return status;
    }

}



