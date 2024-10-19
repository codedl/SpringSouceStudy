package com.example.springsource.controller;

import com.example.springsource.observer.event.CustEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.*;
import com.example.springsource.pojo.AdviserUser;
import com.example.springsource.pojo.AutowiredTypeUser;
import com.example.springsource.pojo.BeanUser;
import com.example.springsource.pojo.StaticUser;

import java.util.HashMap;
import java.util.StringJoiner;

@RestController
public class AutowiredController {
    @Autowired
    ApplicationContext context;
    @Autowired
    BeanUser beanUser;
    @Autowired
    StaticUser staticUser;

    @Autowired
    AutowiredTypeUser autowiredTypeUser;

    @Autowired
    AdviserUser adviserUser;

    @Value("${server.name}")
    String serverName;

    public AutowiredController() {
    }

    @GetMapping
    public String test(){
        return "test";
    }

    @RequestMapping("serverName")
    public String serverName(){
        return serverName;
    }

    @RequestMapping("div/{arg1}/{arg2}")
    public int controllerDiv(@PathVariable("arg1") int arg1,@PathVariable("arg2") int arg2){
        return adviserUser.div(arg1,arg2);
    }

    @RequestMapping(value = "res")
    public ResponseResult getResult(){
        ResponseResult responseResult = new ResponseResult();
        HashMap<Object, Object> objectObjectHashMap = new HashMap<>();
        objectObjectHashMap.put("serval",true);
        responseResult.setValue(objectObjectHashMap);
        return responseResult;
    }




    @RequestMapping("test")
    public String hello(){
        StringJoiner str = new StringJoiner("###\n");
//            str.add(beanUser.toString());
//            str.add(staticUser.toString());
        str.add(autowiredTypeUser.toString());
        return str.toString();
    }

}
