package org.hqu.elevatorManage.service;

import com.github.pagehelper.PageInfo;
import org.hqu.elevatorManage.domain.dto.PasswordDTO;
import org.hqu.elevatorManage.domain.entity.User;
import org.hqu.elevatorManage.domain.dto.UserDTO;
import org.hqu.elevatorManage.domain.dto.PageDTO;
import org.hqu.elevatorManage.domain.vo.UserVO;

import java.util.List;

/**
 * <p>
 * 针对数据库表[userDTO]的操作Service
 * </p>
 *
 * @entity {@link UserDTO}
 * @date 2022-10-16 15:36:39 <br>
 * @author hqully <br>
 * @version 1.0
 */

public interface UserService {

     /**
      * <p>
      *     通过用户名获取单个用户对象
      * </p>
      * @param username 用户名
      * @return {@link User}
      * @date 2022-10-08 10:31:54 <br>
      * @author hqully <br>
      */
     User getUserByUsername(String username);

     /**
      * <p>
      *     根据[userDTO]的参数分页条件查询用户列表
      * </p>
      * @param page    分页参数
      * @param userDTO 查询对象条件参数
      * @return {@link PageInfo<UserVO>} 用户VO分页列表
      * @date 2022-10-16 15:36:39 <br>
      * @author hqully <br>
      */
     PageInfo<UserVO> pageUsers(PageDTO page, UserDTO userDTO);

     /**
      * <p>
      *     根据[userDTO]的参数条件查询用户
      * </p>
      * @param userDTO 查询对象
      * @return {@link List<UserVO>} 用户VO列表
      * @date 2022-10-16 15:36:39 <br>
      * @author hqully <br>
      */
     List<UserVO> listUsers(UserDTO userDTO);


     /**
      * <p>
      *     添加用户
      * </p>
      * @param userDTO 用户DTO
      * @return {@link int}
      * @date 2022-10-16 15:36:39 <br>
      * @author hqully <br>
      */
     int addUser(UserDTO userDTO);

     /**
      * <p>
      *     更新用户
      * </p>
      * @param userDTO 用户DTO
      * @return {@link int}
      * @date 2022-10-16 15:36:39 <br>
      * @author hqully <br>
      */
     int updateUser(UserDTO userDTO);


     /**
      * <p>
      *     修改密码
      * </p>
      * @param passwordDTO 修改密码用DTO
      * @return {@link int}
      * @date 2022-10-20 10:37:27 <br>
      * @author hqully <br>
      */
     int changePassword(PasswordDTO passwordDTO);

     /**
      * <p>
      *     通过[id]删除用户
      * </p>
      * @param id 用户id
      * @return {@link int}
      * @date 2022-10-16 15:36:39 <br>
      * @author hqully <br>
      */
     int deleteUserById(String id);

}
