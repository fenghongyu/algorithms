package com.base.javabase.proxy;

/**
 * Created on 2019-06-12
 * @author fenghongyu
 */
public class HelloServiceMain {
    public static void main(String[] args) {
        HelloServiceProxyHandler proxyHandler = new HelloServiceProxyHandler();
        HelloService proxy = (HelloService) proxyHandler.bind(new HelloServiceImpl());
        proxy.sayHello("你好啊");
        proxy.speakGood();
    }
}
