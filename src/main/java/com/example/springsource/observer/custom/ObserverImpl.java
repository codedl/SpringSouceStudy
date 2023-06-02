package com.example.springsource.observer.custom;

import org.springframework.stereotype.Component;

@Component
public class ObserverImpl implements Observer{
    private Object str;
    @Override
    public void update(Object o) {
        this.str = o;
        System.out.println(this.str);
    }
}
