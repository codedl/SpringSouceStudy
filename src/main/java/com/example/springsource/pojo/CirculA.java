package com.example.springsource.pojo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CirculA {
    public String name = "CirculA";
    @Autowired
    CirculB circulB;

//    public CirculA(CirculB circulB){
//
//    }

    @Override
    public String toString() {
        return "CirculA{" +
                "name='" + name + '\'' +
                circulB.name +
                '}';
    }
}
