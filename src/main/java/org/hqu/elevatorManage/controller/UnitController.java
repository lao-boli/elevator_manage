package org.hqu.elevatorManage.controller;

import org.hqu.elevatorManage.domain.entity.Unit;
import org.hqu.elevatorManage.domain.dto.UnitDTO;
import org.hqu.elevatorManage.domain.vo.UnitVO;
import org.hqu.elevatorManage.service.UnitService;
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
 * 单位数据接口
 * <p>
 *
 * @author hqully
 * @version 1.0
 * @date 2022-10-18 08:52:48
 */
@Api(tags = {"单位数据接口"})
@Slf4j
@RestController
@RequestMapping("/api/unit")
public class UnitController extends BaseController {

    @Resource
    private UnitService unitService;

    @ApiOperation(value = "分页条件查询单位列表")
    @GetMapping("/page-units")
    public ResultVO<PageInfo<UnitVO>> pageUnits(PageDTO page, UnitDTO unitDTO) {
        PageInfo<UnitVO> unitPage = unitService.pageUnits(page, unitDTO);
        return ResultVOUtil.success(unitPage);
    }

    @ApiOperation(value = "条件查询单位列表")
    @GetMapping("/list-units")
    public ResultVO<List<UnitVO>> listUnits(UnitDTO unitDTO) {
        List<UnitVO> unitList = unitService.listUnits(unitDTO);
        return ResultVOUtil.success(unitList);
    }

    @ApiOperation(value = "添加单位")
    @PostMapping("/add-unit")
    public ResultVO<UnitDTO> addUnit(@Validated @RequestBody UnitDTO unitDTO) {
        unitService.addUnit(unitDTO);
        return ResultVOUtil.success("添加单位成功");
    }

    @ApiOperation(value = "更新单位")
    @PostMapping("/update-unit")
    public ResultVO<UnitDTO> updateUnit(@Validated @RequestBody UnitDTO unitDTO) {
        unitService.updateUnit(unitDTO);
        return ResultVOUtil.success("更新单位成功");
    }

    @ApiOperation(value = "删除单位")
    @DeleteMapping("/delete-unit/{id}")
    public ResultVO<UnitDTO> deleteUnit(@PathVariable("id") String id) {
        unitService.deleteUnitById(id);
        return ResultVOUtil.success("删除单位成功");
    }

}

