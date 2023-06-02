package com.example.springsource.mvc;

import com.example.springsource.nonblocking.ServerServlet;
import com.example.springsource.pojo.User;
import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.boot.autoconfigure.task.TaskExecutionAutoConfiguration;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.task.AsyncTaskExecutor;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.format.FormatterRegistry;
import org.springframework.scheduling.concurrent.ConcurrentTaskExecutor;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.AsyncSupportConfigurer;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;
import java.util.Map;
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


    @Bean(TaskExecutionAutoConfiguration.APPLICATION_TASK_EXECUTOR_BEAN_NAME)
    public AsyncTaskExecutor asyncTaskExecutor(){
        return new SimpleAsyncTaskExecutor("mvc async:");
    }

    @Bean
    public ServletRegistrationBean serverServlet() {
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean();
        servletRegistrationBean.setServlet(new ServerServlet());
        servletRegistrationBean.addUrlMappings("/server");
        servletRegistrationBean.setAsyncSupported(true);
        return servletRegistrationBean;
    }

/*    @Override
    public void configureAsyncSupport(AsyncSupportConfigurer configurer) {
        configurer.setDefaultTimeout(5000);
        AsyncTaskExecutor executor =new ConcurrentTaskExecutor(Executors.newFixedThreadPool(5));
        configurer.setTaskExecutor(executor);
    }*/


}
