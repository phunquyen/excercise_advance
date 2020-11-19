package com.xtel.training.exe.newexe;

public class Consumer extends BlockingQueue {
    public Producer producer;

    protected void doSomething() throws Exception {
        logger.info("take from queue");
        take();
        System.out.println("Consumed - Queue size() = " + size());
        producer.notifyMe();
    }

    public void setProducer(Producer producer) {
        this.producer = producer;
    }
}
