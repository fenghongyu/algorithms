package com.base.javabase.base;

import lombok.Data;

/**
 * @CLASSNAME:
 * @AUTHOR: fenghongyu
 * @TIME: 2020/6/2 10:53
 */
@Data
public class Person implements Cloneable{
    private PersonInfo personInfo;
    private int age;
    private Integer num;

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
