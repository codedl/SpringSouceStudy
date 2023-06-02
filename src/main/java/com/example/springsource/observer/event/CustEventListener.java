package com.example.springsource.observer.event;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class CustEventListener {

    @EventListener()
    public void eventListen(ApplicationEvent applicationEvent){
        if(applicationEvent instanceof CustEvent){
            CustEvent custEvent = (CustEvent)applicationEvent;
            System.out.println(custEvent.msg);
        }
    }
}
