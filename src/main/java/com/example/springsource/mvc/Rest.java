package com.example.springsource.mvc;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Rest {

    @RequestMapping(value = "/user",method = RequestMethod.GET)
    public String GET(){
        return "GET user";
    }

    @RequestMapping(value = "/user",method = RequestMethod.PUT)
    public String PUT(){
        return "PUT user";
    }

    @RequestMapping(value = "/user",method = RequestMethod.POST)
    public String POST(){
        return "POST user";
    }

    @RequestMapping(value = "/user",method = RequestMethod.DELETE)
    public String DELETE(){
        return "DELETE user";
    }
}
