package com.xtel.training.exe.newexe;

import java.util.Random;

public class Producer extends BlockingQueue {
    final Random rd = new Random();
    public Consumer consumer;

    protected void doSomething() throws Exception {
        logger.info("put to queue");
        put(rd.nextInt(10));
        System.out.println("Produced - Queue size() = "  + size());
        consumer.notifyMe();
    }

    public void setConsumer(Consumer consumer) {
        this.consumer = consumer;
    }
}