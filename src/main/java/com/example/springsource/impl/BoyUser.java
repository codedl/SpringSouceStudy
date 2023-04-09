package com.example.springsource.impl;

import com.example.springsource.service.UserIntface;

//@Component
public class BoyUser implements UserIntface {
    public String name = "BoyUser";

    @Override
    public String name() {
        return name;
    }
}
