package com.example.springsource.pojo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@DependsOn({"depondOnUser"})
public class ComponentUser  {
    @Autowired
    DepondOnUser depondOnUser;

    public String name = "ComponentUser";

    @PostConstruct
    public void init(){
        System.out.println("初始化...");
    }

    @Override
    public String toString() {
        return "ComponentUser{" +
                ", depondOnUser=" + depondOnUser.name +
                ", name='" + name + '\'' +
                '}';
    }
}
