package com.base.javabase.proxy;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created on 2019-06-12
 * @author fenghongyu
 */
public class ReflectService {
    public void sayHello(String name){
        System.out.println("name:" + name);
    }

    public static void main(String[] args) throws ClassNotFoundException,
            IllegalAccessException, InstantiationException,
            NoSuchMethodException, InvocationTargetException {
        Object service = Class.forName(ReflectService.class.getName()).newInstance();
        Method method = service.getClass().getMethod("sayHello", String.class);
        method.invoke(service, "tangyuan");
    }
}
