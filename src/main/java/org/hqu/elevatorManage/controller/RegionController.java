package org.hqu.elevatorManage.controller;

import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.hqu.elevatorManage.domain.dto.PageDTO;
import org.hqu.elevatorManage.domain.dto.RegionDTO;
import org.hqu.elevatorManage.domain.vo.RegionVO;
import org.hqu.elevatorManage.domain.vo.ResultVO;
import org.hqu.elevatorManage.service.RegionService;
import org.hqu.elevatorManage.utils.ResultVOUtil;
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
 * @date 2022-11-02 21:42:03
 */
@Api(tags = {"行政区划数据接口"})
@Slf4j
@RestController
@RequestMapping("/api/region")
public class RegionController extends BaseController {

    @Resource
    private RegionService regionService;

    @ApiOperation(value = "分页条件查询行政区划列表")
    @GetMapping("/page-regions")
    public ResultVO<PageInfo<RegionVO>> pageRegions(PageDTO page, RegionDTO regionDTO) {
        PageInfo<RegionVO> regionPage = regionService.pageRegions(page, regionDTO);
        return ResultVOUtil.success(regionPage);
    }

    @ApiOperation(value = "条件查询行政区划列表")
    @GetMapping("/list-regions")
    public ResultVO<List<RegionVO>> listRegions(RegionDTO regionDTO) {
        List<RegionVO> regionList = regionService.listRegions(regionDTO);
        return ResultVOUtil.success(regionList);
    }

    @ApiOperation(value = "添加行政区划")
    @PostMapping("/add-region")
    public ResultVO<RegionDTO> addRegion(@Validated @RequestBody RegionDTO regionDTO) {
        regionService.addRegion(regionDTO);
        return ResultVOUtil.success("添加行政区划成功");
    }

    @ApiOperation(value = "更新行政区划")
    @PostMapping("/update-region")
    public ResultVO<RegionDTO> updateRegion(@Validated @RequestBody RegionDTO regionDTO) {
        regionService.updateRegion(regionDTO);
        return ResultVOUtil.success("更新行政区划成功");
    }

    @ApiOperation(value = "删除行政区划")
    @DeleteMapping("/delete-region/{id}")
    public ResultVO<RegionDTO> deleteRegion(@PathVariable("id") String id) {
        regionService.deleteRegionById(id);
        return ResultVOUtil.success("删除行政区划成功");
    }

}

