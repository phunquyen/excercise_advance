package com.xtel.training.exe.newexe;

public class MainApplication {

    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<Integer> queueBuffer = new BlockingQueue<>();

        Producer producer = new Producer(queueBuffer);
        Consumer consumer1 = new Consumer(queueBuffer);
        Consumer consumer2 = new Consumer(queueBuffer);
        Consumer consumer3 = new Consumer(queueBuffer);

        producer.start();
        consumer1.start();
        consumer2.start();
        consumer3.start();

        Thread.sleep(5000);
        Consumer consumer4 = new Consumer(queueBuffer);
        consumer4.start();
    }
}
