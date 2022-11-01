package org.hqu.elevatorManage.service;

import com.github.pagehelper.PageInfo;
import org.hqu.elevatorManage.domain.entity.AnnualInspectionOrder;
import org.hqu.elevatorManage.domain.dto.AnnualInspectionOrderDTO;
import org.hqu.elevatorManage.domain.vo.AnnualInspectionOrderVO;
import org.hqu.elevatorManage.domain.dto.PageDTO;

import java.util.List;

/**
 * <p>
 * 针对数据库表[annualInspectionOrderDTO]的操作Service
 * </p>
 *
 * @entity {@link AnnualInspectionOrderDTO}
 * @date 2022-10-30 19:21:29 <br>
 * @author hqully <br>
 * @version 1.0
 */

public interface AnnualInspectionOrderService {

     /**
      * <p>
      *     根据[annualInspectionOrderDTO]的参数分页条件查询年检工单列表
      * </p>
      * @param page    分页参数
      * @param annualInspectionOrderDTO 查询对象条件参数
      * @return {@link PageInfo<AnnualInspectionOrderVO>} 年检工单VO分页列表
      * @date 2022-10-30 19:21:29 <br>
      * @author hqully <br>
      */
     PageInfo<AnnualInspectionOrderVO> pageAnnualInspectionOrders(PageDTO page, AnnualInspectionOrderDTO annualInspectionOrderDTO);

     /**
      * <p>
      *     根据[annualInspectionOrderDTO]的参数条件查询年检工单
      * </p>
      * @param annualInspectionOrderDTO 查询对象
      * @return {@link List<AnnualInspectionOrderVO>} 年检工单VO列表
      * @date 2022-10-30 19:21:29 <br>
      * @author hqully <br>
      */
     List<AnnualInspectionOrderVO> listAnnualInspectionOrders(AnnualInspectionOrderDTO annualInspectionOrderDTO);


     /**
      * <p>
      *     添加年检工单
      * </p>
      * @param annualInspectionOrderDTO 年检工单DTO
      * @return {@link int}
      * @date 2022-10-30 19:21:29 <br>
      * @author hqully <br>
      */
     int addAnnualInspectionOrder(AnnualInspectionOrderDTO annualInspectionOrderDTO);

     /**
      * <p>
      *     更新年检工单
      * </p>
      * @param annualInspectionOrderDTO 年检工单DTO
      * @return {@link int}
      * @date 2022-10-30 19:21:29 <br>
      * @author hqully <br>
      */
     int updateAnnualInspectionOrder(AnnualInspectionOrderDTO annualInspectionOrderDTO);

     /**
      * <p>
      *     通过[id]删除年检工单
      * </p>
      * @param id 年检工单id
      * @return {@link int}
      * @date 2022-10-30 19:21:29 <br>
      * @author hqully <br>
      */
     int deleteAnnualInspectionOrderById(String id);

}
