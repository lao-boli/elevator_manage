package org.hqu.elevatorManage;

import org.hqu.elevatorManage.utils.DAOUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ElevatorManageApplicationTests {

    @Test
    void contextLoads() {
        DAOUtil.generatePrimaryKey("t");

    }

}
