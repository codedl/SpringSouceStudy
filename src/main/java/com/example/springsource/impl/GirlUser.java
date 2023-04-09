package com.example.springsource.impl;

import com.example.springsource.service.UserIntface;

//@Component
public class GirlUser implements UserIntface {
    public String name = "GirlUser";
    @Override
    public String name() {
        return name;
    }

    public GirlUser() {
    }
}
