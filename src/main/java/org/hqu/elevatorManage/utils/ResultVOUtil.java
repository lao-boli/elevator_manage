package org.hqu.elevatorManage.utils;


import org.hqu.elevatorManage.common.enums.ResultEnum;
import org.hqu.elevatorManage.domain.vo.ResultVO;

/**
 * <p>
 * 响应数据(结果)最外层对象工具
 * </p>
 *
 * @author liulingyu
 * @version 1.0
 * @date 2022-05-07 16:04
 */
public class ResultVOUtil {


    /**
     * <p>
     * 操作成功
     * </p>
     *
     * @param msg    提示信息
     * @param object 对象
     * @return com.hqully.labmanage.common.vo.ResultVO<T>
     * @date 2022/5/7 16:04 <br>
     * @author liulingyu <br>
     */
    public static <T> ResultVO<T> success(String msg, T object) {
        ResultVO<T> resultVO = new ResultVO<>();
        resultVO.setMsg(msg);
        resultVO.setCode(ResultEnum.SUCCESS.getCode());
        resultVO.setData(object);
        return resultVO;
    }

    /**
     * <p>
     * 操作成功
     * </p>
     *
     * @param object 对象
     * @return com.hqully.labmanage.common.vo.ResultVO<T>
     * @date 2022/5/7 16:04 <br>
     * @author liulingyu <br>
     */
    public static <T> ResultVO<T> success(T object) {
        String message = ResultEnum.SUCCESS.getMessage();
        return success(message, object);
    }


    /**
     * <p>
     * 操作成功，返回提示信息，不返回数据
     * </p>
     *
     * @param msg 提示信息
     * @return com.hqully.labmanage.common.vo.ResultVO<T>
     * @date 2022/5/7 16:05 <br>
     * @author liulingyu <br>
     */
    public static <T> ResultVO<T> success(String msg) {
        return success(msg, null);
    }

    /**
     * <p>
     * 操作成功，不返回数据
     * </p>
     *
     * @return com.hqully.labmanage.common.vo.ResultVO<T>
     * @date 2022/5/7 16:05 <br>
     * @author liulingyu <br>
     */
    public static ResultVO success() {
        return success(null);
    }


    /**
     * <p>
     * 操作有误
     * </p>
     *
     * @param code 错误码
     * @param msg  提示信息
     * @return com.hqully.labmanage.common.vo.ResultVO
     * @date 2022/5/7 16:06 <br>
     * @author liulingyu <br>
     */
    public static ResultVO error(Integer code, String msg) {
        ResultVO resultVO = new ResultVO();
        resultVO.setMsg(msg);
        resultVO.setCode(code);
        return resultVO;
    }

    public static ResultVO error(ResultEnum resultEnum) {
        ResultVO resultVO = new ResultVO();
        resultVO.setMsg(resultEnum.getMessage());
        resultVO.setCode(resultEnum.getCode());
        return resultVO;
    }


    /**
     * <p>
     * 操作有误，使用默认400错误码
     * </p>
     *
     * @param msg 提示信息
     * @return {@link ResultVO}
     * @date 2022/5/7 20:38 <br>
     * @author liulingyu <br>
     */
    public static ResultVO error(String msg) {
        Integer code = ResultEnum.ERROR.getCode();
        return error(code, msg);
    }

    /**
     * <p>
     * 操作有误，只返回错误码
     * </p>
     *
     * @param
     * @return {@link ResultVO}
     * @date 2022/5/7 20:38 <br>
     * @author liulingyu <br>
     */
    public static ResultVO error() {
        return error("");
    }

}
