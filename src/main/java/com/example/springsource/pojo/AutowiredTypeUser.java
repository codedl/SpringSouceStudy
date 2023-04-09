package com.example.springsource.pojo;

import org.springframework.stereotype.Component;

@Component
public class AutowiredTypeUser {
    public String name = "AutowiredUser";
    ComponentUser componentUser;

    @Override
    public String toString() {
        return "AutowiredTypeUser{" +
                "name='" + name + '\'' +
                "componentUser=" + componentUser +
                '}';
    }

    public ComponentUser getComponentUser() {
        return componentUser;
    }

    public void setComponentUser(ComponentUser componentUser) {
        this.componentUser = componentUser;
    }

}
