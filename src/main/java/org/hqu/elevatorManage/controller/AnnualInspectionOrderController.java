package org.hqu.elevatorManage.controller;

import org.hqu.elevatorManage.domain.entity.AnnualInspectionOrder;
import org.hqu.elevatorManage.domain.dto.AnnualInspectionOrderDTO;
import org.hqu.elevatorManage.domain.vo.AnnualInspectionOrderVO;
import org.hqu.elevatorManage.service.AnnualInspectionOrderService;
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
 * 年检工单数据接口
 * <p>
 *
 * @author hqully
 * @version 1.0
 * @date 2022-10-30 19:21:29
 */
@Api(tags = {"年检工单数据接口"})
@Slf4j
@RestController
@RequestMapping("/api/annual-inspection-order")
public class AnnualInspectionOrderController extends BaseController {

    @Resource
    private AnnualInspectionOrderService annualInspectionOrderService;

    @ApiOperation(value = "分页条件查询年检工单列表")
    @GetMapping("/page-annual-inspection-orders")
    public ResultVO<PageInfo<AnnualInspectionOrderVO>> pageAnnualInspectionOrders(PageDTO page, AnnualInspectionOrderDTO annualInspectionOrderDTO) {
        PageInfo<AnnualInspectionOrderVO> annualInspectionOrderPage = annualInspectionOrderService.pageAnnualInspectionOrders(page, annualInspectionOrderDTO);
        return ResultVOUtil.success(annualInspectionOrderPage);
    }

    @ApiOperation(value = "条件查询年检工单列表")
    @GetMapping("/list-annual-inspection-orders")
    public ResultVO<List<AnnualInspectionOrderVO>> listAnnualInspectionOrders(AnnualInspectionOrderDTO annualInspectionOrderDTO) {
        List<AnnualInspectionOrderVO> annualInspectionOrderList = annualInspectionOrderService.listAnnualInspectionOrders(annualInspectionOrderDTO);
        return ResultVOUtil.success(annualInspectionOrderList);
    }

    @ApiOperation(value = "添加年检工单")
    @PostMapping("/add-annual-inspection-order")
    public ResultVO<AnnualInspectionOrderDTO> addAnnualInspectionOrder(@Validated @RequestBody AnnualInspectionOrderDTO annualInspectionOrderDTO) {
        annualInspectionOrderService.addAnnualInspectionOrder(annualInspectionOrderDTO);
        return ResultVOUtil.success("添加年检工单成功");
    }

    @ApiOperation(value = "更新年检工单")
    @PostMapping("/update-annual-inspection-order")
    public ResultVO<AnnualInspectionOrderDTO> updateAnnualInspectionOrder(@Validated @RequestBody AnnualInspectionOrderDTO annualInspectionOrderDTO) {
        annualInspectionOrderService.updateAnnualInspectionOrder(annualInspectionOrderDTO);
        return ResultVOUtil.success("更新年检工单成功");
    }

    @ApiOperation(value = "删除年检工单")
    @DeleteMapping("/delete-annual-inspection-order/{id}")
    public ResultVO<AnnualInspectionOrderDTO> deleteAnnualInspectionOrder(@PathVariable("id") String id) {
        annualInspectionOrderService.deleteAnnualInspectionOrderById(id);
        return ResultVOUtil.success("删除年检工单成功");
    }

}

