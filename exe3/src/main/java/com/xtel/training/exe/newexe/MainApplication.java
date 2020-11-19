package com.xtel.training.exe.newexe;

public class MainApplication {

    public static void main(String[] args) throws InterruptedException {

        Producer producer = new Producer();
        producer.setName("Producer");
        Consumer consumer = new Consumer();
        consumer.setName("Consumer");
        producer.start();
        consumer.start();

        Thread.sleep(5000);
    }
}
