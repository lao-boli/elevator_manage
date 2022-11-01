package org.hqu.elevatorManage.controller;


import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.hqu.elevatorManage.common.enums.ResultEnum;
import org.hqu.elevatorManage.common.exception.ResultException;
import org.hqu.elevatorManage.domain.entity.User;
import org.hqu.elevatorManage.domain.vo.ResultVO;
import org.hqu.elevatorManage.domain.vo.UserVO;
import org.hqu.elevatorManage.service.RoleService;
import org.hqu.elevatorManage.service.UserService;
import org.hqu.elevatorManage.utils.JWTUtil;
import org.hqu.elevatorManage.utils.ResultVOUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/")
public class LoginController {

    @Resource
    private UserService userService;

    @Resource
    private RoleService roleService;
    private @NotNull(message = "用户名不能为空") String username;
    private @NotNull(message = "密码不能为空") String password;
    private ArrayList<String> roles;

    @ApiOperation(value = "未登陆时跳转的接口")
    @GetMapping("/login")
    public ResultVO toLogin() {
        return ResultVOUtil.error(ResultEnum.USER_LOGOUT);
    }

    @ApiOperation(value = "未授权时跳转的接口")
    @GetMapping("/unauthorized")
    public ResultVO unAuthorized() {
        return ResultVOUtil.error(ResultEnum.NO_PERMISSIONS);
    }

    @ApiOperation(value = "登录", notes = "json对象中只需要有账号和密码")
    @PostMapping("/login")
    public ResultVO login(@RequestBody User user) {
        username = user.getUsername();
        password = user.getPassword();
        if (username == null || password == null) {
            throw new ResultException(ResultEnum.USER_NAME_PWD_NULL);
        }
        User currentUser = null;
        try {
            Subject subject = SecurityUtils.getSubject();
            UsernamePasswordToken token = new UsernamePasswordToken(username, password);
            subject.login(token);
            currentUser = (User) subject.getPrincipal();
            String jwtToken = JWTUtil.createToken(currentUser);

            HashMap<String, String> dataMap = new HashMap<String, String>();
            dataMap.put("token", jwtToken);

            return ResultVOUtil.success("登录成功", dataMap);
        } catch (AuthenticationException e) {
            return ResultVOUtil.error("用户名或密码错误");
        }
    }

    @GetMapping("/get-info")
    public ResultVO<UserVO> getInfo(String token) {
        String username = JWTUtil.getUsername(token);
        User user = userService.getUserByUsername(username);

        UserVO userInfo = new UserVO();

        BeanUtils.copyProperties(user,userInfo);
        roles = new ArrayList<>();
        roles.add(userInfo.getRoleId());
        userInfo.setRoles(roles);

        log.info(userInfo.toString());

        return ResultVOUtil.success(userInfo);

    }

    @PostMapping("/logout")
    public ResultVO logout() {
        return ResultVOUtil.success("success");
    }

}
