package org.hqu.elevatorManage.service;

import com.github.pagehelper.PageInfo;
import org.hqu.elevatorManage.domain.dto.PageDTO;
import org.hqu.elevatorManage.domain.dto.RegionDTO;
import org.hqu.elevatorManage.domain.vo.RegionVO;

import java.util.List;

/**
 * <p>
 * 针对数据库表[regionDTO]的操作Service
 * </p>
 *
 * @entity {@link RegionDTO}
 * @date 2022-11-02 21:42:03 <br>
 * @author hqully <br>
 * @version 1.0
 */

public interface RegionService {

     /**
      * <p>
      *     根据[regionDTO]的参数分页条件查询行政区划列表
      * </p>
      * @param page    分页参数
      * @param regionDTO 查询对象条件参数
      * @return {@link PageInfo<RegionVO>} 行政区划VO分页列表
      * @date 2022-11-02 21:42:03 <br>
      * @author hqully <br>
      */
     PageInfo<RegionVO> pageRegions(PageDTO page, RegionDTO regionDTO);

     /**
      * <p>
      *     根据[regionDTO]的参数条件查询行政区划
      * </p>
      * @param regionDTO 查询对象
      * @return {@link List<RegionVO>} 行政区划VO列表
      * @date 2022-11-02 21:42:03 <br>
      * @author hqully <br>
      */
     List<RegionVO> listRegions(RegionDTO regionDTO);


     /**
      * <p>
      *     添加行政区划
      * </p>
      * @param regionDTO 行政区划DTO
      * @return {@link int}
      * @date 2022-11-02 21:42:03 <br>
      * @author hqully <br>
      */
     int addRegion(RegionDTO regionDTO);

     /**
      * <p>
      *     更新行政区划
      * </p>
      * @param regionDTO 行政区划DTO
      * @return {@link int}
      * @date 2022-11-02 21:42:03 <br>
      * @author hqully <br>
      */
     int updateRegion(RegionDTO regionDTO);

     /**
      * <p>
      *     通过[id]删除行政区划
      * </p>
      * @param id 行政区划id
      * @return {@link int}
      * @date 2022-11-02 21:42:03 <br>
      * @author hqully <br>
      */
     int deleteRegionById(String id);

}
