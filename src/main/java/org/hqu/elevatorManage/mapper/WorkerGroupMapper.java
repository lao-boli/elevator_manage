package org.hqu.elevatorManage.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.hqu.elevatorManage.domain.entity.WorkerGroup;
import org.hqu.elevatorManage.domain.dto.WorkerGroupDTO;
import org.hqu.elevatorManage.domain.vo.WorkerGroupVO;

/**
 * <p>
 * 针对数据库表[workerGroup]的操作
 * </p>
 *
 * @author hqully <br>
 * @entity {@link WorkerGroup}
 * @date 2022-10-29 20:00:16 <br>
 * @version 1.0
 */
@Mapper
public interface WorkerGroupMapper {

    /**
     * <p>
     * 根据[workerGroupDTO]的参数条件查询班组列表
     * </p>
     *
     * @param workerGroupDTO 查询参数
     * @return {@link List<WorkerGroupDTO>} 班组DTO列表
     * @date 2022-10-29 20:00:16 <br>
     * @author hqully <br>
     */
    List<WorkerGroupVO> listWorkerGroups(WorkerGroupDTO workerGroupDTO);

    /**
     * <p>
     * 添加班组
     * </p>
     *
     * @param workerGroup 班组实体类
     * @return {@link int}
     * @date 2022-10-29 20:00:16 <br>
     * @author hqully <br>
     */
    int addWorkerGroup(WorkerGroup workerGroup);

    /**
     * <p>
     * 更新班组
     * </p>
     *
     * @param workerGroup 班组
     * @return {@link int}
     * @date 2022-10-29 20:00:16 <br>
     * @author hqully <br>
     */
    int updateWorkerGroup(WorkerGroup workerGroup);
    
    /**
     * <p>
     * 通过[id]删除班组
     * </p>
     *
     * @param id 班组id
     * @return {@link int}
     * @date 2022-10-29 20:00:16 <br>
     * @author hqully <br>
     */
    int deleteWorkerGroupById(@Param("id") String id);

}

