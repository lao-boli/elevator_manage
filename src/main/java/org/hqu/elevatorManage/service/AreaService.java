package org.hqu.elevatorManage.service;

import com.github.pagehelper.PageInfo;
import org.hqu.elevatorManage.domain.entity.Area;
import org.hqu.elevatorManage.domain.dto.AreaDTO;
import org.hqu.elevatorManage.domain.vo.AreaVO;
import org.hqu.elevatorManage.domain.dto.PageDTO;

import java.util.List;

/**
 * <p>
 * 针对数据库表[areaDTO]的操作Service
 * </p>
 *
 * @entity {@link AreaDTO}
 * @date 2022-11-02 15:48:27 <br>
 * @author hqully <br>
 * @version 1.0
 */

public interface AreaService {

     /**
      * <p>
      *     根据[areaDTO]的参数分页条件查询行政区划列表
      * </p>
      * @param page    分页参数
      * @param areaDTO 查询对象条件参数
      * @return {@link PageInfo<AreaVO>} 行政区划VO分页列表
      * @date 2022-11-02 15:48:27 <br>
      * @author hqully <br>
      */
     PageInfo<AreaVO> pageAreas(PageDTO page, AreaDTO areaDTO);

     /**
      * <p>
      *     根据[areaDTO]的参数条件查询行政区划
      * </p>
      * @param areaDTO 查询对象
      * @return {@link List<AreaVO>} 行政区划VO列表
      * @date 2022-11-02 15:48:27 <br>
      * @author hqully <br>
      */
     List<AreaVO> listAreas(AreaDTO areaDTO);


     /**
      * <p>
      *     添加行政区划
      * </p>
      * @param areaDTO 行政区划DTO
      * @return {@link int}
      * @date 2022-11-02 15:48:27 <br>
      * @author hqully <br>
      */
     int addArea(AreaDTO areaDTO);

     /**
      * <p>
      *     更新行政区划
      * </p>
      * @param areaDTO 行政区划DTO
      * @return {@link int}
      * @date 2022-11-02 15:48:27 <br>
      * @author hqully <br>
      */
     int updateArea(AreaDTO areaDTO);

     /**
      * <p>
      *     通过[id]删除行政区划
      * </p>
      * @param id 行政区划id
      * @return {@link int}
      * @date 2022-11-02 15:48:27 <br>
      * @author hqully <br>
      */
     int deleteAreaById(String id);

}
