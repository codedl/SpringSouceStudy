package com.example.springsource.pojo;

import com.example.springsource.service.UserIntface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class AutowiredUser {

    public AutowiredUser() {
    }

    public String name = "AutowiredUser";
    /*@Autowired
    ComponentUser componentUser;
    @Resource(name = "resourceUser")
    ResourceUser resourceUser;
    @Autowired
    @Qualifier("qualifierUser")
    QualifierUser qualifierUser;

    @Value("${server.name}")
    String serverName;*/

    @Autowired
    @Qualifier("manUser")
    UserIntface userIntface;


    @Override
    public String toString() {
        return "AutowiredUser{" +
                "name='" + name + '\'' +
                /*", componentUser=" + componentUser +
                ", resourceUser=" + resourceUser +
                ", qualifierUser=" + qualifierUser +
                ", serverName='" + serverName + '\'' +*/
                ", userIntface=" + userIntface.name() +
                '}';
    }
}
