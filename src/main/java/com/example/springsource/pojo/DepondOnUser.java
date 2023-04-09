package com.example.springsource.pojo;

import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;

@Component
//@DependsOn("componentUser")
public class DepondOnUser {
    public String name = "DepondOnUser";
}
