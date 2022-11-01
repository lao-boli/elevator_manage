package org.hqu.elevatorManage.service;

import com.github.pagehelper.PageInfo;
import org.hqu.elevatorManage.domain.entity.Unit;
import org.hqu.elevatorManage.domain.dto.UnitDTO;
import org.hqu.elevatorManage.domain.dto.PageDTO;
import org.hqu.elevatorManage.domain.vo.UnitVO;

import java.util.List;

/**
 * <p>
 * 针对数据库表[unitDTO]的操作Service
 * </p>
 *
 * @entity {@link UnitDTO}
 * @date 2022-10-18 08:52:48 <br>
 * @author hqully <br>
 * @version 1.0
 */

public interface UnitService {

     /**
      * <p>
      *     根据[unitDTO]的参数分页条件查询单位列表
      * </p>
      * @param page    分页参数
      * @param unitDTO 查询对象条件参数
      * @return {@link PageInfo<UnitVO>} 单位VO分页列表
      * @date 2022-10-18 08:52:48 <br>
      * @author hqully <br>
      */
     PageInfo<UnitVO> pageUnits(PageDTO page, UnitDTO unitDTO);

     /**
      * <p>
      *     根据[unitDTO]的参数条件查询单位
      * </p>
      * @param unitDTO 查询对象
      * @return {@link List<UnitVO>} 单位VO列表
      * @date 2022-10-18 08:52:48 <br>
      * @author hqully <br>
      */
     List<UnitVO> listUnits(UnitDTO unitDTO);


     /**
      * <p>
      *     添加单位
      * </p>
      * @param unitDTO 单位DTO
      * @return {@link int}
      * @date 2022-10-18 08:52:48 <br>
      * @author hqully <br>
      */
     int addUnit(UnitDTO unitDTO);

     /**
      * <p>
      *     更新单位
      * </p>
      * @param unitDTO 单位DTO
      * @return {@link int}
      * @date 2022-10-18 08:52:48 <br>
      * @author hqully <br>
      */
     int updateUnit(UnitDTO unitDTO);

     /**
      * <p>
      *     通过[id]删除单位
      * </p>
      * @param id 单位id
      * @return {@link int}
      * @date 2022-10-18 08:52:48 <br>
      * @author hqully <br>
      */
     int deleteUnitById(String id);

}
