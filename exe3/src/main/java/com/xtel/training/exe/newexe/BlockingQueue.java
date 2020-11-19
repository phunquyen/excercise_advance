package com.xtel.training.exe.newexe;

import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public abstract class BlockingQueue<T> extends Thread{
    Logger logger = Logger.getLogger(BlockingQueue.class);
    protected static int capacity = 10;
    protected final LinkedList<T> items = new LinkedList<>();
    protected static List<BlockingQueue> threads = Collections.synchronizedList(new ArrayList<BlockingQueue>());
    protected final Object putLock = new Object();
    protected final Object takeLock = new Object();
    protected boolean running = false;

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

    public void run(){
        while (running){
            try{
                Thread.sleep(1000);
                doSomething();
            }
            catch (Exception e){
                logger.error("",e);
            }
            finally {
                synchronized (putLock){
                    try {
                        putLock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                synchronized (takeLock){
                    try {
                        takeLock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        logger.debug(String.format("Thread %s is stopped !", this.getName()));
    }

    protected abstract void doSomething() throws Exception;

    public synchronized int size() {
        return items.size();
    }

    public void notifyPut(){
        synchronized (this.putLock){
            this.putLock.notify();
        }
    }

    public void notifyTake(){
        synchronized (this.takeLock){
            this.takeLock.notify();
        }
    }

    public void waitPut(long delay) throws InterruptedException {
        synchronized (this.putLock){
            this.putLock.wait(delay);
        }
    }
    public void waitTake(long delay) throws InterruptedException {
        synchronized (this.takeLock){
            this.takeLock.wait(delay);
        }
    }

    public void killPut() {
        this.running = false;
        while (this.isAlive()){
            notifyPut();
        }
    }

    public void killTake() {
        this.running = false;
        while (this.isAlive()){
            notifyTake();
        }
    }

    public static void killAllThread(){
        for (BlockingQueue thread : threads) {
            thread.killPut();
            thread.killTake();
        }
        System.err.println("Stopped all thread !!!");
    }
}