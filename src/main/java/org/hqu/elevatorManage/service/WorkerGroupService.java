package org.hqu.elevatorManage.service;

import com.github.pagehelper.PageInfo;
import org.hqu.elevatorManage.domain.entity.WorkerGroup;
import org.hqu.elevatorManage.domain.dto.WorkerGroupDTO;
import org.hqu.elevatorManage.domain.vo.WorkerGroupVO;
import org.hqu.elevatorManage.domain.dto.PageDTO;

import java.util.List;

/**
 * <p>
 * 针对数据库表[workerGroupDTO]的操作Service
 * </p>
 *
 * @entity {@link WorkerGroupDTO}
 * @date 2022-10-29 20:00:16 <br>
 * @author hqully <br>
 * @version 1.0
 */

public interface WorkerGroupService {

     /**
      * <p>
      *     根据[workerGroupDTO]的参数分页条件查询班组列表
      * </p>
      * @param page    分页参数
      * @param workerGroupDTO 查询对象条件参数
      * @return {@link PageInfo<WorkerGroupVO>} 班组VO分页列表
      * @date 2022-10-29 20:00:16 <br>
      * @author hqully <br>
      */
     PageInfo<WorkerGroupVO> pageWorkerGroups(PageDTO page, WorkerGroupDTO workerGroupDTO);

     /**
      * <p>
      *     根据[workerGroupDTO]的参数条件查询班组
      * </p>
      * @param workerGroupDTO 查询对象
      * @return {@link List<WorkerGroupVO>} 班组VO列表
      * @date 2022-10-29 20:00:16 <br>
      * @author hqully <br>
      */
     List<WorkerGroupVO> listWorkerGroups(WorkerGroupDTO workerGroupDTO);


     /**
      * <p>
      *     添加班组
      * </p>
      * @param workerGroupDTO 班组DTO
      * @return {@link int}
      * @date 2022-10-29 20:00:16 <br>
      * @author hqully <br>
      */
     int addWorkerGroup(WorkerGroupDTO workerGroupDTO);

     /**
      * <p>
      *     更新班组
      * </p>
      * @param workerGroupDTO 班组DTO
      * @return {@link int}
      * @date 2022-10-29 20:00:16 <br>
      * @author hqully <br>
      */
     int updateWorkerGroup(WorkerGroupDTO workerGroupDTO);

     /**
      * <p>
      *     通过[id]删除班组
      * </p>
      * @param id 班组id
      * @return {@link int}
      * @date 2022-10-29 20:00:16 <br>
      * @author hqully <br>
      */
     int deleteWorkerGroupById(String id);

}
