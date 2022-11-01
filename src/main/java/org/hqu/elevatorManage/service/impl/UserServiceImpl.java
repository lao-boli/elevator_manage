package org.hqu.elevatorManage.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.hqu.elevatorManage.common.enums.ResultEnum;
import org.hqu.elevatorManage.common.exception.DAOException;
import org.hqu.elevatorManage.common.exception.ResultException;
import org.hqu.elevatorManage.domain.dto.PasswordDTO;
import org.hqu.elevatorManage.domain.entity.User;
import org.hqu.elevatorManage.domain.dto.UserDTO;
import org.hqu.elevatorManage.domain.vo.UserVO;
import org.hqu.elevatorManage.domain.dto.PageDTO;
import org.hqu.elevatorManage.service.UserService;
import org.hqu.elevatorManage.mapper.UserMapper;
import org.hqu.elevatorManage.service.impl.constant.MapperConst;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.BeanUtils;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

/**
 * <p>
 * 针对数据库表[user]的操作Service
 * </p>
 *
 * @author hqully <br>
 * @version 1.0
 * @entity {@link User}
 * @date 2022-10-16 15:36:39 <br>
 */
@Slf4j
@Service
public class UserServiceImpl implements UserService {

    private final String algorithm = "md5";
    private final int times = 2;

    @Resource
    private UserMapper userMapper;

    @Override
    public User getUserByUsername(String username) {
        try {
            return userMapper.getUserByUsername(username);
        } catch (Exception e) {
            log.error("QUERY [user] FAIL\nINPUT OBJECT: {}\nREASON: {}", username, e.toString());
            throw new ResultException(ResultEnum.ERROR, "查询用户失败");
        }
    }

    @Override
    public PageInfo<UserVO> pageUsers(PageDTO page, UserDTO userDTO) {
        try {
            PageHelper.startPage(page);
            List<UserVO> userList = userMapper.listUsers(userDTO);
            return new PageInfo<>(userList);
        } catch (Exception e) {
            log.error("PAGE [user] FAIL\nINPUT OBJECT: {}\nREASON: {}", userDTO, e.toString());
            throw new ResultException(ResultEnum.ERROR, "查询用户分页列表失败");
        }
    }

    @Override
    public List<UserVO> listUsers(UserDTO userDTO) {
        try {
            return userMapper.listUsers(userDTO);
        } catch (Exception e) {
            log.error("LIST [user] FAIL\nINPUT OBJECT: {}\nREASON: {}", userDTO, e.toString());
            throw new ResultException(ResultEnum.ERROR, "查询用户列表失败");
        }
    }

    @Override
    public int addUser(UserDTO userDTO) {
        User user = new User();
        BeanUtils.copyProperties(userDTO, user);
        UUID uuid = UUID.randomUUID();
        user.setUserId(uuid.toString());
        user.setCreateTime(LocalDateTime.now());

        encryptUser(user);

        int status;
        try {
            status = userMapper.addUser(user);
        } catch (DuplicateKeyException e) {
            log.warn("ADD [user] FAIL\nINPUT OBJECT: {}\nREASON: {}", userDTO, e.toString());
            throw new ResultException(ResultEnum.DUPLICATE_KEY_CONFLICT, "添加用户失败\n原因: 用户id已存在");
        } catch (Exception e) {
            log.error("ADD [user] FAIL\nINPUT OBJECT: {}\nREASON: {}", userDTO, e.toString());
            throw new ResultException(ResultEnum.ERROR, "添加用户失败");
        }
        return status;
    }

    @Override
    public int updateUser(UserDTO userDTO) {
        User user = new User();
        BeanUtils.copyProperties(userDTO, user);
        encryptUser(user);

        int status;
        try {
            status = userMapper.updateUser(user);
            if (status == MapperConst.OBJECT_NULL) {
                throw new DAOException("this [user] record not exist");
            }
        } catch (DAOException e) {
            log.warn("UPDATE [user] FAIL\nINPUT OBJECT: {}\nREASON: {}", userDTO, e.toString());
            throw new ResultException(ResultEnum.RESULT_NULL, "更新用户失败\n原因: 用户不存在");
        } catch (Exception e) {
            log.error("UPDATE [user] FAIL\nINPUT OBJECT: {}\nREASON: {}", userDTO, e.toString());
            throw new ResultException(ResultEnum.ERROR, "更新用户失败");
        }
        return status;
    }

    @Override
    public int changePassword(PasswordDTO passwordDTO) {
        User user = userMapper.getUserByUserId(passwordDTO.getUserId());
        if (user == null) {
            throw new ResultException(ResultEnum.RESULT_NULL, "用户不存在");
        }

        // 将传入的旧密码使用原有的盐值加密
        String encryptOldPassword = getEncryptPassword(passwordDTO.getOldPassword(), user.getSalt());

        //  将传入的旧密码使用原有的盐值加密后，与当前账号的密码进行比对
        if (!encryptOldPassword.equals(user.getPassword())) {
            throw new ResultException(ResultEnum.USER_OLD_PWD_ERROR);
        } else {
            String testNewPassword = getEncryptPassword(passwordDTO.getNewPassword(), user.getSalt());
            if (testNewPassword.equals(user.getPassword())) {
                throw new ResultException(ResultEnum.USER_PWD_SAME);
            }
            try {
                // 为新密码生成新盐值
                String salt = new SecureRandomNumberGenerator().nextBytes().toString();
                String encryptNewPassword = getEncryptPassword(passwordDTO.getNewPassword(), salt);
                passwordDTO.setNewPassword(encryptNewPassword);
                passwordDTO.setSalt(salt);
                userMapper.changePassword(passwordDTO);
            } catch (Exception e) {
                log.error("CHANGE PASSWORD FAIL\nINPUT OBJECT: {}\nREASON: {}", passwordDTO, e.toString());
                throw new ResultException(ResultEnum.ERROR, "修改密码失败");

            }
        }

        return 0;
    }

    @Override
    public int deleteUserById(String id) {
        int status;
        try {
            status = userMapper.deleteUserById(id);
            if (status == MapperConst.OBJECT_NULL) {
                throw new DAOException("this [user] record not exist");
            }
        } catch (DAOException e) {
            log.warn("DELETE [user] FAIL\nINPUT OBJECT: {}\nREASON: {}", id, e.toString());
            throw new ResultException(ResultEnum.RESULT_NULL, "删除用户失败\n原因: 用户不存在");
        } catch (Exception e) {
            log.error("DELETE [user] FAIL\nINPUT OBJECT: {}\nREASON: {}", id, e.toString());
            throw new ResultException(ResultEnum.ERROR, "删除用户失败");
        }
        return status;
    }


    /**
     * <p>
     * 加密用户密码
     * </p>
     *
     * @param user 用户
     * @date 2022-10-20 08:37:28 <br>
     * @author hqully <br>
     */
    private void encryptUser(User user) {
        String password = user.getPassword();
        String salt = new SecureRandomNumberGenerator().nextBytes().toString();
        String encryptPassword = getEncryptPassword(password, salt);
        user.setPassword(encryptPassword);
        user.setSalt(salt);
    }

    /**
     * <p>
     * 获取加密后的密码
     * </p>
     *
     * @param password 要加密的密码
     * @param salt     密码盐值
     * @return {@link String}
     * @date 2022-10-20 10:42:31 <br>
     * @author hqully <br>
     */
    private String getEncryptPassword(String password, String salt) {
        String encryptPassword = new SimpleHash(algorithm, password, salt, times).toString();
        return encryptPassword;
    }


}



