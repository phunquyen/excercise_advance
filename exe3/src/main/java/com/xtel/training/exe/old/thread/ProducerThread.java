package com.xtel.training.exe.old.thread;

import com.xtel.training.exe.old.common.MessageQueue;

public class ProducerThread extends Thread {
    private MessageQueue msg;
    private int number;

    public ProducerThread(MessageQueue message, int number) {
        msg = message;
        this.number = number;
    }

    public void run() {
        for (int i = 0; i < 10; i++) {
            msg.put(i);
            System.out.println("Producer #" + this.number + " put: " + i);
            try {
                sleep((int)(Math.random() * 100));
            } catch (InterruptedException e) { }
        }
    }
}

