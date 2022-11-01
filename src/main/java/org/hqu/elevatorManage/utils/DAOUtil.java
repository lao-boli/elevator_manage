package org.hqu.elevatorManage.utils;

import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

/**
 * <p>
 * 数据库相关工具类
 * <p>
 *
 * @author hqully
 * @version 1.0
 * @date 2022/10/28 10:28
 */
@Slf4j
public class DAOUtil {

    /**
     * <p>
     *     生成主键
     * </p>
     * @param prefix 主键前缀
     * @return {@link String}
     * @date 2022-10-28 10:30:15 <br>
     * @author hqully <br>
     */
    public static String generatePrimaryKey(String prefix) {
        Random random = new Random();
        double raw = random.nextDouble() * 10000;
        String salt = String.valueOf((int) raw);
        DateTimeFormatter formatter =  DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        String time = LocalDateTime.now().format(formatter);
        String primaryKey = prefix + time + salt;
        log.info(primaryKey);

        return primaryKey;

    }

}
