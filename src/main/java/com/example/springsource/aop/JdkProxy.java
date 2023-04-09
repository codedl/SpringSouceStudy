package com.example.springsource.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

interface Owner{
    void rent();
}
class HouseOwner implements Owner{
    @Override
    public void rent() {
        System.out.println("租房完成");
    }

}
class Intermediary implements InvocationHandler{
    private Owner target;

    public Intermediary(Owner target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("找房....");
        //通过反射执行目标方法
        Object result = method.invoke(target, args);
        System.out.println("收房租....");
        return result;
    }
}

public class JdkProxy {

    public static void main(String[] args) {
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        HouseOwner houseOwner = new HouseOwner();
        Owner owner = (Owner) Proxy.newProxyInstance(houseOwner.getClass().getClassLoader(),
                                                     houseOwner.getClass().getInterfaces(),
                                                     new Intermediary(houseOwner));
        owner.rent();
    }

}
