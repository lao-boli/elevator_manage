package org.hqu.elevatorManage.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.hqu.elevatorManage.common.enums.ResultEnum;
import org.hqu.elevatorManage.common.exception.DAOException;
import org.hqu.elevatorManage.common.exception.ResultException;
import org.hqu.elevatorManage.domain.entity.Unit;
import org.hqu.elevatorManage.domain.dto.UnitDTO;
import org.hqu.elevatorManage.domain.vo.UnitVO;
import org.hqu.elevatorManage.domain.dto.PageDTO;
import org.hqu.elevatorManage.service.UnitService;
import org.hqu.elevatorManage.mapper.UnitMapper;
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
 * 针对数据库表[unit]的操作Service
 * </p>
 *
 * @entity {@link Unit}
 * @date 2022-10-18 08:52:48 <br>
 * @author hqully <br>
 * @version 1.0
 */
@Slf4j
@Service
public class UnitServiceImpl implements UnitService {

    @Resource
    private UnitMapper unitMapper;

    @Override
    public PageInfo<UnitVO> pageUnits(PageDTO page, UnitDTO unitDTO) {
        try {
            PageHelper.startPage(page);
            List<UnitVO> unitList = unitMapper.listUnits(unitDTO);
            return new PageInfo<>(unitList);
        } catch (Exception e) {
            log.error("PAGE [unit] FAIL\nINPUT OBJECT: {}\nREASON: {}", unitDTO, e.toString());
            throw new ResultException(ResultEnum.ERROR, "查询单位分页列表失败");
        }
    }

    @Override
    public List<UnitVO> listUnits(UnitDTO unitDTO) {
        try {
            return unitMapper.listUnits(unitDTO);
        } catch (Exception e) {
            log.error("LIST [unit] FAIL\nINPUT OBJECT: {}\nREASON: {}", unitDTO, e.toString());
            throw new ResultException(ResultEnum.ERROR, "查询单位列表失败");
        }
    }

    @Override
    public int addUnit(UnitDTO unitDTO) {
        Unit unit = new Unit();
        BeanUtils.copyProperties(unitDTO, unit);
        UUID uuid = UUID.randomUUID();
        unit.setUnitId(uuid.toString());

        int status;
        try {
            status = unitMapper.addUnit(unit);
        } catch (DuplicateKeyException e) {
            log.warn("ADD [unit] FAIL\nINPUT OBJECT: {}\nREASON: {}", unitDTO, e.toString());
            throw new ResultException(ResultEnum.DUPLICATE_KEY_CONFLICT, "添加单位失败\n原因: 单位id已存在");
        } catch (Exception e) {
            log.error("ADD [unit] FAIL\nINPUT OBJECT: {}\nREASON: {}", unitDTO, e.toString());
            throw new ResultException(ResultEnum.ERROR, "添加单位失败");
        }
        return status;
    }

    @Override
    public int updateUnit(UnitDTO unitDTO) {
        Unit unit = new Unit();
        BeanUtils.copyProperties(unitDTO, unit);

        int status;
        try {
            status = unitMapper.updateUnit(unit);
            if (status == MapperConst.OBJECT_NULL) {
                throw new DAOException("this [unit] record not exist");
            }
        }catch (DAOException e){
            log.warn("UPDATE [unit] FAIL\nINPUT OBJECT: {}\nREASON: {}", unitDTO, e.toString());
            throw new ResultException(ResultEnum.RESULT_NULL, "更新单位失败\n原因: 单位不存在");
        }
        catch (Exception e) {
            log.error("UPDATE [unit] FAIL\nINPUT OBJECT: {}\nREASON: {}", unitDTO, e.toString());
            throw new ResultException(ResultEnum.ERROR, "更新单位失败");
        }
        return status;
    }

    @Override
    public int deleteUnitById(String id) {
        int status;
        try {
            status = unitMapper.deleteUnitById(id);
            if (status == MapperConst.OBJECT_NULL) {
                throw new DAOException("this [unit] record not exist");
            }
        } catch (DAOException e) {
            log.warn("DELETE [unit] FAIL\nINPUT OBJECT: {}\nREASON: {}", id, e.toString());
            throw new ResultException(ResultEnum.RESULT_NULL, "删除单位失败\n原因: 单位不存在");
        } catch (Exception e) {
            log.error("DELETE [unit] FAIL\nINPUT OBJECT: {}\nREASON: {}", id, e.toString());
            throw new ResultException(ResultEnum.ERROR, "删除单位失败");
        }
        return status;
    }

}



