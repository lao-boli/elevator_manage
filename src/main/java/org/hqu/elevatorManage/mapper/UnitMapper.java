package org.hqu.elevatorManage.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.hqu.elevatorManage.domain.entity.Unit;
import org.hqu.elevatorManage.domain.dto.UnitDTO;
import org.hqu.elevatorManage.domain.vo.UnitVO;

/**
 * <p>
 * 针对数据库表[unit]的操作
 * </p>
 *
 * @author hqully <br>
 * @entity {@link Unit}
 * @date 2022-10-18 08:52:48 <br>
 * @version 1.0
 */
@Mapper
public interface UnitMapper {

    /**
     * <p>
     * 根据[unitDTO]的参数条件查询单位列表
     * </p>
     *
     * @param unitDTO 查询参数
     * @return {@link List<UnitVO>} 单位DTO列表
     * @date 2022-10-18 08:52:48 <br>
     * @author hqully <br>
     */
    List<UnitVO> listUnits(UnitDTO unitDTO);

    /**
     * <p>
     * 添加单位
     * </p>
     *
     * @param unit 单位实体类
     * @return {@link int}
     * @date 2022-10-18 08:52:48 <br>
     * @author hqully <br>
     */
    int addUnit(Unit unit);

    /**
     * <p>
     * 更新单位
     * </p>
     *
     * @param unit 单位
     * @return {@link int}
     * @date 2022-10-18 08:52:48 <br>
     * @author hqully <br>
     */
    int updateUnit(Unit unit);
    
    /**
     * <p>
     * 通过[id]删除单位
     * </p>
     *
     * @param id 单位id
     * @return {@link int}
     * @date 2022-10-18 08:52:48 <br>
     * @author hqully <br>
     */
    int deleteUnitById(@Param("id") String id);

}

