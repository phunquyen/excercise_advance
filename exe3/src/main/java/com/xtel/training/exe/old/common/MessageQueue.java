package com.xtel.training.exe.old.common;

import org.apache.log4j.Logger;

import java.util.LinkedList;

public class MessageQueue<T> {
    Logger logger = Logger.getLogger(MessageQueue.class);

    private LinkedList<T> content = new LinkedList<T>();
    private boolean available = false;

    public synchronized T get() {
        while (!available ) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
                logger.error(e);
            }
        }
        available = false;
        notifyAll();
        return content.getLast();
    }

    public synchronized void put (T value) {
        while (available) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
                logger.error(e);
            }
        }
        content.addFirst(value);
        available = true;
        notifyAll();
    }
}
