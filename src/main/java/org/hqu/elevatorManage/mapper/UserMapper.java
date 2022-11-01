package org.hqu.elevatorManage.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.hqu.elevatorManage.domain.dto.PasswordDTO;
import org.hqu.elevatorManage.domain.entity.User;
import org.hqu.elevatorManage.domain.dto.UserDTO;
import org.hqu.elevatorManage.domain.vo.UserVO;

/**
 * <p>
 * 针对数据库表[user]的操作
 * </p>
 *
 * @author hqully <br>
 * @entity {@link User}
 * @date 2022-10-16 15:36:39 <br>
 * @version 1.0
 */
@Mapper
public interface UserMapper {

    /**
     * <p>
     *     通过用户名获取单个用户对象
     * </p>
     * @param username 用户名
     * @return {@link User}
     * @date 2022-10-08 10:31:54 <br>
     * @author hqully <br>
     */
    User getUserByUsername(@Param("username") String username);

    /**
     * <p>
     *     通过用户id获取单个用户对象
     * </p>
     * @param userId 用户id
     * @return {@link User}
     * @date 2022-10-20 10:35:51 <br>
     * @author hqully <br>
     */
    User getUserByUserId(@Param("userId") String userId);

    /**
     * <p>
     * 根据[userDTO]的参数条件查询用户列表
     * </p>
     *
     * @param userDTO 查询参数
     * @return {@link List<UserDTO>} 用户DTO列表
     * @date 2022-10-16 15:36:39 <br>
     * @author hqully <br>
     */
    List<UserVO> listUsers(UserDTO userDTO);

    /**
     * <p>
     * 添加用户
     * </p>
     *
     * @param user 用户实体类
     * @return {@link int}
     * @date 2022-10-16 15:36:39 <br>
     * @author hqully <br>
     */
    int addUser(User user);

    /**
     * <p>
     * 更新用户
     * </p>
     *
     * @param user 用户
     * @return {@link int}
     * @date 2022-10-16 15:36:39 <br>
     * @author hqully <br>
     */
    int updateUser(User user);

    int changePassword(PasswordDTO passwordDTO);
    
    /**
     * <p>
     * 通过[id]删除用户
     * </p>
     *
     * @param id 用户id
     * @return {@link int}
     * @date 2022-10-16 15:36:39 <br>
     * @author hqully <br>
     */
    int deleteUserById(@Param("id") String id);

}

