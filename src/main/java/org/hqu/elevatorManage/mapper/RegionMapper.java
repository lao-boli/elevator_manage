package org.hqu.elevatorManage.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.hqu.elevatorManage.domain.dto.RegionDTO;
import org.hqu.elevatorManage.domain.entity.Region;
import org.hqu.elevatorManage.domain.vo.RegionVO;

import java.util.List;

/**
 * <p>
 * 针对数据库表[region]的操作
 * </p>
 *
 * @author hqully <br>
 * @entity {@link Region}
 * @date 2022-11-02 21:42:03 <br>
 * @version 1.0
 */
@Mapper
public interface RegionMapper {

    /**
     * <p>
     * 根据乡/镇/街道行政区代码查询区域
     * </p>
     * @param townId 乡/镇/街道行政区代码
     * @return {@link Region}
     * @date 2022-11-02 19:49:11 <br>
     * @author hqully <br>
     */
    Region getRegionByTownId(@Param("townId") String townId);

    /**
     * <p>
     * 根据[regionDTO]的参数条件查询pojo列表
     * </p>
     *
     * @param regionDTO 查询参数
     * @return {@link List<RegionDTO>} pojoDTO列表
     * @date 2022-11-02 21:42:03 <br>
     * @author hqully <br>
     */
    List<RegionVO> listRegions(RegionDTO regionDTO);

    /**
     * <p>
     * 添加pojo
     * </p>
     *
     * @param region pojo实体类
     * @return {@link int}
     * @date 2022-11-02 21:42:03 <br>
     * @author hqully <br>
     */
    int addRegion(Region region);

    /**
     * <p>
     * 更新pojo
     * </p>
     *
     * @param region pojo
     * @return {@link int}
     * @date 2022-11-02 21:42:03 <br>
     * @author hqully <br>
     */
    int updateRegion(Region region);
    
    /**
     * <p>
     * 通过[id]删除pojo
     * </p>
     *
     * @param id pojoid
     * @return {@link int}
     * @date 2022-11-02 21:42:03 <br>
     * @author hqully <br>
     */
    int deleteRegionById(@Param("id") String id);

}

