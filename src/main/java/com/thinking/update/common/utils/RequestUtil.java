package com.thinking.update.common.utils;

import javax.servlet.http.HttpServletRequest;

/**
 * @author hanlizhi
 * @create 2017-10-25 11:05
 */

public class RequestUtil {

    public static final String X_REQUESTED_WIDTH="X-Requested-With";
    public static final String XML_HTTP_REQUEST="XMLHttpRequest";

    public static boolean isAjaxRequest(HttpServletRequest request){
        String xr=request.getHeader(X_REQUESTED_WIDTH);
        return(xr!=null&&XML_HTTP_REQUEST.equalsIgnoreCase(xr));
    }
}
