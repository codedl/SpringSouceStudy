package com.example.springsource.bean;

import org.springframework.stereotype.Component;

@Component
public class ParentBean {
    String parentName = "ParentBean";

    @Override
    public String toString() {
        return "ParentBean{" +
                "parentName='" + parentName + '\'' +
                '}';
    }
}
