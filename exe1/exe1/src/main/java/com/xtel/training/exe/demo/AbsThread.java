package com.xtel.training.exe.demo;

import com.xtel.training.exe.old.thread.WriteFileThread;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class AbsThread extends Thread{
    protected static List<AbsThread> threads = Collections.synchronizedList(new ArrayList<AbsThread>());
    protected static final Logger logger = Logger.getLogger(WriteFileThread.class);
    protected final Object syncLock = new Object();
    protected boolean running = false;

    public void start(){
        running = true;
        super.start();
        logger.debug(String.format("Thread %s is started !", this.getName()));
        threads.add(this);
    }

    public void run(){
        while (running){
            try{
                Thread.sleep(10);
                doSomething();
            }
            catch (Exception e){
                logger.error("",e);
            }
            finally {
                synchronized (syncLock){
                    try {
                        syncLock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        logger.debug(String.format("Thread %s is stopped !", this.getName()));
    }

    protected abstract void doSomething() throws Exception;

    public void notifyMe(){
        synchronized (this.syncLock){
            this.syncLock.notifyAll();
        }
    }

    public void waitMe() throws InterruptedException {
        synchronized (this.syncLock){
            this.syncLock.wait();
        }
    }

    public void killMe(){
        this.running = false;
        while (this.isAlive()){
            notifyMe();
        }
    }

    public static void killAllThread(){
        for (AbsThread thread : threads) {
            thread.killMe();
        }
        System.err.println("Stopped all thread !!!");
    }
}
