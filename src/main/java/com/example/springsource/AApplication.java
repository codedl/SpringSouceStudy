package com.example.springsource;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;

//@EnableTransactionManagement//开启事务
@EnableAspectJAutoProxy//开启aop
@MapperScan(value = "com.example.springsource.mapper"/*annotationClass = MybatisDao.class*/)//mybatis
@EnableAsync //创建线程池
@SpringBootApplication
public class AApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext context =SpringApplication.run(AApplication.class, "name=leding","age=30");
        String[] names = context.getBeanDefinitionNames();
        Object o1 = context.getBean("&factoryClass");
        Object o2 = context.getBean("factoryClass");
        for (String name : names){
//            System.out.println(name);
        }

    }

}
