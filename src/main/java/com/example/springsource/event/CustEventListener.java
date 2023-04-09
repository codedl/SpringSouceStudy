package com.example.springsource.event;

import org.springframework.context.ApplicationEvent;
import org.springframework.stereotype.Component;

@Component
public class CustEventListener {

//    @EventListener()
    public void eventListen(ApplicationEvent applicationEvent){
//        System.out.println(applicationEvent.getTimestamp());
//        System.out.println(applicationEvent.getSource());
        if(applicationEvent instanceof CustEvent){
            CustEvent custEvent = (CustEvent)applicationEvent;
            System.out.println(custEvent.msg);
        }
    }
}
