package org.hqu.elevatorManage.convertor;

import org.apache.ibatis.annotations.Mapper;
import org.hqu.elevatorManage.domain.entity.TrapOrder;
import org.hqu.elevatorManage.domain.vo.ElevatorVO;
import org.mapstruct.MapMapping;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

/**
 * <p>
 * 困人工单实体转换映射器(映射电梯的部分属性到困人工单中)
 * <p>
 *
 * @author hqully
 * @version 1.0
 * @date 2022/11/1 15:09
 */
@Mapper
public interface TrapOrderConvertor {
    TrapOrderConvertor INSTANCE = Mappers.getMapper(TrapOrderConvertor.class);

    /**
     * <p>
     *     映射电梯的部分属性到困人工单中
     * </p>
     * @param elevator 困人工单对应的电梯
     * @return {@link TrapOrder}
     * @date 2022-11-01 15:29:22 <br>
     * @author hqully <br>
     */
    @Mappings({
            @Mapping(source = "maintainCompanyName",target = "companyName"),
            @Mapping(source = "maintainCompanyId",target = "companyId"),
            @Mapping(source = "maintainGroupName",target = "groupName"),
            @Mapping(source = "maintainGroupId",target = "groupId"),
    })
    TrapOrder copyElevatorProperties(ElevatorVO elevator);


}
