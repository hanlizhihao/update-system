package com.thinking.update;

import com.changjiang.common.exception.BDException;
import com.changjiang.common.utils.R;
import com.changjiang.common.utils.RequestUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author hanlizhi
 * @create 2017-10-25 11:03
 */
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    public static final String DEFAULT_ERROR_VIEW = "error";

    @ExceptionHandler(value = Exception.class)
    public ModelAndView defaultErrorHandler(HttpServletRequest req, HttpServletResponse response, Exception e) throws Exception {
        if (RequestUtil.isAjaxRequest(req)) {
            try {
                log.error("ajax error",e);
                PrintWriter writer = response.getWriter();
                writer.write(e.getMessage());
                writer.flush();
            } catch (IOException ex) {
                log.error("GlobalExceptionHandler PrintWriter",ex);
            }
            return new ModelAndView();
        } else {
            ModelAndView mav = new ModelAndView();
            mav.addObject("exception", e);
            mav.addObject("url", req.getRequestURL().toString());
            mav.setViewName(DEFAULT_ERROR_VIEW);
            return mav;
        }

    }
    /**
     * 自定义异常
     */
    @ExceptionHandler(BDException.class)
    public R handleBDException(BDException e) {
        R r = new R();
        r.put("code", e.getCode());
        r.put("msg", e.getMessage());

        return r;
    }

    @ExceptionHandler(DuplicateKeyException.class)
    public R handleDuplicateKeyException(DuplicateKeyException e) {
        log.error(e.getMessage(), e);
        return R.error("数据库中已存在该记录");
    }

    @ExceptionHandler(org.springframework.web.servlet.NoHandlerFoundException.class)
    public R NoHandlerFoundException(org.springframework.web.servlet.NoHandlerFoundException e) {
        log.error(e.getMessage(), e);
        return R.error("没找找到页面");
    }

//	@ExceptionHandler()
//	public String handleAuthorizationException(Exception e) {
//		logger.error(e.getMessage(), e);
//		return "error/403";
//	}

//    @ExceptionHandler(Exception.class)
//    public String handleException(Exception e) {
//        log.error(e.getMessage(), e);
//        return "error/500";
//    }
}
