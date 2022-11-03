package org.hqu.elevatorManage.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.hqu.elevatorManage.domain.dto.CompanyDTO;
import org.hqu.elevatorManage.domain.entity.Company;
import org.hqu.elevatorManage.domain.vo.CompanyVO;

import java.util.List;

/**
 * <p>
 * 针对数据库表[company]的操作
 * </p>
 *
 * @author hqully <br>
 * @entity {@link Company}
 * @date 2022-10-19 20:17:51 <br>
 * @version 1.0
 */
@Mapper
public interface CompanyMapper {

    /**
     * <p>
     * 根据[companyDTO]的参数条件查询pojo列表
     * </p>
     *
     * @param companyDTO 查询参数
     * @return {@link List<CompanyDTO>} pojoDTO列表
     * @date 2022-10-19 20:17:51 <br>
     * @author hqully <br>
     */
    List<CompanyVO> listCompanies(CompanyDTO companyDTO);

    /**
     * <p>
     * 添加pojo
     * </p>
     *
     * @param company pojo实体类
     * @return {@link int}
     * @date 2022-10-19 20:17:51 <br>
     * @author hqully <br>
     */
    int addCompany(Company company);

    /**
     * <p>
     * 更新pojo
     * </p>
     *
     * @param company pojo
     * @return {@link int}
     * @date 2022-10-19 20:17:51 <br>
     * @author hqully <br>
     */
    int updateCompany(Company company);
    
    /**
     * <p>
     * 通过[id]删除pojo
     * </p>
     *
     * @param id pojoid
     * @return {@link int}
     * @date 2022-10-19 20:17:51 <br>
     * @author hqully <br>
     */
    int deleteCompanyById(@Param("id") String id);

}

