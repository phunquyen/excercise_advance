package com.xtel.training.exe.newexe;

import org.apache.log4j.Logger;

public class Consumer extends BlockingQueue {
    Consumer consumer;
    public void run() {
        try {
            while (true) {
                logger.info("take from queue");
                take();
                System.out.println("Consumed - Queue size() = " + size());
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
