package com.xtel.training.exe.thread;

import com.xtel.training.exe.common.RandomNumber;
import org.apache.log4j.Logger;

public class RandomNumberThread extends Thread {
    Logger logger = Logger.getLogger(RandomNumberThread.class);
    public static RandomNumber randomNumber1;

    public RandomNumberThread(RandomNumber randomNumber) {
        this.randomNumber1 = randomNumber;
    }

    @Override
    public void run() {
        int i = 1;
        do {
            synchronized (WriteFileThread.randomNumber2) {
                randomNumber1.number = (int) (Math.random() * 10 + 1);
                logger.info(String.format("Random so thu " + i + " la: " + randomNumber1.number));
                randomNumber1.notifyAll();
                try {
                    Thread.sleep(1000);
                    randomNumber1.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    logger.error(e);
                }
                i++;
            }
        } while (i != 0);
    }
}
