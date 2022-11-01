package org.hqu.elevatorManage.utils;

import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.hqu.elevatorManage.domain.entity.User;

/**
 * <p>
 * 账号相关工具类
 * <p>
 *
 * @author liulingyu
 * @date 2022/7/7 13:48
 * @version 1.0
 */
public class UserUtil {

    /**
     * <p>
     *     用户注册工具，对密码进行加密
     * </p>
     * @date 2022/7/7 13:50 <br>
     * @author liulingyu <br>
     * @param user 用户实体类
     * @return {@link User} 密码加密后的用户实体类
     */
    public static User register(User user) {
        String password = user.getPassword();
        String salt = new SecureRandomNumberGenerator().nextBytes().toString();
        String algorithmName = "md5";
        int times = 2;
        String encodedPassword = new SimpleHash(algorithmName,password,salt,times).toString();
        user.setPassword(encodedPassword);
        user.setSalt(salt);
        return user;
    }
}
