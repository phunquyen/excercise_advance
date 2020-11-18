package com.xtel.training.exe.newexe;

public class Producer implements Runnable{MessageQueue messageQueue;
    String emailMessageContent;

    public Producer(String message, MessageQueue messageQueue) {
        emailMessageContent = message;
        this.messageQueue = messageQueue;
    }

    public void run() {
        try {
            messageQueue.adds(emailMessageContent);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }
    }
}
