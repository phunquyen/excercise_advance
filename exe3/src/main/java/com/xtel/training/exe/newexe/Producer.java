package com.xtel.training.exe.newexe;

import org.apache.log4j.Logger;

import java.util.concurrent.ThreadLocalRandom;

public class Producer extends BlockingQueue {
    public void run() {
        try {
            while (true) {
                logger.info("put to queue");
                queue.put(produce());
                System.out.println("Produced - Queue size() = "  + queue.size());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private Integer produce() throws InterruptedException {
        Thread.sleep(100);
        return ThreadLocalRandom.current().nextInt(1, 10);
    }
}