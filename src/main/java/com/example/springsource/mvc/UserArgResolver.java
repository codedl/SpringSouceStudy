package com.example.springsource.mvc;

import com.example.springsource.pojo.User;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Component
public class UserArgResolver implements HandlerMethodArgumentResolver, InitializingBean {
    @Autowired
    RequestMappingHandlerAdapter adapter;

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        if(parameter.getParameterType().isAssignableFrom(User.class)){
            System.out.println("要解析的参数:"+parameter.getParameterName());
            return true;
        }
        return false;
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        User user = new User();

        HttpServletRequest nativeRequest = (HttpServletRequest)webRequest.getNativeRequest();
        user.setName("我是"+nativeRequest.getParameter("name"));
        user.setAge(Integer.valueOf(nativeRequest.getParameter("age")));

        System.out.println("开始解析参数");
        return user;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        List<HandlerMethodArgumentResolver> argumentResolvers = new ArrayList<>();
        argumentResolvers.addAll(adapter.getArgumentResolvers());
        argumentResolvers.add(UserArgResolver.this);
//        adapter.setArgumentResolvers(argumentResolvers);
    }
}
