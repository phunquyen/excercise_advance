package com.xtel.training.exe.common;

import org.apache.log4j.Logger;

public class MessageQueue {
    Logger logger = Logger.getLogger(MessageQueue.class);

    private int content;
    private boolean available = false;

    public synchronized int get() {
        while (available == false) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
                logger.error(e);
            }
        }
        available = false;
        notifyAll();
        return content;
    }

    public synchronized void put (int value) {
        while (available == true) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
                logger.error(e);
            }
        }
        content = value;
        available = true;
        notifyAll();
    }
}
