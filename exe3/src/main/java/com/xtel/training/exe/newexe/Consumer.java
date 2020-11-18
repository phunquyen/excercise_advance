package com.xtel.training.exe.newexe;

public class Consumer implements Runnable{
    MessageQueue messageQueue;

    public Consumer(MessageQueue messageQueue) {
        this.messageQueue = messageQueue;
    }

    public void run() {
        try {
            messageQueue.retrieve();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
