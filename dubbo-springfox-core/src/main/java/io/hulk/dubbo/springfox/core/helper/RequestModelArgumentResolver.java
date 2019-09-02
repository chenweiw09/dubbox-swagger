package io.hulk.dubbo.springfox.core.helper;

import com.alibaba.fastjson.JSON;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import java.lang.reflect.Type;

/**
 * springmvc自定义参数注解解析器
 *
 * 原有定义的参数解析器，对于@requestBody不能接收到参数，这里需要自己重新定义一下参数解析器
 */
public class RequestModelArgumentResolver implements HandlerMethodArgumentResolver {
    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.hasParameterAnnotation(RequestBody.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
                                  NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        final String parameterJson = webRequest.getParameter(parameter.getParameterName());

        final Type type = parameter.getGenericParameterType();
        final Object o = JSON.parseObject(parameterJson, type);
        return o;
    }
}
