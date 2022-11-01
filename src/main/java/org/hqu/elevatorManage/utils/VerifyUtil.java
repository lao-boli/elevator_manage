package org.hqu.elevatorManage.utils;

/**
 * <p>
 * 检验值范围工具类
 * <p>
 *
 * @author liulingyu
 * @date 2022/7/4 15:38
 * @version 1.0
 */
public class VerifyUtil {

    public static boolean inInterval(int num,int low,int high) {
        return num >= low && num <= high;
    }
    public static boolean inInterval(long num,long low,long high) {
        return num >= low && num <= high;
    }
    public static boolean inInterval(float num,float low,float high) {
        return num >= low && num <= high;
    }
    public static boolean inInterval(double num,double low,double high) {
        return num >= low && num <= high;
    }
}
