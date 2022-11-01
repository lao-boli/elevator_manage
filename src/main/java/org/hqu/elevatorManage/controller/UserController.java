package org.hqu.elevatorManage.controller;

import org.hqu.elevatorManage.domain.dto.PasswordDTO;
import org.hqu.elevatorManage.domain.entity.User;
import org.hqu.elevatorManage.domain.dto.UserDTO;
import org.hqu.elevatorManage.domain.vo.UserVO;
import org.hqu.elevatorManage.service.UserService;
import org.hqu.elevatorManage.utils.ResultVOUtil;
import org.hqu.elevatorManage.domain.dto.PageDTO;
import org.hqu.elevatorManage.domain.vo.ResultVO;

import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 用户数据接口
 * <p>
 *
 * @author hqully
 * @version 1.0
 * @date 2022-10-16 15:36:39
 */
@Api(tags = {"用户数据接口"})
@Slf4j
@RestController
@RequestMapping("/api/user")
public class UserController extends BaseController {

    @Resource
    private UserService userService;

    @ApiOperation(value = "分页条件查询用户列表")
    @GetMapping("/page-users")
    public ResultVO<PageInfo<UserVO>> pageUsers(PageDTO page, UserDTO userDTO) {
        PageInfo<UserVO> userPage = userService.pageUsers(page, userDTO);
        return ResultVOUtil.success(userPage);
    }

    @ApiOperation(value = "条件查询用户列表")
    @GetMapping("/list-users")
    public ResultVO<List<UserVO>> listUsers(UserDTO userDTO) {
        List<UserVO> userList = userService.listUsers(userDTO);
        return ResultVOUtil.success(userList);
    }

    @ApiOperation(value = "添加用户")
    @PostMapping("/add-user")
    public ResultVO<UserDTO> addUser(@Validated @RequestBody UserDTO userDTO) {
        userService.addUser(userDTO);
        return ResultVOUtil.success("添加用户成功");
    }

    @ApiOperation(value = "更新用户")
    @PostMapping("/update-user")
    public ResultVO<UserDTO> updateUser(@Validated @RequestBody UserDTO userDTO) {
        userService.updateUser(userDTO);
        return ResultVOUtil.success("更新用户成功");
    }

    @ApiOperation(value = "修改密码")
    @PostMapping("/change-password")
    public ResultVO<UserDTO> changePassword(@Validated @RequestBody PasswordDTO passwordDTO) {
        userService.changePassword(passwordDTO);
        return ResultVOUtil.success("修改密码成功");
    }

    @ApiOperation(value = "删除用户")
    @DeleteMapping("/delete-user/{id}")
    public ResultVO<UserDTO> deleteUser(@PathVariable("id") String id) {
        userService.deleteUserById(id);
        return ResultVOUtil.success("删除用户成功");
    }

}

