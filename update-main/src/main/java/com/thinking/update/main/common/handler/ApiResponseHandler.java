package com.thinking.update.main.common.handler;

import org.springframework.core.MethodParameter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.springframework.web.servlet.mvc.method.annotation.AbstractMessageConverterMethodProcessor;

import java.util.List;

/**
 * @author Administrator
 * api返回结果统一转换包装
 * @create 2018/5/27
 */
public class ApiResponseHandler extends AbstractMessageConverterMethodProcessor {

    public ApiResponseHandler(List<HttpMessageConverter<?>> converters) {
        super(converters);
    }

    @Override
    public boolean supportsParameter(MethodParameter methodParameter) {
        return false;
    }

    @Override
    public Object resolveArgument(MethodParameter methodParameter, ModelAndViewContainer modelAndViewContainer, NativeWebRequest nativeWebRequest, WebDataBinderFactory webDataBinderFactory) throws Exception {
        return null;
    }

    @Override
    public boolean supportsReturnType(MethodParameter methodParameter) {
        return null != methodParameter.getContainingClass().getAnnotation(RestController.class)
                && !ApiResult.class.isInstance(methodParameter.getParameterType());
    }

    @Override
    public void handleReturnValue(Object o, MethodParameter methodParameter, ModelAndViewContainer modelAndViewContainer, NativeWebRequest nativeWebRequest) throws Exception {
        modelAndViewContainer.setRequestHandled(true);
        this.writeWithMessageConverters(new ApiResult(o), methodParameter, nativeWebRequest);
    }
}
