package org.hqu.elevatorManage.service;

import com.github.pagehelper.PageInfo;
import org.hqu.elevatorManage.domain.entity.Company;
import org.hqu.elevatorManage.domain.dto.CompanyDTO;
import org.hqu.elevatorManage.domain.dto.PageDTO;
import org.hqu.elevatorManage.domain.vo.CompanyVO;

import java.util.List;

/**
 * <p>
 * 针对数据库表[companyDTO]的操作Service
 * </p>
 *
 * @entity {@link CompanyDTO}
 * @date 2022-10-19 20:17:51 <br>
 * @author hqully <br>
 * @version 1.0
 */

public interface CompanyService {

     /**
      * <p>
      *     根据[companyDTO]的参数分页条件查询公司列表
      * </p>
      * @param page    分页参数
      * @param companyDTO 查询对象条件参数
      * @return {@link PageInfo<CompanyVO>} 公司VO分页列表
      * @date 2022-10-19 20:17:51 <br>
      * @author hqully <br>
      */
     PageInfo<CompanyVO> pageCompanies(PageDTO page, CompanyDTO companyDTO);

     /**
      * <p>
      *     根据[companyDTO]的参数条件查询公司
      * </p>
      * @param companyDTO 查询对象
      * @return {@link List<CompanyVO>} 公司VO列表
      * @date 2022-10-19 20:17:51 <br>
      * @author hqully <br>
      */
     List<CompanyVO> listCompanies(CompanyDTO companyDTO);


     /**
      * <p>
      *     添加公司
      * </p>
      * @param companyDTO 公司DTO
      * @return {@link int}
      * @date 2022-10-19 20:17:51 <br>
      * @author hqully <br>
      */
     int addCompany(CompanyDTO companyDTO);

     /**
      * <p>
      *     更新公司
      * </p>
      * @param companyDTO 公司DTO
      * @return {@link int}
      * @date 2022-10-19 20:17:51 <br>
      * @author hqully <br>
      */
     int updateCompany(CompanyDTO companyDTO);

     /**
      * <p>
      *     通过[id]删除公司
      * </p>
      * @param id 公司id
      * @return {@link int}
      * @date 2022-10-19 20:17:51 <br>
      * @author hqully <br>
      */
     int deleteCompanyById(String id);

}
