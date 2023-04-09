package com.example.springsource.event;

import org.springframework.context.ApplicationEvent;

public class CustEvent extends ApplicationEvent  {

    public String msg;

    public CustEvent(Object source, String msg) {
        super(source);
        this.msg = msg;
    }
}
