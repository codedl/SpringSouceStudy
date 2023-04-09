package com.example.springsource.impl;

import com.example.springsource.service.UserIntface;

//@Component
public class ManUser implements UserIntface {
    public String name = "ManUser";
    @Override
    public String name() {
        return name;
    }
}
