package com.xtel.training.exe;

import com.xtel.training.exe.common.MessageQueue;
import com.xtel.training.exe.thread.ConsumerThread;
import com.xtel.training.exe.thread.ProducerThread;


public class MainApplication {
    public static void main(String[] args) {
        MessageQueue message = new MessageQueue();
        ProducerThread tProducer = new ProducerThread(message,1);
        ConsumerThread tConsumer = new ConsumerThread(message, 1);
        tProducer.start();
        tConsumer.start();
    }
}
