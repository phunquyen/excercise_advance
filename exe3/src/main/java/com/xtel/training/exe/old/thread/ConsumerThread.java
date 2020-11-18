package com.xtel.training.exe.old.thread;

import com.xtel.training.exe.old.common.MessageQueue;

public class ConsumerThread extends Thread {
    private MessageQueue msg;
    private int number;
    public ConsumerThread(MessageQueue c, int number) {
        msg = c;
        this.number = number;
    }
    public void run() {
        int value = 0;
        for (int i = 0; i < 10; i++) {
//            value = msg.get();
            System.out.println("Consumer #" + this.number + " got: " + value);
        }
    }
}