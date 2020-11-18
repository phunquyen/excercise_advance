package com.xtel.training.exe.newexe;

import org.apache.log4j.Logger;

import java.util.LinkedList;

public class BlockingQueue<T> {
    Logger logger = Logger.getLogger(BlockingQueue.class);
    private static final int capacity = 10;
    private final LinkedList<T> items = new LinkedList<>();
    private final Object putLock = new Object();
    private final Object takeLock = new Object();

    public void put(T value) throws InterruptedException {
        while(items.size() == capacity){
            logger.warn("Queue is full");
            synchronized (putLock){
                putLock.wait();
            }
        }
        items.addFirst(value);
        synchronized (takeLock){
            takeLock.notifyAll();
        }
    }

    public T take() throws InterruptedException {
        if(items.isEmpty()){
            logger.warn("Queue is empty");
            synchronized (takeLock){
                takeLock.wait();
            }
        }
//        T value = items.getLast();
        T value = items.removeLast();

        synchronized (putLock){
            putLock.notifyAll();
        }
        return value;
    }

    public synchronized int size() {
        return items.size();
    }
}