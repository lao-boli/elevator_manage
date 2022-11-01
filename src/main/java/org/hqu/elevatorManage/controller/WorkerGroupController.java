package org.hqu.elevatorManage.controller;

import org.hqu.elevatorManage.domain.entity.WorkerGroup;
import org.hqu.elevatorManage.domain.dto.WorkerGroupDTO;
import org.hqu.elevatorManage.domain.vo.WorkerGroupVO;
import org.hqu.elevatorManage.service.WorkerGroupService;
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
 * 班组数据接口
 * <p>
 *
 * @author hqully
 * @version 1.0
 * @date 2022-10-29 20:00:16
 */
@Api(tags = {"班组数据接口"})
@Slf4j
@RestController
@RequestMapping("/api/worker-group")
public class WorkerGroupController extends BaseController {

    @Resource
    private WorkerGroupService workerGroupService;

    @ApiOperation(value = "分页条件查询班组列表")
    @GetMapping("/page-worker-groups")
    public ResultVO<PageInfo<WorkerGroupVO>> pageWorkerGroups(PageDTO page, WorkerGroupDTO workerGroupDTO) {
        PageInfo<WorkerGroupVO> workerGroupPage = workerGroupService.pageWorkerGroups(page, workerGroupDTO);
        return ResultVOUtil.success(workerGroupPage);
    }

    @ApiOperation(value = "条件查询班组列表")
    @GetMapping("/list-worker-groups")
    public ResultVO<List<WorkerGroupVO>> listWorkerGroups(WorkerGroupDTO workerGroupDTO) {
        List<WorkerGroupVO> workerGroupList = workerGroupService.listWorkerGroups(workerGroupDTO);
        return ResultVOUtil.success(workerGroupList);
    }

    @ApiOperation(value = "添加班组")
    @PostMapping("/add-worker-group")
    public ResultVO<WorkerGroupDTO> addWorkerGroup(@Validated @RequestBody WorkerGroupDTO workerGroupDTO) {
        workerGroupService.addWorkerGroup(workerGroupDTO);
        return ResultVOUtil.success("添加班组成功");
    }

    @ApiOperation(value = "更新班组")
    @PostMapping("/update-worker-group")
    public ResultVO<WorkerGroupDTO> updateWorkerGroup(@Validated @RequestBody WorkerGroupDTO workerGroupDTO) {
        workerGroupService.updateWorkerGroup(workerGroupDTO);
        return ResultVOUtil.success("更新班组成功");
    }

    @ApiOperation(value = "删除班组")
    @DeleteMapping("/delete-worker-group/{id}")
    public ResultVO<WorkerGroupDTO> deleteWorkerGroup(@PathVariable("id") String id) {
        workerGroupService.deleteWorkerGroupById(id);
        return ResultVOUtil.success("删除班组成功");
    }

}

