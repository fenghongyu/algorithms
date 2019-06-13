package com.base.javabase.proxy;

/**
 * Created on 2019-06-12
 * @author fenghongyu
 */
public class HelloServiceCglibMain {
    public static void main(String[] args) {
        HelloServiceCglib cglib = new HelloServiceCglib();
        HelloServiceImpl service = (HelloServiceImpl) cglib.getInstance(new HelloServiceImpl());
        service.sayHello("cglib tangyuan");
        service.speakGood();
    }
}
