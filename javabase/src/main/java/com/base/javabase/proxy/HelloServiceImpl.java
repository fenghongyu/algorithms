package com.base.javabase.proxy;

/**
 * Created on 2019-06-12
 * @author fenghongyu
 */
public class HelloServiceImpl implements HelloService {
    @Override
    public void sayHello(String name) {
        System.out.println("name:" + name);
    }

    @Override
    public void speakGood() {
        System.out.println("你很棒");
    }
}
