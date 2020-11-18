package com.xtel.training.exe.newexe;

public class MainApplication {

    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<Integer> queueBuffer = new BlockingQueue<>();

        Producer producer = new Producer(queueBuffer);
        Consumer consumer = new Consumer(queueBuffer);

        producer.start();
        consumer.start();

        Thread.sleep(5000);
    }
}
