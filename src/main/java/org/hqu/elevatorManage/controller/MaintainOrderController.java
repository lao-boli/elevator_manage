package org.hqu.elevatorManage.controller;

import org.hqu.elevatorManage.domain.entity.MaintainOrder;
import org.hqu.elevatorManage.domain.dto.MaintainOrderDTO;
import org.hqu.elevatorManage.domain.vo.MaintainOrderVO;
import org.hqu.elevatorManage.service.MaintainOrderService;
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
 * 维保订单数据接口
 * <p>
 *
 * @author hqully
 * @version 1.0
 * @date 2022-10-27 19:35:31
 */
@Api(tags = {"维保订单数据接口"})
@Slf4j
@RestController
@RequestMapping("/api/maintain-order")
public class MaintainOrderController extends BaseController {

    @Resource
    private MaintainOrderService maintainOrderService;

    @ApiOperation(value = "分页条件查询维保订单列表")
    @GetMapping("/page-maintain-orders")
    public ResultVO<PageInfo<MaintainOrderVO>> pageMaintainOrders(PageDTO page, MaintainOrderDTO maintainOrderDTO) {
        PageInfo<MaintainOrderVO> maintainOrderPage = maintainOrderService.pageMaintainOrders(page, maintainOrderDTO);
        return ResultVOUtil.success(maintainOrderPage);
    }

    @ApiOperation(value = "条件查询维保订单列表")
    @GetMapping("/list-maintain-orders")
    public ResultVO<List<MaintainOrderVO>> listMaintainOrders(MaintainOrderDTO maintainOrderDTO) {
        List<MaintainOrderVO> maintainOrderList = maintainOrderService.listMaintainOrders(maintainOrderDTO);
        return ResultVOUtil.success(maintainOrderList);
    }

    @ApiOperation(value = "添加维保订单")
    @PostMapping("/add-maintain-order")
    public ResultVO<MaintainOrderDTO> addMaintainOrder(@Validated @RequestBody MaintainOrderDTO maintainOrderDTO) {
        maintainOrderService.addMaintainOrder(maintainOrderDTO);
        return ResultVOUtil.success("添加维保订单成功");
    }

    @ApiOperation(value = "更新维保订单")
    @PostMapping("/update-maintain-order")
    public ResultVO<MaintainOrderDTO> updateMaintainOrder(@Validated @RequestBody MaintainOrderDTO maintainOrderDTO) {
        maintainOrderService.updateMaintainOrder(maintainOrderDTO);
        return ResultVOUtil.success("更新维保订单成功");
    }

    @ApiOperation(value = "删除维保订单")
    @DeleteMapping("/delete-maintain-order/{id}")
    public ResultVO<MaintainOrderDTO> deleteMaintainOrder(@PathVariable("id") String id) {
        maintainOrderService.deleteMaintainOrderById(id);
        return ResultVOUtil.success("删除维保订单成功");
    }

}

