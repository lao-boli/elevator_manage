package org.hqu.elevatorManage.service;

import com.github.pagehelper.PageInfo;
import org.hqu.elevatorManage.domain.entity.Role;
import org.hqu.elevatorManage.domain.dto.RoleDTO;
import org.hqu.elevatorManage.domain.dto.PageDTO;
import org.hqu.elevatorManage.domain.vo.RoleVO;

import java.util.List;

/**
 * <p>
 * 针对数据库表[roleDTO]的操作Service
 * </p>
 *
 * @entity {@link RoleDTO}
 * @date 2022-10-19 19:13:11 <br>
 * @author hqully <br>
 * @version 1.0
 */

public interface RoleService {

     /**
      * <p>
      *     根据[roleDTO]的参数分页条件查询pojo列表
      * </p>
      * @param page    分页参数
      * @param roleDTO 查询对象条件参数
      * @return {@link PageInfo<RoleVO>} pojoVO分页列表
      * @date 2022-10-19 19:13:11 <br>
      * @author hqully <br>
      */
     PageInfo<RoleVO> pageRoles(PageDTO page, RoleDTO roleDTO);


     /**
      * <p>
      *     根据[roleDTO]的参数条件查询pojo
      * </p>
      * @param roleDTO 查询对象
      * @return {@link List<RoleVO>} pojoVO列表
      * @date 2022-10-19 19:13:11 <br>
      * @author hqully <br>
      */
     List<RoleVO> listRoles(RoleDTO roleDTO);


     /**
      * <p>
      *     添加pojo
      * </p>
      * @param roleDTO pojoDTO
      * @return {@link int}
      * @date 2022-10-19 19:13:11 <br>
      * @author hqully <br>
      */
     int addRole(RoleDTO roleDTO);

     /**
      * <p>
      *     更新pojo
      * </p>
      * @param roleDTO pojoDTO
      * @return {@link int}
      * @date 2022-10-19 19:13:11 <br>
      * @author hqully <br>
      */
     int updateRole(RoleDTO roleDTO);

     /**
      * <p>
      *     通过[id]删除pojo
      * </p>
      * @param id pojoid
      * @return {@link int}
      * @date 2022-10-19 19:13:11 <br>
      * @author hqully <br>
      */
     int deleteRoleById(String id);

}
