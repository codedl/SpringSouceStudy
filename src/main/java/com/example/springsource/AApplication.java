package com.example.springsource;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;

//@EnableTransactionManagement//开启事务
@EnableAspectJAutoProxy//开启aop
//@MapperScan(value = "com.example.springsource.mapper"/*annotationClass = MybatisDao.class*/)//mybatis
@tk.mybatis.spring.annotation.MapperScan("com.example.springsource.mapper")
@EnableAsync //创建线程池
@SpringBootApplication
@ServletComponentScan("com.example.springsource.nonblocking")
public class AApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext context =SpringApplication.run(AApplication.class, "name=leding","age=30");
        String[] names = context.getBeanDefinitionNames();
        for (String name : names){
//            System.out.println(name);
        }

    }

}
