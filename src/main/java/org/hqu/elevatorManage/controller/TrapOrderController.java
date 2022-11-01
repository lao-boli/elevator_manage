package org.hqu.elevatorManage.controller;

import org.hqu.elevatorManage.domain.entity.TrapOrder;
import org.hqu.elevatorManage.domain.dto.TrapOrderDTO;
import org.hqu.elevatorManage.domain.vo.TrapOrderVO;
import org.hqu.elevatorManage.service.TrapOrderService;
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
 * 困人工单数据接口
 * <p>
 *
 * @author hqully
 * @version 1.0
 * @date 2022-10-27 21:21:33
 */
@Api(tags = {"困人工单数据接口"})
@Slf4j
@RestController
@RequestMapping("/api/trap-order")
public class TrapOrderController extends BaseController {

    @Resource
    private TrapOrderService trapOrderService;

    @ApiOperation(value = "分页条件查询困人工单列表")
    @GetMapping("/page-trap-orders")
    public ResultVO<PageInfo<TrapOrderVO>> pageTrapOrders(PageDTO page, TrapOrderDTO trapOrderDTO) {
        PageInfo<TrapOrderVO> trapOrderPage = trapOrderService.pageTrapOrders(page, trapOrderDTO);
        return ResultVOUtil.success(trapOrderPage);
    }

    @ApiOperation(value = "条件查询困人工单列表")
    @GetMapping("/list-trap-orders")
    public ResultVO<List<TrapOrderVO>> listTrapOrders(TrapOrderDTO trapOrderDTO) {
        List<TrapOrderVO> trapOrderList = trapOrderService.listTrapOrders(trapOrderDTO);
        return ResultVOUtil.success(trapOrderList);
    }

    @ApiOperation(value = "添加困人工单")
    @PostMapping("/add-trap-order")
    public ResultVO<TrapOrderDTO> addTrapOrder(@Validated @RequestBody TrapOrderDTO trapOrderDTO) {
        trapOrderService.addTrapOrder(trapOrderDTO);
        return ResultVOUtil.success("添加困人工单成功");
    }

    @ApiOperation(value = "更新困人工单")
    @PostMapping("/update-trap-order")
    public ResultVO<TrapOrderDTO> updateTrapOrder(@Validated @RequestBody TrapOrderDTO trapOrderDTO) {
        trapOrderService.updateTrapOrder(trapOrderDTO);
        return ResultVOUtil.success("更新困人工单成功");
    }

    @ApiOperation(value = "删除困人工单")
    @DeleteMapping("/delete-trap-order/{id}")
    public ResultVO<TrapOrderDTO> deleteTrapOrder(@PathVariable("id") String id) {
        trapOrderService.deleteTrapOrderById(id);
        return ResultVOUtil.success("删除困人工单成功");
    }

}

