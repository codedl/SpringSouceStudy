package com.example.springsource.pojo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CirculB {
    public String name = "CirculB";
    @Autowired
    CirculA circulA;

//    public CirculB(CirculA circulA){
//
//    }

    @Override
    public String toString() {
        return "CirculB{" +
                "name='" + name + '\'' +
                circulA.name +
                '}';
    }
}
