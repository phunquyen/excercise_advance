package com.xtel.training.exe.demo;

import java.util.LinkedList;

public class MyQueue<T> {
    private LinkedList<T> linkedList = new LinkedList<T>();
    private int capacity;
    private final Object putLock = new Object();
    private final Object takeLock = new Object();

    public MyQueue(int capacity){
        if(capacity < 1){
            capacity = 1;
        }
        this.capacity = capacity;
    }

    public void put(T t) throws InterruptedException {
        while(linkedList.size() == capacity){
            synchronized (putLock){
                putLock.wait();
            }
        }
        linkedList.addFirst(t);
        synchronized (takeLock){
            takeLock.notifyAll();
        }
    }

    public T take() throws InterruptedException {
        if(linkedList.isEmpty()){
            synchronized (takeLock){
                takeLock.wait();
            }
        }
        T t = linkedList.getLast();

        synchronized (putLock){
            putLock.notifyAll();
        }
        return t;
    }
    public synchronized int getSize(){
        return linkedList.size();
    }
}
