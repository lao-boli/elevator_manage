package org.hqu.elevatorManage.controller;

import org.hqu.elevatorManage.domain.dto.CompanyDTO;
import org.hqu.elevatorManage.domain.vo.CompanyVO;
import org.hqu.elevatorManage.service.CompanyService;
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
 * 公司数据接口
 * <p>
 *
 * @author hqully
 * @version 1.0
 * @date 2022-10-19 20:17:51
 */
@Api(tags = {"公司数据接口"})
@Slf4j
@RestController
@RequestMapping("/api/company")
public class CompanyController extends BaseController {

    @Resource
    private CompanyService companyService;

    @ApiOperation(value = "分页条件查询公司列表")
    @GetMapping("/page-companies")
    public ResultVO<PageInfo<CompanyVO>> pageCompanies(PageDTO page, CompanyDTO companyDTO) {
        PageInfo<CompanyVO> companyPage = companyService.pageCompanies(page, companyDTO);
        return ResultVOUtil.success(companyPage);
    }

    @ApiOperation(value = "条件查询公司列表")
    @GetMapping("/list-companies")
    public ResultVO<List<CompanyVO>> listCompanies(CompanyDTO companyDTO) {
        List<CompanyVO> companyList = companyService.listCompanies(companyDTO);
        return ResultVOUtil.success(companyList);
    }

    @ApiOperation(value = "添加公司")
    @PostMapping("/add-company")
    public ResultVO<CompanyDTO> addCompany(@Validated @RequestBody CompanyDTO companyDTO) {
        companyService.addCompany(companyDTO);
        return ResultVOUtil.success("添加公司成功");
    }

    @ApiOperation(value = "更新公司")
    @PostMapping("/update-company")
    public ResultVO<CompanyDTO> updateCompany(@Validated @RequestBody CompanyDTO companyDTO) {
        companyService.updateCompany(companyDTO);
        return ResultVOUtil.success("更新公司成功");
    }

    @ApiOperation(value = "删除公司")
    @DeleteMapping("/delete-company/{id}")
    public ResultVO<CompanyDTO> deleteCompany(@PathVariable("id") String id) {
        companyService.deleteCompanyById(id);
        return ResultVOUtil.success("删除公司成功");
    }

}

