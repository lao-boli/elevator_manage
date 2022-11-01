package org.hqu.elevatorManage.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.hqu.elevatorManage.common.enums.ResultEnum;
import org.hqu.elevatorManage.common.exception.DAOException;
import org.hqu.elevatorManage.common.exception.ResultException;
import org.hqu.elevatorManage.domain.entity.WorkerGroup;
import org.hqu.elevatorManage.domain.dto.WorkerGroupDTO;
import org.hqu.elevatorManage.domain.vo.WorkerGroupVO;
import org.hqu.elevatorManage.domain.dto.PageDTO;
import org.hqu.elevatorManage.service.WorkerGroupService;
import org.hqu.elevatorManage.mapper.WorkerGroupMapper;
import org.hqu.elevatorManage.service.impl.constant.MapperConst;
import lombok.extern.slf4j.Slf4j;

import org.hqu.elevatorManage.utils.DAOUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 针对数据库表[workerGroup]的操作Service
 * </p>
 *
 * @entity {@link WorkerGroup}
 * @date 2022-10-29 20:00:16 <br>
 * @author hqully <br>
 * @version 1.0
 */
@Slf4j
@Service
public class WorkerGroupServiceImpl implements WorkerGroupService {

    @Resource
    private WorkerGroupMapper workerGroupMapper;

    @Override
    public PageInfo<WorkerGroupVO> pageWorkerGroups(PageDTO page, WorkerGroupDTO workerGroupDTO) {
        try {
            PageHelper.startPage(page);
            List<WorkerGroupVO> workerGroupList = workerGroupMapper.listWorkerGroups(workerGroupDTO);
            return new PageInfo<>(workerGroupList);
        } catch (Exception e) {
            log.error("PAGE [workerGroup] FAIL\nINPUT OBJECT: {}\nREASON: {}", workerGroupDTO, e.toString());
            throw new ResultException(ResultEnum.ERROR, "查询班组分页列表失败");
        }
    }

    @Override
    public List<WorkerGroupVO> listWorkerGroups(WorkerGroupDTO workerGroupDTO) {
        try {
            return workerGroupMapper.listWorkerGroups(workerGroupDTO);
        } catch (Exception e) {
            log.error("LIST [workerGroup] FAIL\nINPUT OBJECT: {}\nREASON: {}", workerGroupDTO, e.toString());
            throw new ResultException(ResultEnum.ERROR, "查询班组列表失败");
        }
    }

    @Override
    public int addWorkerGroup(WorkerGroupDTO workerGroupDTO) {
        WorkerGroup workerGroup = new WorkerGroup();
        BeanUtils.copyProperties(workerGroupDTO, workerGroup);

        workerGroup.setGroupId(DAOUtil.generatePrimaryKey("WG"));
        int status;
        try {
            status = workerGroupMapper.addWorkerGroup(workerGroup);
        } catch (DuplicateKeyException e) {
            log.warn("ADD [workerGroup] FAIL\nINPUT OBJECT: {}\nREASON: {}", workerGroupDTO, e.toString());
            throw new ResultException(ResultEnum.DUPLICATE_KEY_CONFLICT, "添加班组失败\n原因: 班组id已存在");
        } catch (Exception e) {
            log.error("ADD [workerGroup] FAIL\nINPUT OBJECT: {}\nREASON: {}", workerGroupDTO, e.toString());
            throw new ResultException(ResultEnum.ERROR, "添加班组失败");
        }
        return status;
    }

    @Override
    public int updateWorkerGroup(WorkerGroupDTO workerGroupDTO) {
        WorkerGroup workerGroup = new WorkerGroup();
        BeanUtils.copyProperties(workerGroupDTO, workerGroup);

        int status;
        try {
            status = workerGroupMapper.updateWorkerGroup(workerGroup);
            if (status == MapperConst.OBJECT_NULL) {
                throw new DAOException("this [workerGroup] record not exist");
            }
        }catch (DAOException e){
            log.warn("UPDATE [workerGroup] FAIL\nINPUT OBJECT: {}\nREASON: {}", workerGroupDTO, e.toString());
            throw new ResultException(ResultEnum.RESULT_NULL, "更新班组失败\n原因: 班组不存在");
        }
        catch (Exception e) {
            log.error("UPDATE [workerGroup] FAIL\nINPUT OBJECT: {}\nREASON: {}", workerGroupDTO, e.toString());
            throw new ResultException(ResultEnum.ERROR, "更新班组失败");
        }
        return status;
    }

    @Override
    public int deleteWorkerGroupById(String id) {
        int status;
        try {
            status = workerGroupMapper.deleteWorkerGroupById(id);
            if (status == MapperConst.OBJECT_NULL) {
                throw new DAOException("this [workerGroup] record not exist");
            }
        } catch (DAOException e) {
            log.warn("DELETE [workerGroup] FAIL\nINPUT OBJECT: {}\nREASON: {}", id, e.toString());
            throw new ResultException(ResultEnum.RESULT_NULL, "删除班组失败\n原因: 班组不存在");
        } catch (Exception e) {
            log.error("DELETE [workerGroup] FAIL\nINPUT OBJECT: {}\nREASON: {}", id, e.toString());
            throw new ResultException(ResultEnum.ERROR, "删除班组失败");
        }
        return status;
    }

}



