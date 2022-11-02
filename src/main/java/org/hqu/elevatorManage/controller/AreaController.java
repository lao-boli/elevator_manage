package org.hqu.elevatorManage.controller;

import org.hqu.elevatorManage.domain.entity.Area;
import org.hqu.elevatorManage.domain.dto.AreaDTO;
import org.hqu.elevatorManage.domain.vo.AreaVO;
import org.hqu.elevatorManage.service.AreaService;
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
 * 行政区划数据接口
 * <p>
 *
 * @author hqully
 * @version 1.0
 * @date 2022-11-02 15:48:27
 */
@Api(tags = {"行政区划数据接口"})
@Slf4j
@RestController
@RequestMapping("/api/area")
public class AreaController extends BaseController {

    @Resource
    private AreaService areaService;

    @ApiOperation(value = "分页条件查询行政区划列表")
    @GetMapping("/page-areas")
    public ResultVO<PageInfo<AreaVO>> pageAreas(PageDTO page, AreaDTO areaDTO) {
        PageInfo<AreaVO> areaPage = areaService.pageAreas(page, areaDTO);
        return ResultVOUtil.success(areaPage);
    }

    @ApiOperation(value = "条件查询行政区划列表")
    @GetMapping("/list-areas")
    public ResultVO<List<AreaVO>> listAreas(AreaDTO areaDTO) {
        List<AreaVO> areaList = areaService.listAreas(areaDTO);
        return ResultVOUtil.success(areaList);
    }

    @ApiOperation(value = "添加行政区划")
    @PostMapping("/add-area")
    public ResultVO<AreaDTO> addArea(@Validated @RequestBody AreaDTO areaDTO) {
        areaService.addArea(areaDTO);
        return ResultVOUtil.success("添加行政区划成功");
    }

    @ApiOperation(value = "更新行政区划")
    @PostMapping("/update-area")
    public ResultVO<AreaDTO> updateArea(@Validated @RequestBody AreaDTO areaDTO) {
        areaService.updateArea(areaDTO);
        return ResultVOUtil.success("更新行政区划成功");
    }

    @ApiOperation(value = "删除行政区划")
    @DeleteMapping("/delete-area/{id}")
    public ResultVO<AreaDTO> deleteArea(@PathVariable("id") String id) {
        areaService.deleteAreaById(id);
        return ResultVOUtil.success("删除行政区划成功");
    }

}

