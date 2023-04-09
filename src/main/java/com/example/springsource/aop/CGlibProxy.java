package com.example.springsource.aop;

import org.springframework.cglib.core.DebuggingClassWriter;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CGlibProxy {
    public static void main(String[] args) throws Exception {
        String location = CGlibProxy.class.getResource("").getPath().replaceAll("%20"," ") + "debugging/";
        System.out.println("location -> " + location);
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, location);
        HouseOwner houseOwner = new HouseOwner();
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(HouseOwner.class);
        enhancer.setInterfaces(new Class[]{Owner.class});
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object obj, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                Object result;
                System.out.println("Before invoking hello...");
                result = methodProxy.invokeSuper(obj, objects);
                result = methodProxy.invoke(houseOwner, objects);
                System.out.println("After invoking hello...");
                return result;
            }
        });
//        Demo sampleClass = (Demo) enhancer.create();
        Owner owner = (Owner) enhancer.create();
        HouseOwner houseOwn = (HouseOwner) enhancer.create();
        owner.rent();
        houseOwn.rent();
    }
}
