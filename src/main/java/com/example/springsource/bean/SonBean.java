package com.example.springsource.bean;

import org.springframework.stereotype.Component;

@Component
public class SonBean extends ParentBean{
    String sonName = "SonBean";

    @Override
    public String toString() {
        return "SonBean{" +
                "sonName='" + sonName + '\'' +
                '}'+ super.toString();
    }
}
