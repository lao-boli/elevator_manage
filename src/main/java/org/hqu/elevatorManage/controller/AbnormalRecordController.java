package org.hqu.elevatorManage.controller;

import org.hqu.elevatorManage.domain.entity.AbnormalRecord;
import org.hqu.elevatorManage.domain.dto.AbnormalRecordDTO;
import org.hqu.elevatorManage.domain.vo.AbnormalRecordVO;
import org.hqu.elevatorManage.domain.vo.StatisticsVO;
import org.hqu.elevatorManage.service.AbnormalRecordService;
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
 * 电梯异常记录数据接口
  <p>
 *
 * @author hqully
 * @version 1.0
 * @date 2022-10-28 09:45:59
 */
@Api(tags = {"电梯异常记录数据接口"})
@Slf4j
@RestController
@RequestMapping("/api/abnormal-record")
public class AbnormalRecordController extends BaseController {

    @Resource
    private AbnormalRecordService abnormalRecordService;


    @ApiOperation(value = "获取异常类型占比统计数据")
    @GetMapping("/get-type-statistics")
    public ResultVO<List<StatisticsVO>> getTypeStatistics(String unitId, String maintainCompanyId) {
        List<StatisticsVO> typeStatistics = abnormalRecordService.getTypeStatistics(unitId, maintainCompanyId);
        return ResultVOUtil.success(typeStatistics);
    }

    @ApiOperation(value = "分页条件查询电梯异常记录列表")
    @GetMapping("/page-abnormal-records")
    public ResultVO<PageInfo<AbnormalRecordVO>> pageAbnormalRecords(PageDTO page, AbnormalRecordDTO abnormalRecordDTO) {
        PageInfo<AbnormalRecordVO> abnormalRecordPage = abnormalRecordService.pageAbnormalRecords(page, abnormalRecordDTO);
        return ResultVOUtil.success(abnormalRecordPage);
    }

    @ApiOperation(value = "条件查询电梯异常记录列表")
    @GetMapping("/list-abnormal-records")
    public ResultVO<List<AbnormalRecordVO>> listAbnormalRecords(AbnormalRecordDTO abnormalRecordDTO) {
        List<AbnormalRecordVO> abnormalRecordList = abnormalRecordService.listAbnormalRecords(abnormalRecordDTO);
        return ResultVOUtil.success(abnormalRecordList);
    }

    @ApiOperation(value = "添加电梯异常记录")
    @PostMapping("/add-abnormal-record")
    public ResultVO<AbnormalRecordDTO> addAbnormalRecord(@Validated @RequestBody AbnormalRecordDTO abnormalRecordDTO) {
        abnormalRecordService.addAbnormalRecord(abnormalRecordDTO);
        return ResultVOUtil.success("添加电梯异常记录成功");
    }

    @ApiOperation(value = "更新电梯异常记录")
    @PostMapping("/update-abnormal-record")
    public ResultVO<AbnormalRecordDTO> updateAbnormalRecord(@Validated @RequestBody AbnormalRecordDTO abnormalRecordDTO) {
        abnormalRecordService.updateAbnormalRecord(abnormalRecordDTO);
        return ResultVOUtil.success("更新电梯异常记录成功");
    }

    @ApiOperation(value = "删除电梯异常记录")
    @DeleteMapping("/delete-abnormal-record/{id}")
    public ResultVO<AbnormalRecordDTO> deleteAbnormalRecord(@PathVariable("id") String id) {
        abnormalRecordService.deleteAbnormalRecordById(id);
        return ResultVOUtil.success("删除电梯异常记录成功");
    }

}

