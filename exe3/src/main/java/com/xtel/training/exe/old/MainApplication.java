package com.xtel.training.exe.old;

import com.xtel.training.exe.old.common.MessageQueue;
import com.xtel.training.exe.old.thread.ConsumerThread;
import com.xtel.training.exe.old.thread.ProducerThread;


public class MainApplication {
    public static void main(String[] args) {
        MessageQueue message = new MessageQueue();
        ProducerThread tProducer = new ProducerThread(message,1);
        ConsumerThread tConsumer = new ConsumerThread(message, 1);
        tProducer.start();
        tConsumer.start();
    }
}
