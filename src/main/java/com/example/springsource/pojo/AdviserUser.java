package com.example.springsource.pojo;

import org.springframework.stereotype.Component;

@Component
public class AdviserUser {
    public String name = "AdviserUser";

    public int div(int a, int b){
        return a / b;
    }
}
