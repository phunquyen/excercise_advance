package com.xtel.training.exe.newexe;

import org.apache.log4j.Logger;

public class Consumer extends Thread {
    Logger logger = Logger.getLogger(Consumer.class);
    private final BlockingQueue<Integer> queue;

    Consumer(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }
    public void run() {
        try {
            while (true) {
                logger.info("take from queue");
                queue.take();
                System.out.println("Consumed - Queue size() = " + queue.size());
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
