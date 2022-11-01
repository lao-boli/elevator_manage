package org.hqu.elevatorManage.controller;

import org.hqu.elevatorManage.domain.entity.Elevator;
import org.hqu.elevatorManage.domain.dto.ElevatorDTO;
import org.hqu.elevatorManage.domain.vo.ElevatorVO;
import org.hqu.elevatorManage.domain.vo.StatisticsVO;
import org.hqu.elevatorManage.service.ElevatorService;
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
 * 电梯数据接口
 * <p>
 *
 * @author hqully
 * @version 1.0
 * @date 2022-10-30 20:36:45
 */
@Api(tags = {"电梯数据接口"})
@Slf4j
@RestController
@RequestMapping("/api/elevator")
public class ElevatorController extends BaseController {

    @Resource
    private ElevatorService elevatorService;

    @ApiOperation(value = "获取电梯品牌的占比统计数据")
    @GetMapping("/get-brand-statistics")
    public ResultVO<List<StatisticsVO>> getBrandStatistics(String unitId, String maintainCompanyId) {
        List<StatisticsVO> brandStatistics = elevatorService.getBrandStatistics(unitId, maintainCompanyId);
        return ResultVOUtil.success(brandStatistics);
    }

    @ApiOperation(value = "分页条件查询电梯列表")
    @GetMapping("/page-elevators")
    public ResultVO<PageInfo<ElevatorVO>> pageElevators(PageDTO page, ElevatorDTO elevatorDTO) {
        PageInfo<ElevatorVO> elevatorPage = elevatorService.pageElevators(page, elevatorDTO);
        return ResultVOUtil.success(elevatorPage);
    }

    @ApiOperation(value = "条件查询电梯列表")
    @GetMapping("/list-elevators")
    public ResultVO<List<ElevatorVO>> listElevators(ElevatorDTO elevatorDTO) {
        List<ElevatorVO> elevatorList = elevatorService.listElevators(elevatorDTO);
        return ResultVOUtil.success(elevatorList);
    }

    @ApiOperation(value = "添加电梯")
    @PostMapping("/add-elevator")
    public ResultVO<ElevatorDTO> addElevator(@Validated @RequestBody ElevatorDTO elevatorDTO) {
        elevatorService.addElevator(elevatorDTO);
        return ResultVOUtil.success("添加电梯成功");
    }

    @ApiOperation(value = "更新电梯")
    @PostMapping("/update-elevator")
    public ResultVO<ElevatorDTO> updateElevator(@Validated @RequestBody ElevatorDTO elevatorDTO) {
        elevatorService.updateElevator(elevatorDTO);
        return ResultVOUtil.success("更新电梯成功");
    }

    @ApiOperation(value = "删除电梯")
    @DeleteMapping("/delete-elevator/{id}")
    public ResultVO<ElevatorDTO> deleteElevator(@PathVariable("id") String id) {
        elevatorService.deleteElevatorById(id);
        return ResultVOUtil.success("删除电梯成功");
    }

}

