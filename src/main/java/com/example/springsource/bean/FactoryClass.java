package com.example.springsource.bean;

import com.example.springsource.pojo.FactoryUser;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

@Component
public class FactoryClass implements FactoryBean {
    @Override
    public Object getObject() throws Exception {
        return new FactoryUser();
    }

    @Override
    public Class<?> getObjectType() {
        return FactoryUser.class;
    }
}
