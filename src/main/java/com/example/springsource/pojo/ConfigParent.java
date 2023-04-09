package com.example.springsource.pojo;

import org.springframework.context.annotation.Bean;

public class ConfigParent {
    public class ConfigParentUser{

    }

    @Bean
    public ConfigParentUser ConfigParentUser1(){
        return new ConfigParentUser();
    }
}
