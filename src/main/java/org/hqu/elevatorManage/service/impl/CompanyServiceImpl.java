package org.hqu.elevatorManage.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.hqu.elevatorManage.common.enums.ResultEnum;
import org.hqu.elevatorManage.common.exception.DAOException;
import org.hqu.elevatorManage.common.exception.ResultException;
import org.hqu.elevatorManage.domain.entity.Company;
import org.hqu.elevatorManage.domain.dto.CompanyDTO;
import org.hqu.elevatorManage.domain.vo.CompanyVO;
import org.hqu.elevatorManage.domain.dto.PageDTO;
import org.hqu.elevatorManage.service.CompanyService;
import org.hqu.elevatorManage.mapper.CompanyMapper;
import org.hqu.elevatorManage.service.impl.constant.MapperConst;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.BeanUtils;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 针对数据库表[company]的操作Service
 * </p>
 *
 * @entity {@link Company}
 * @date 2022-10-19 20:17:51 <br>
 * @author hqully <br>
 * @version 1.0
 */
@Slf4j
@Service
public class CompanyServiceImpl implements CompanyService {

    @Resource
    private CompanyMapper companyMapper;

    @Override
    public PageInfo<CompanyVO> pageCompanies(PageDTO page, CompanyDTO companyDTO) {
        try {
            PageHelper.startPage(page);
            List<CompanyVO> companyList = companyMapper.listCompanys(companyDTO);
            return new PageInfo<>(companyList);
        } catch (Exception e) {
            log.error("PAGE [company] FAIL\nINPUT OBJECT: {}\nREASON: {}", companyDTO, e.toString());
            throw new ResultException(ResultEnum.ERROR, "查询公司分页列表失败");
        }
    }

    @Override
    public List<CompanyVO> listCompanies(CompanyDTO companyDTO) {
        try {
            return companyMapper.listCompanys(companyDTO);
        } catch (Exception e) {
            log.error("LIST [company] FAIL\nINPUT OBJECT: {}\nREASON: {}", companyDTO, e.toString());
            throw new ResultException(ResultEnum.ERROR, "查询公司列表失败");
        }
    }

    @Override
    public int addCompany(CompanyDTO companyDTO) {
        Company company = new Company();
        BeanUtils.copyProperties(companyDTO, company);

        int status;
        try {
            status = companyMapper.addCompany(company);
        } catch (DuplicateKeyException e) {
            log.warn("ADD [company] FAIL\nINPUT OBJECT: {}\nREASON: {}", companyDTO, e.toString());
            throw new ResultException(ResultEnum.DUPLICATE_KEY_CONFLICT, "添加公司失败\n原因: 公司id已存在");
        } catch (Exception e) {
            log.error("ADD [company] FAIL\nINPUT OBJECT: {}\nREASON: {}", companyDTO, e.toString());
            throw new ResultException(ResultEnum.ERROR, "添加公司失败");
        }
        return status;
    }

    @Override
    public int updateCompany(CompanyDTO companyDTO) {
        Company company = new Company();
        BeanUtils.copyProperties(companyDTO, company);

        int status;
        try {
            status = companyMapper.updateCompany(company);
            if (status == MapperConst.OBJECT_NULL) {
                throw new DAOException("this [company] record not exist");
            }
        }catch (DAOException e){
            log.warn("UPDATE [company] FAIL\nINPUT OBJECT: {}\nREASON: {}", companyDTO, e.toString());
            throw new ResultException(ResultEnum.RESULT_NULL, "更新公司失败\n原因: 公司不存在");
        }
        catch (Exception e) {
            log.error("UPDATE [company] FAIL\nINPUT OBJECT: {}\nREASON: {}", companyDTO, e.toString());
            throw new ResultException(ResultEnum.ERROR, "更新公司失败");
        }
        return status;
    }

    @Override
    public int deleteCompanyById(String id) {
        int status;
        try {
            status = companyMapper.deleteCompanyById(id);
            if (status == MapperConst.OBJECT_NULL) {
                throw new DAOException("this [company] record not exist");
            }
        } catch (DAOException e) {
            log.warn("DELETE [company] FAIL\nINPUT OBJECT: {}\nREASON: {}", id, e.toString());
            throw new ResultException(ResultEnum.RESULT_NULL, "删除公司失败\n原因: 公司不存在");
        } catch (Exception e) {
            log.error("DELETE [company] FAIL\nINPUT OBJECT: {}\nREASON: {}", id, e.toString());
            throw new ResultException(ResultEnum.ERROR, "删除公司失败");
        }
        return status;
    }

}



