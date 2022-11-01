package org.hqu.elevatorManage.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * <p>
 *
 * <p>
 *
 * @author hqully
 * @version 1.0
 * @date 2022/10/28 10:47
 */
class DAOUtilTest {

    @Test
    void generatePrimaryKey() {
        DAOUtil.generatePrimaryKey("T");
    }

}