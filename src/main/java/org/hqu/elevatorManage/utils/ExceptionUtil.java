package org.hqu.elevatorManage.utils;



import org.hqu.elevatorManage.common.exception.JWTException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * <p>
 *     异常处理工具类
 * </p>
 * @author liulingyu
 * @date 2022-05-07 15:44
 * @version 1.0
 */
public class ExceptionUtil {

    /**
     * <p>
     *     处理拦截器中的异常，将其转发给controller层再抛出，
     *     让异常能被全局异常处理器处理
     *
     * </p>
     * @date 2022/5/7 15:45 <br>
     * @author liulingyu <br>
     * @param request request
     * @param response response
     * @param exception 拦截器中的异常
     * @return void
     */
    public static void handleException(ServletRequest request, ServletResponse response
            , Exception exception) throws ServletException, IOException {

        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;


        if (exception instanceof JWTException){
            request.setAttribute("filter.jwtError", exception);
            try {
                httpServletRequest.getRequestDispatcher("/error/jwt").forward(request, response);
            } catch (ServletException | IOException e) {
                e.printStackTrace();
            }
        } else {
            exception.printStackTrace();
        }


    }



}
