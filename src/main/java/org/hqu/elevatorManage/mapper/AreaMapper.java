package org.hqu.elevatorManage.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.hqu.elevatorManage.domain.entity.Area;
import org.hqu.elevatorManage.domain.dto.AreaDTO;
import org.hqu.elevatorManage.domain.vo.AreaVO;

/**
 * <p>
 * 针对数据库表[area]的操作
 * </p>
 *
 * @author hqully <br>
 * @entity {@link Area}
 * @date 2022-11-02 15:48:27 <br>
 * @version 1.0
 */
@Mapper
public interface AreaMapper {

    /**
     * <p>
     * 根据[areaDTO]的参数条件查询行政区划列表
     * </p>
     *
     * @param areaDTO 查询参数
     * @return {@link List<AreaDTO>} 行政区划DTO列表
     * @date 2022-11-02 15:48:27 <br>
     * @author hqully <br>
     */
    List<AreaVO> listAreas(AreaDTO areaDTO);

    /**
     * <p>
     * 添加行政区划
     * </p>
     *
     * @param area 行政区划实体类
     * @return {@link int}
     * @date 2022-11-02 15:48:27 <br>
     * @author hqully <br>
     */
    int addArea(Area area);

    /**
     * <p>
     * 更新行政区划
     * </p>
     *
     * @param area 行政区划
     * @return {@link int}
     * @date 2022-11-02 15:48:27 <br>
     * @author hqully <br>
     */
    int updateArea(Area area);
    
    /**
     * <p>
     * 通过[id]删除行政区划
     * </p>
     *
     * @param id 行政区划id
     * @return {@link int}
     * @date 2022-11-02 15:48:27 <br>
     * @author hqully <br>
     */
    int deleteAreaById(@Param("id") String id);

}

