package com.base.javabase.proxy;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

/**
 * Created on 2019-06-12
 * @author fenghongyu
 */
public class HelloServiceCglib implements MethodInterceptor {

    private Object target;

    public Object getInstance(Object target){
        this.target = target;
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(this.target.getClass());
        //回调方法
        enhancer.setCallback(this);
        //创建代理对象
        return enhancer.create();
    }

    @Override
    public Object intercept(Object object, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("###Cglib动态代理启动，即将调用代理方法");
        String result = (String) methodProxy.invokeSuper(object, objects);
        System.out.println("###Cglib动态代理完成");
        return result;
    }
}
