package org.hqu.elevatorManage.shiro.realm;


import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.hqu.elevatorManage.domain.dto.RoleDTO;
import org.hqu.elevatorManage.domain.entity.Role;
import org.hqu.elevatorManage.domain.entity.User;
import org.hqu.elevatorManage.service.RoleService;
import org.hqu.elevatorManage.service.UserService;

import javax.annotation.Resource;

/**
 * <p>
 *     处理用户首次登陆情况
 * </p>
 * @author liulingyu
 * @date 2022-05-08 15:42
 * @version 1.0
 */
@Slf4j
public class UserRealm extends AuthorizingRealm {

    @Resource
    UserService userService;

    @Resource
    RoleService roleService;

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        log.debug("userRealm 认证方法执行");
       UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        User user = userService.getUserByUsername(token.getUsername());
        if (user == null){
            return null;
        }
        ByteSource salt = ByteSource.Util.bytes(user.getSalt());
        log.info(user.toString());
        return new SimpleAuthenticationInfo(user,user.getPassword(),salt,getName());
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        log.debug("userRealm 授权方法执行");
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        Subject subject = SecurityUtils.getSubject();
        User currentUser = (User) subject.getPrincipal();
        info.addRole(currentUser.getRoleId());
        info.addStringPermission(currentUser.getRoleId());
        return info;
    }


}
