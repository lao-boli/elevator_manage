package org.hqu.elevatorManage.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.hqu.elevatorManage.common.enums.ResultEnum;
import org.hqu.elevatorManage.common.exception.DAOException;
import org.hqu.elevatorManage.common.exception.ResultException;
import org.hqu.elevatorManage.domain.entity.Role;
import org.hqu.elevatorManage.domain.dto.RoleDTO;
import org.hqu.elevatorManage.domain.vo.RoleVO;
import org.hqu.elevatorManage.domain.dto.PageDTO;
import org.hqu.elevatorManage.service.RoleService;
import org.hqu.elevatorManage.mapper.RoleMapper;
import org.hqu.elevatorManage.service.impl.constant.MapperConst;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.BeanUtils;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 针对数据库表[role]的操作Service
 * </p>
 *
 * @author hqully <br>
 * @version 1.0
 * @entity {@link Role}
 * @date 2022-10-19 19:13:12 <br>
 */
@Slf4j
@Service
public class RoleServiceImpl implements RoleService {

    @Resource
    private RoleMapper roleMapper;

    @Override
    public PageInfo<RoleVO> pageRoles(PageDTO page, RoleDTO roleDTO) {
        try {
            PageHelper.startPage(page);
            List<RoleVO> roleList = roleMapper.listRoles(roleDTO);
            return new PageInfo<>(roleList);
        } catch (Exception e) {
            log.error("PAGE [role] FAIL\nINPUT OBJECT: {}\nREASON: {}", roleDTO, e.toString());
            throw new ResultException(ResultEnum.ERROR, "查询角色分页列表失败");
        }
    }

    @Override
    public List<RoleVO> listRoles(RoleDTO roleDTO) {
        try {
            return roleMapper.listRoles(roleDTO);
        } catch (Exception e) {
            log.error("LIST [role] FAIL\nINPUT OBJECT: {}\nREASON: {}", roleDTO, e.toString());
            throw new ResultException(ResultEnum.ERROR, "查询角色列表失败");
        }
    }

    @Override
    public int addRole(RoleDTO roleDTO) {
        Role role = new Role();
        BeanUtils.copyProperties(roleDTO, role);

        int status;
        try {
            status = roleMapper.addRole(role);
        } catch (DuplicateKeyException e) {
            log.warn("ADD [role] FAIL\nINPUT OBJECT: {}\nREASON: {}", roleDTO, e.toString());
            throw new ResultException(ResultEnum.DUPLICATE_KEY_CONFLICT, "添加角色失败\n原因: 角色id已存在");
        } catch (Exception e) {
            log.error("ADD [role] FAIL\nINPUT OBJECT: {}\nREASON: {}", roleDTO, e.toString());
            throw new ResultException(ResultEnum.ERROR, "添加角色失败");
        }
        return status;
    }

    @Override
    public int updateRole(RoleDTO roleDTO) {
        Role role = new Role();
        BeanUtils.copyProperties(roleDTO, role);

        int status;
        try {
            status = roleMapper.updateRole(role);
            if (status == MapperConst.OBJECT_NULL) {
                throw new DAOException("this [role] record not exist");
            }
        } catch (DAOException e) {
            log.warn("UPDATE [role] FAIL\nINPUT OBJECT: {}\nREASON: {}", roleDTO, e.toString());
            throw new ResultException(ResultEnum.RESULT_NULL, "更新角色失败\n原因: 角色不存在");
        } catch (Exception e) {
            log.error("UPDATE [role] FAIL\nINPUT OBJECT: {}\nREASON: {}", roleDTO, e.toString());
            throw new ResultException(ResultEnum.ERROR, "更新角色失败");
        }
        return status;
    }

    @Override
    public int deleteRoleById(String id) {
        int status;
        try {
            status = roleMapper.deleteRoleById(id);
            if (status == MapperConst.OBJECT_NULL) {
                throw new DAOException("this [role] record not exist");
            }
        } catch (DAOException e) {
            log.warn("DELETE [role] FAIL\nINPUT OBJECT: {}\nREASON: {}", id, e.toString());
            throw new ResultException(ResultEnum.RESULT_NULL, "删除角色失败\n原因: 角色不存在");
        } catch (Exception e) {
            log.error("DELETE [role] FAIL\nINPUT OBJECT: {}\nREASON: {}", id, e.toString());
            throw new ResultException(ResultEnum.ERROR, "删除角色失败");
        }
        return status;
    }

}



