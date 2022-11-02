package org.hqu.elevatorManage.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.hqu.elevatorManage.common.enums.ResultEnum;
import org.hqu.elevatorManage.common.exception.DAOException;
import org.hqu.elevatorManage.common.exception.ResultException;
import org.hqu.elevatorManage.domain.entity.Area;
import org.hqu.elevatorManage.domain.dto.AreaDTO;
import org.hqu.elevatorManage.domain.vo.AreaVO;
import org.hqu.elevatorManage.domain.dto.PageDTO;
import org.hqu.elevatorManage.service.AreaService;
import org.hqu.elevatorManage.mapper.AreaMapper;
import org.hqu.elevatorManage.service.impl.constant.MapperConst;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.BeanUtils;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 针对数据库表[area]的操作Service
 * </p>
 *
 * @entity {@link Area}
 * @date 2022-11-02 15:48:27 <br>
 * @author hqully <br>
 * @version 1.0
 */
@Slf4j
@Service
public class AreaServiceImpl implements AreaService {

    @Resource
    private AreaMapper areaMapper;

    @Override
    public PageInfo<AreaVO> pageAreas(PageDTO page, AreaDTO areaDTO) {
        try {
            PageHelper.startPage(page);
            List<AreaVO> areaList = areaMapper.listAreas(areaDTO);
            return new PageInfo<>(areaList);
        } catch (Exception e) {
            log.error("PAGE [area] FAIL\nINPUT OBJECT: {}\nREASON: {}", areaDTO, e.toString());
            throw new ResultException(ResultEnum.ERROR, "查询行政区划分页列表失败");
        }
    }

    @Override
    public List<AreaVO> listAreas(AreaDTO areaDTO) {
        try {
            return areaMapper.listAreas(areaDTO);
        } catch (Exception e) {
            log.error("LIST [area] FAIL\nINPUT OBJECT: {}\nREASON: {}", areaDTO, e.toString());
            throw new ResultException(ResultEnum.ERROR, "查询行政区划列表失败");
        }
    }

    @Override
    public int addArea(AreaDTO areaDTO) {
        Area area = new Area();
        BeanUtils.copyProperties(areaDTO, area);

        int status;
        try {
            status = areaMapper.addArea(area);
        } catch (DuplicateKeyException e) {
            log.warn("ADD [area] FAIL\nINPUT OBJECT: {}\nREASON: {}", areaDTO, e.toString());
            throw new ResultException(ResultEnum.DUPLICATE_KEY_CONFLICT, "添加行政区划失败\n原因: 行政区划id已存在");
        } catch (Exception e) {
            log.error("ADD [area] FAIL\nINPUT OBJECT: {}\nREASON: {}", areaDTO, e.toString());
            throw new ResultException(ResultEnum.ERROR, "添加行政区划失败");
        }
        return status;
    }

    @Override
    public int updateArea(AreaDTO areaDTO) {
        Area area = new Area();
        BeanUtils.copyProperties(areaDTO, area);

        int status;
        try {
            status = areaMapper.updateArea(area);
            if (status == MapperConst.OBJECT_NULL) {
                throw new DAOException("this [area] record not exist");
            }
        }catch (DAOException e){
            log.warn("UPDATE [area] FAIL\nINPUT OBJECT: {}\nREASON: {}", areaDTO, e.toString());
            throw new ResultException(ResultEnum.RESULT_NULL, "更新行政区划失败\n原因: 行政区划不存在");
        }
        catch (Exception e) {
            log.error("UPDATE [area] FAIL\nINPUT OBJECT: {}\nREASON: {}", areaDTO, e.toString());
            throw new ResultException(ResultEnum.ERROR, "更新行政区划失败");
        }
        return status;
    }

    @Override
    public int deleteAreaById(String id) {
        int status;
        try {
            status = areaMapper.deleteAreaById(id);
            if (status == MapperConst.OBJECT_NULL) {
                throw new DAOException("this [area] record not exist");
            }
        } catch (DAOException e) {
            log.warn("DELETE [area] FAIL\nINPUT OBJECT: {}\nREASON: {}", id, e.toString());
            throw new ResultException(ResultEnum.RESULT_NULL, "删除行政区划失败\n原因: 行政区划不存在");
        } catch (Exception e) {
            log.error("DELETE [area] FAIL\nINPUT OBJECT: {}\nREASON: {}", id, e.toString());
            throw new ResultException(ResultEnum.ERROR, "删除行政区划失败");
        }
        return status;
    }

}



