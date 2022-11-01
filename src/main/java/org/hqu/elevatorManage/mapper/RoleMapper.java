package org.hqu.elevatorManage.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.hqu.elevatorManage.domain.entity.Role;
import org.hqu.elevatorManage.domain.dto.RoleDTO;
import org.hqu.elevatorManage.domain.vo.RoleVO;

/**
 * <p>
 * 针对数据库表[role]的操作
 * </p>
 *
 * @author hqully <br>
 * @entity {@link Role}
 * @date 2022-10-19 19:13:03 <br>
 * @version 1.0
 */
@Mapper
public interface RoleMapper {

    /**
     * <p>
     * 根据[roleDTO]的参数条件查询角色列表
     * </p>
     *
     * @param roleDTO 查询参数
     * @return {@link List<RoleDTO>} 角色DTO列表
     * @date 2022-10-19 19:13:03 <br>
     * @author hqully <br>
     */
    List<RoleVO> listRoles(RoleDTO roleDTO);

    /**
     * <p>
     * 添加角色
     * </p>
     *
     * @param role 角色实体类
     * @return {@link int}
     * @date 2022-10-19 19:13:03 <br>
     * @author hqully <br>
     */
    int addRole(Role role);

    /**
     * <p>
     * 更新角色
     * </p>
     *
     * @param role 角色
     * @return {@link int}
     * @date 2022-10-19 19:13:03 <br>
     * @author hqully <br>
     */
    int updateRole(Role role);
    
    /**
     * <p>
     * 通过[id]删除角色
     * </p>
     *
     * @param id 角色id
     * @return {@link int}
     * @date 2022-10-19 19:13:03 <br>
     * @author hqully <br>
     */
    int deleteRoleById(@Param("id") String id);

}

