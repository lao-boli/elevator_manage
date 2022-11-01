package org.hqu.elevatorManage.controller;

import org.hqu.elevatorManage.domain.entity.FaultRecord;
import org.hqu.elevatorManage.domain.dto.FaultRecordDTO;
import org.hqu.elevatorManage.domain.vo.FaultRecordVO;
import org.hqu.elevatorManage.domain.vo.StatisticsVO;
import org.hqu.elevatorManage.service.FaultRecordService;
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
 * 电梯故障记录数据接口
 * <p>
 *
 * @author hqully
 * @version 1.0
 * @date 2022-10-28 09:45:59
 */
@Api(tags = {"电梯故障记录数据接口"})
@Slf4j
@RestController
@RequestMapping("/api/fault-record")
public class FaultRecordController extends BaseController {

    @Resource
    private FaultRecordService faultRecordService;

    @ApiOperation(value = "获取故障类型占比统计数据")
    @GetMapping("/get-type-statistics")
    public ResultVO<List<StatisticsVO>> getTypeStatistics(String unitId, String maintainCompanyId) {
        List<StatisticsVO> typeStatistics = faultRecordService.getTypeStatistics(unitId, maintainCompanyId);
        return ResultVOUtil.success(typeStatistics);
    }

    @ApiOperation(value = "分页条件查询电梯故障记录列表")
    @GetMapping("/page-fault-records")
    public ResultVO<PageInfo<FaultRecordVO>> pageFaultRecords(PageDTO page, FaultRecordDTO faultRecordDTO) {
        PageInfo<FaultRecordVO> faultRecordPage = faultRecordService.pageFaultRecords(page, faultRecordDTO);
        return ResultVOUtil.success(faultRecordPage);
    }

    @ApiOperation(value = "条件查询电梯故障记录列表")
    @GetMapping("/list-fault-records")
    public ResultVO<List<FaultRecordVO>> listFaultRecords(FaultRecordDTO faultRecordDTO) {
        List<FaultRecordVO> faultRecordList = faultRecordService.listFaultRecords(faultRecordDTO);
        return ResultVOUtil.success(faultRecordList);
    }

    @ApiOperation(value = "添加电梯故障记录")
    @PostMapping("/add-fault-record")
    public ResultVO<FaultRecordDTO> addFaultRecord(@Validated @RequestBody FaultRecordDTO faultRecordDTO) {
        faultRecordService.addFaultRecord(faultRecordDTO);
        return ResultVOUtil.success("添加电梯故障记录成功");
    }

    @ApiOperation(value = "更新电梯故障记录")
    @PostMapping("/update-fault-record")
    public ResultVO<FaultRecordDTO> updateFaultRecord(@Validated @RequestBody FaultRecordDTO faultRecordDTO) {
        faultRecordService.updateFaultRecord(faultRecordDTO);
        return ResultVOUtil.success("更新电梯故障记录成功");
    }

    @ApiOperation(value = "删除电梯故障记录")
    @DeleteMapping("/delete-fault-record/{id}")
    public ResultVO<FaultRecordDTO> deleteFaultRecord(@PathVariable("id") String id) {
        faultRecordService.deleteFaultRecordById(id);
        return ResultVOUtil.success("删除电梯故障记录成功");
    }

}

