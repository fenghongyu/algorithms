package com.base.javabase.base;

import java.util.Date;

/**
 * Created on 2019-09-10
 *
 * @author fenghongyu
 */
public class Test extends Date {
    public static void main(String[] args) {
        new Test().test();
    }

    public void test() {
        System.out.println(super.getClass().getName());
    }
}
