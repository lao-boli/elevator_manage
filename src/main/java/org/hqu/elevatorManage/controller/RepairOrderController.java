package org.hqu.elevatorManage.controller;

import org.hqu.elevatorManage.domain.entity.RepairOrder;
import org.hqu.elevatorManage.domain.dto.RepairOrderDTO;
import org.hqu.elevatorManage.domain.vo.RepairOrderVO;
import org.hqu.elevatorManage.service.RepairOrderService;
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
 * 维修订单数据接口
 * <p>
 *
 * @author hqully
 * @version 1.0
 * @date 2022-10-27 20:50:46
 */
@Api(tags = {"维修订单数据接口"})
@Slf4j
@RestController
@RequestMapping("/api/repair-order")
public class RepairOrderController extends BaseController {

    @Resource
    private RepairOrderService repairOrderService;

    @ApiOperation(value = "分页条件查询维修订单列表")
    @GetMapping("/page-repair-orders")
    public ResultVO<PageInfo<RepairOrderVO>> pageRepairOrders(PageDTO page, RepairOrderDTO repairOrderDTO) {
        PageInfo<RepairOrderVO> repairOrderPage = repairOrderService.pageRepairOrders(page, repairOrderDTO);
        return ResultVOUtil.success(repairOrderPage);
    }

    @ApiOperation(value = "条件查询维修订单列表")
    @GetMapping("/list-repair-orders")
    public ResultVO<List<RepairOrderVO>> listRepairOrders(RepairOrderDTO repairOrderDTO) {
        List<RepairOrderVO> repairOrderList = repairOrderService.listRepairOrders(repairOrderDTO);
        return ResultVOUtil.success(repairOrderList);
    }

    @ApiOperation(value = "添加维修订单")
    @PostMapping("/add-repair-order")
    public ResultVO<RepairOrderDTO> addRepairOrder(@Validated @RequestBody RepairOrderDTO repairOrderDTO) {
        repairOrderService.addRepairOrder(repairOrderDTO);
        return ResultVOUtil.success("添加维修订单成功");
    }

    @ApiOperation(value = "更新维修订单")
    @PostMapping("/update-repair-order")
    public ResultVO<RepairOrderDTO> updateRepairOrder(@Validated @RequestBody RepairOrderDTO repairOrderDTO) {
        repairOrderService.updateRepairOrder(repairOrderDTO);
        return ResultVOUtil.success("更新维修订单成功");
    }

    @ApiOperation(value = "删除维修订单")
    @DeleteMapping("/delete-repair-order/{id}")
    public ResultVO<RepairOrderDTO> deleteRepairOrder(@PathVariable("id") String id) {
        repairOrderService.deleteRepairOrderById(id);
        return ResultVOUtil.success("删除维修订单成功");
    }

}

