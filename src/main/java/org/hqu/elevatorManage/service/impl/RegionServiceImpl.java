package org.hqu.elevatorManage.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.hqu.elevatorManage.common.enums.ResultEnum;
import org.hqu.elevatorManage.common.exception.DAOException;
import org.hqu.elevatorManage.common.exception.ResultException;
import org.hqu.elevatorManage.domain.dto.PageDTO;
import org.hqu.elevatorManage.domain.dto.RegionDTO;
import org.hqu.elevatorManage.domain.entity.Region;
import org.hqu.elevatorManage.domain.vo.RegionVO;
import org.hqu.elevatorManage.mapper.RegionMapper;
import org.hqu.elevatorManage.service.RegionService;
import org.hqu.elevatorManage.service.impl.constant.MapperConst;
import org.springframework.beans.BeanUtils;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 针对数据库表[region]的操作Service
 * </p>
 *
 * @entity {@link Region}
 * @date 2022-11-02 21:42:03 <br>
 * @author hqully <br>
 * @version 1.0
 */
@Slf4j
@Service
public class RegionServiceImpl implements RegionService {

    @Resource
    private RegionMapper regionMapper;

    @Override
    public PageInfo<RegionVO> pageRegions(PageDTO page, RegionDTO regionDTO) {
        try {
            PageHelper.startPage(page);
            List<RegionVO> regionList = regionMapper.listRegions(regionDTO);
            return new PageInfo<>(regionList);
        } catch (Exception e) {
            log.error("PAGE [region] FAIL\nINPUT OBJECT: {}\nREASON: {}", regionDTO, e.toString());
            throw new ResultException(ResultEnum.ERROR, "查询行政区划分页列表失败");
        }
    }

    @Override
    public List<RegionVO> listRegions(RegionDTO regionDTO) {
        try {
            return regionMapper.listRegions(regionDTO);
        } catch (Exception e) {
            log.error("LIST [region] FAIL\nINPUT OBJECT: {}\nREASON: {}", regionDTO, e.toString());
            throw new ResultException(ResultEnum.ERROR, "查询行政区划列表失败");
        }
    }

    @Override
    public int addRegion(RegionDTO regionDTO) {
        Region region = new Region();
        BeanUtils.copyProperties(regionDTO, region);

        int status;
        try {
            status = regionMapper.addRegion(region);
        } catch (DuplicateKeyException e) {
            log.warn("ADD [region] FAIL\nINPUT OBJECT: {}\nREASON: {}", regionDTO, e.toString());
            throw new ResultException(ResultEnum.DUPLICATE_KEY_CONFLICT, "添加行政区划失败\n原因: 行政区划id已存在");
        } catch (Exception e) {
            log.error("ADD [region] FAIL\nINPUT OBJECT: {}\nREASON: {}", regionDTO, e.toString());
            throw new ResultException(ResultEnum.ERROR, "添加行政区划失败");
        }
        return status;
    }

    @Override
    public int updateRegion(RegionDTO regionDTO) {
        Region region = new Region();
        BeanUtils.copyProperties(regionDTO, region);

        int status;
        try {
            status = regionMapper.updateRegion(region);
            if (status == MapperConst.OBJECT_NULL) {
                throw new DAOException("this [region] record not exist");
            }
        }catch (DAOException e){
            log.warn("UPDATE [region] FAIL\nINPUT OBJECT: {}\nREASON: {}", regionDTO, e.toString());
            throw new ResultException(ResultEnum.RESULT_NULL, "更新行政区划失败\n原因: 行政区划不存在");
        }
        catch (Exception e) {
            log.error("UPDATE [region] FAIL\nINPUT OBJECT: {}\nREASON: {}", regionDTO, e.toString());
            throw new ResultException(ResultEnum.ERROR, "更新行政区划失败");
        }
        return status;
    }

    @Override
    public int deleteRegionById(String id) {
        int status;
        try {
            status = regionMapper.deleteRegionById(id);
            if (status == MapperConst.OBJECT_NULL) {
                throw new DAOException("this [region] record not exist");
            }
        } catch (DAOException e) {
            log.warn("DELETE [region] FAIL\nINPUT OBJECT: {}\nREASON: {}", id, e.toString());
            throw new ResultException(ResultEnum.RESULT_NULL, "删除行政区划失败\n原因: 行政区划不存在");
        } catch (Exception e) {
            log.error("DELETE [region] FAIL\nINPUT OBJECT: {}\nREASON: {}", id, e.toString());
            throw new ResultException(ResultEnum.ERROR, "删除行政区划失败");
        }
        return status;
    }

}



