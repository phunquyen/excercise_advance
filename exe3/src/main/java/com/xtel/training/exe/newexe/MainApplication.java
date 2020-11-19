package com.xtel.training.exe.newexe;

import org.apache.log4j.Logger;

import java.util.Scanner;

public class MainApplication {
    public static Logger logger = Logger.getLogger(MainApplication.class.getName());
    public static void main(String[] args) throws InterruptedException {
        logger.debug("Application is started ... !");
        Scanner sc = new Scanner(System.in);

        Producer producer = new Producer();
        producer.setName("Producer");
        Consumer consumer = new Consumer();
        consumer.setName("Consumer");

        producer.setConsumer(consumer);
        consumer.setProducer(producer);
        producer.start();
        Thread.sleep(100);
        consumer.start();

        String stop;
        do{
            stop = sc.nextLine();
        } while (!stop.equals("1"));
        BlockingQueue.killAllThread();
    }
}
