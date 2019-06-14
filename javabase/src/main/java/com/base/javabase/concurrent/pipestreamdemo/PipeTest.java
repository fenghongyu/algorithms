package com.base.javabase.concurrent.pipestreamdemo;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/**
 * Created on 2019-06-05
 * @author fenghongyu
 */
public class PipeTest {

    public static void main(String[] args) {
        Sender sender = new Sender();
        Receiver receiver = new Receiver();
        PipedOutputStream outputStream = sender.getPipedOutputStream();
        PipedInputStream inputStream = receiver.getPipedInputStream();

        try {
            inputStream.connect(outputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

        sender.start();
        receiver.start();
    }
}
