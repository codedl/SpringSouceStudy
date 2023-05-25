package com.example.springsource.mvc;

import com.example.springsource.pojo.User;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.task.AsyncTaskExecutor;
import org.springframework.format.FormatterRegistry;
import org.springframework.scheduling.concurrent.ConcurrentTaskExecutor;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.AsyncSupportConfigurer;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;
import java.util.concurrent.Executors;

@Configuration
public class WebConfig  implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new Interceptor())
                .addPathPatterns("/pojo")
                .excludePathPatterns("/user");
    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
        resolvers.add(new UserArgResolver());
    }

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new Converter<String, User.Pet>() {
            @Override
            public User.Pet convert(String source) {
                User.Pet pet = new User.Pet();
                pet.setName(source.split(",")[0]);
                pet.setColor(source.split(",")[1]);
                return pet;
            }
        });
    }


    @Override
    public void configureAsyncSupport(AsyncSupportConfigurer configurer) {
        configurer.setDefaultTimeout(5000);
        AsyncTaskExecutor executor =new ConcurrentTaskExecutor(Executors.newFixedThreadPool(5));
        configurer.setTaskExecutor(executor);
    }


}
