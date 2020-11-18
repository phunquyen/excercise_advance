package com.xtel.training.exe.newexe;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class MessageQueue {

    Queue<String> q = new LinkedList<String>();
    private int queueMaxSize = 10;

    synchronized void retrieve() throws InterruptedException {
        while (true) {
            while (q.isEmpty()) {
                wait();
            }
            q.remove();
            System.out.print("Mail Queue::::::[");
            Iterator<String> it = q.iterator();
            while (it.hasNext())
                System.out.print(it.next() + ",");
            System.out.print("]");
            System.out.println();
            notifyAll();
        }
    }

    synchronized void adds(String emailMessage) throws InterruptedException {
        while (q.size() == queueMaxSize) {
            wait();
        }
        q.add(emailMessage);
        System.out.print("Mail Queue::::::[");
        Iterator<String> it = q.iterator();
        while (it.hasNext())
            System.out.print(it.next() + ",");
        System.out.print("]");
        System.out.println();
        notify();
    }
}
