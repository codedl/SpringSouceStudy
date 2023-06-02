package com.example.springsource.observer.util;

import java.util.Observable;
import java.util.Observer;

/**
 * 观察者模式：观察者(消息订阅者)
 * 实现Observer接口
 * @author dengp
 *
 */
public class JavaObserverA implements Observer {

    private int myState;
    @Override
    public void update(Observable o, Object arg) {
        myState = ((JavaConcreteSubject)o).getState();
        System.out.println(myState);
    }
}
