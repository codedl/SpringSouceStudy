package com.example.springsource.observer;

import com.example.springsource.observer.custom.Observer;
import com.example.springsource.observer.event.CustEvent;
import com.example.springsource.observer.util.JavaConcreteSubject;
import com.example.springsource.observer.util.JavaObserverA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("obs")
public class testController {
    @Autowired
    ApplicationContext context;

    @GetMapping("event/{str}")
    public void event(@PathVariable("str")  String str){
        context.publishEvent(new CustEvent(this,str));
    }

    @Autowired
    private List<Observer> observers;
    @GetMapping("impl/{str}")
    public void impl(@PathVariable("str")  String str){
        for (Observer observer : observers){
            observer.update(str);
        }
    }

    private JavaConcreteSubject subject = new JavaConcreteSubject();
    public testController(){
        subject.addObserver(new JavaObserverA());
    }
    @GetMapping("util/{str}")
    public void util(@PathVariable("str")  String str){
        subject.set(1);
    }
}
