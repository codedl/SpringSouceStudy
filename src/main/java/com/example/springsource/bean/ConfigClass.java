package com.example.springsource.bean;

import com.example.springsource.impl.GirlUser;
import com.example.springsource.impl.ManUser;
import com.example.springsource.pojo.BeanUser;
import com.example.springsource.pojo.ConfigParent;
import com.example.springsource.pojo.StaticUser;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration
public class ConfigClass extends ConfigParent {

    @Bean
    public BeanUser beanUser(){
        return new BeanUser();
    }

    @Bean
    public StaticUser staticUser(){
        return new StaticUser();
    }

    @Bean
    public ManUser createManUser(){
        return new ManUser();
    }

    @Qualifier("manUser")
    @Bean
    public GirlUser createGirlUser(){
        return new GirlUser();
    }
    @Bean
    public BeanUser createBeanUser(){
        return new BeanUser();
    }

    @Bean
    public DataSourceTransactionManager dataSourceTransactionManager(DataSource dataSource){
        return new DataSourceTransactionManager(dataSource);
    }
}
