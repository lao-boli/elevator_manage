package org.hqu.elevatorManage.common.exception;


import lombok.extern.slf4j.Slf4j;
import org.hqu.elevatorManage.common.exception.advice.ResultExceptionAdvice;
import org.hqu.elevatorManage.domain.vo.ResultVO;
import org.hqu.elevatorManage.utils.ResultVOUtil;
import org.hqu.elevatorManage.utils.SpringContextUtil;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>全局统一异常处理</p>
 *
 * @author liulingyu
 * @version 1.0
 * @date 2022-05-07 15:41
 */
@RestControllerAdvice(annotations = {RestController.class})
@Slf4j
public class ResultExceptionHandler {


    /**
     * <p>
     * 拦截自定义结果异常
     * </p>
     *
     * @param e 异常
     * @return com.hqully.labmanage.common.vo.ResultVo
     * @date 2022/5/7 19:28 <br>
     * @author liulingyu <br>
     */
    @ExceptionHandler(ResultException.class)
    @ResponseBody
    public ResultVO resultException(ResultException e) {
        return ResultVOUtil.error(e.getCode(), e.getMessage());
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseBody
    public ResultVO paramException(HttpMessageNotReadableException e) {
        return ResultVOUtil.error("参数异常");
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public ResultVO MethodNotAllowedException(MethodArgumentNotValidException e) {
        StringBuilder sb = new StringBuilder();
        List<ObjectError> allErrors = e.getBindingResult().getAllErrors();

        for (ObjectError error : allErrors) {
            sb.append(error.getDefaultMessage())
              .append("<br/>");
        }
        return ResultVOUtil.error(4000, sb.toString());
    }

    /**
     * <p>
     * 拦截JWT相关异常
     * </p>
     *
     * @param e JWT异常
     * @return com.hqully.labmanage.common.vo.ResultVo
     * @date 2022/5/7 19:29 <br>
     * @author liulingyu <br>
     */
    @ExceptionHandler(JWTException.class)
    @ResponseBody
    public ResultVO JWTException(JWTException e) {
        return ResultVOUtil.error(e.getCode(), e.getMessage());
    }

    /** 拦截未知的运行时异常 */
    /**
     * <p>
     * 拦截未知的运行时异常
     * </p>
     *
     * @param e 未知异常
     * @return {@link ResultVO}
     * @date 2022/5/7 19:31 <br>
     * @author liulingyu <br>
     */
    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public ResultVO runtimeException(RuntimeException e) {
        ResultExceptionAdvice resultExceptionAdvice = SpringContextUtil.getBean(ResultExceptionAdvice.class);
        resultExceptionAdvice.runtimeException(e);
        log.error("【系统异常】", e);
        return ResultVOUtil.error(500, "未知错误：EX4399");
    }

}
