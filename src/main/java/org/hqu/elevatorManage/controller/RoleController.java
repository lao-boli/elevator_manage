package org.hqu.elevatorManage.controller;

import org.hqu.elevatorManage.domain.entity.Role;
import org.hqu.elevatorManage.domain.dto.RoleDTO;
import org.hqu.elevatorManage.domain.vo.RoleVO;
import org.hqu.elevatorManage.service.RoleService;
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
 * 角色数据接口
 * <p>
 *
 * @author hqully
 * @version 1.0
 * @date 2022-10-19 19:12:59
 */
@Api(tags = {"角色数据接口"})
@Slf4j
@RestController
@RequestMapping("/api/role")
public class RoleController extends BaseController {

    @Resource
    private RoleService roleService;

    @ApiOperation(value = "分页条件查询角色列表")
    @GetMapping("/page-roles")
    public ResultVO<PageInfo<RoleVO>> pageRoles(PageDTO page, RoleDTO roleDTO) {
        PageInfo<RoleVO> rolePage = roleService.pageRoles(page, roleDTO);
        return ResultVOUtil.success(rolePage);
    }

    @ApiOperation(value = "条件查询角色列表")
    @GetMapping("/list-roles")
    public ResultVO<List<RoleVO>> listRoles(RoleDTO roleDTO) {
        List<RoleVO> roleList = roleService.listRoles(roleDTO);
        return ResultVOUtil.success(roleList);
    }

    @ApiOperation(value = "添加角色")
    @PostMapping("/add-role")
    public ResultVO<RoleDTO> addRole(@Validated @RequestBody RoleDTO roleDTO) {
        roleService.addRole(roleDTO);
        return ResultVOUtil.success("添加角色成功");
    }

    @ApiOperation(value = "更新角色")
    @PostMapping("/update-role")
    public ResultVO<RoleDTO> updateRole(@Validated @RequestBody RoleDTO roleDTO) {
        roleService.updateRole(roleDTO);
        return ResultVOUtil.success("更新角色成功");
    }

    @ApiOperation(value = "删除角色")
    @DeleteMapping("/delete-role/{id}")
    public ResultVO<RoleDTO> deleteRole(@PathVariable("id") String id) {
        roleService.deleteRoleById(id);
        return ResultVOUtil.success("删除角色成功");
    }

}

