package com.example.springsource.controller;

import org.json.JSONObject;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/person")
//@Scope(value = BeanDefinition.SCOPE_PROTOTYPE)
public class SingletonBeanController {


    private Map<String, String> map = new HashMap(){{
        put("man", "short hair, 180");
        put("woman", "long hair, big eye");
    }
    };

    private ThreadLocal<String> iSex = new ThreadLocal<>();
    @GetMapping("{sex}")
    String test(@PathVariable String sex){
        this.iSex.set(sex);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return map.get(iSex.get());
    }

    @GetMapping("/shop/{sex}")
    String sex(@PathVariable String sex){
        String iSex = sex;
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return map.get(iSex);
    }
}
