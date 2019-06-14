package com.base.javabase.concurrent.pipestreamdemo;

import java.io.IOException;
import java.io.PipedOutputStream;

/**
 * Created on 2019-06-05
 * @author fenghongyu
 */
public class Sender extends Thread {
    private PipedOutputStream pipedOutputStream = new PipedOutputStream();

    public PipedOutputStream getPipedOutputStream() {
        return pipedOutputStream;
    }

    public void run(){
        try {
            pipedOutputStream.write("Sender outputStream".getBytes());
            pipedOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
