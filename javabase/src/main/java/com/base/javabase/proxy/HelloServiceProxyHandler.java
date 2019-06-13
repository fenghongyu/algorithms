package com.base.javabase.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created on 2019-06-12
 * @author fenghongyu
 */
public class HelloServiceProxyHandler implements InvocationHandler {
    private Object target;

    public Object bind(Object target){
        this.target = target;
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }

    /**
     * 通过代理对象调用方法，首先进入这个方法
     * @param proxy  代理对象
     * @param method 被调用方法
     * @param args  方法参数
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("###JDK动态代理启动，即将调用代理方法");
        String result = (String) method.invoke(target, args);
        System.out.println("###JDK动态代理完成");
        return result;
    }
}
