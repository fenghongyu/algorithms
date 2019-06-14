package com.base.javabase.concurrent.pipestreamdemo;

import java.io.IOException;
import java.io.PipedInputStream;

/**
 * Created on 2019-06-05
 * @author fenghongyu
 */
public class Receiver extends Thread {

    private PipedInputStream pipedInputStream = new PipedInputStream();

    public PipedInputStream getPipedInputStream() {
        return pipedInputStream;
    }

    public void run(){
        byte[] buf = new byte[1024];

        try {

            int len = pipedInputStream.read(buf);

            System.out.println("receive message from sender : " + new String(buf, 0, len));
            pipedInputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
