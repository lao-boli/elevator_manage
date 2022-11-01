package org.hqu.elevatorManage.utils;

import java.time.Duration;
import java.time.LocalDateTime;

/**
 * 时间工具
 *
 * @author lly
 * @since 2022-4-1
 */

/**
 * <p>
 *     时间格式处理工具
 * </p>
 * @author liulingyu
 * @date 2022-05-07 16:02
 * @version 1.0
 */
public class TimeUtil {

    /**
     *<p>
     *     求两个LocalDateTime之间的差值，并格式化
     *</p>
     * @date 2022/5/7 16:03 <br>
     * @author liulingyu <br>
     * @param startTime 开始时间
     * @param endTime 结束时间
     * @return java.lang.String 时长
     */
    public static String formatDuration(LocalDateTime startTime,LocalDateTime endTime) {
        Duration duration = Duration.between(startTime,endTime);
        long seconds = duration.getSeconds();
        long absSeconds = Math.abs(seconds);
        String positive = String.format(
                "%d小时%02d分钟%02d秒",
                absSeconds / 3600,
                (absSeconds % 3600) / 60,
                absSeconds % 60);
        return seconds < 0 ? "-" + positive : positive;
    }
    /**
     * <p>
     *     计算两个时间之间的差值，并以秒数的形式返回
     * </p>
     * @date 2022/6/30 9:09 <br>
     * @author liulingyu <br>
     * @param startTime 开始时间
     * @param endTime 结束时间
     * @return {@link String} 间隔秒数
     */
    public static String formatDuration2Seconds(LocalDateTime startTime,LocalDateTime endTime) {
        Duration duration = Duration.between(startTime,endTime);
        long seconds = duration.getSeconds();
        long absSeconds = Math.abs(seconds);
        String second = String.valueOf(absSeconds);
        return second ;
    }
    /**
     * <p>
     *     将秒数转换成时分秒形式
     * </p>
     * @date 2022/6/30 9:05 <br>
     * @author liulingyu <br>
     * @param secondDuration 秒数
     * @return {@link String} 格式化后的时间
     */
    public static String formatDuration(String secondDuration) {
        long seconds = Long.parseLong(secondDuration);
        String positive = String.format(
                "%d小时%02d分钟%02d秒",
                seconds / 3600,
                (seconds % 3600) / 60,
                seconds % 60);
        return seconds < 0 ? "-" + positive : positive;}
}
