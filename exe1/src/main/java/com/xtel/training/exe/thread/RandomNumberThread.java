package com.xtel.training.exe.thread;

import com.xtel.training.exe.common.RandomNumber;
import org.apache.log4j.Logger;

public class RandomNumberThread extends Thread {
    Logger logger = Logger.getLogger(RandomNumberThread.class);
    RandomNumber randomNumber;

    public RandomNumberThread(RandomNumber randomNumber) {
        this.randomNumber = randomNumber;
    }

    @Override
    public void run() {
        int i = 1;
        do {
            synchronized (randomNumber) {
                randomNumber.randomNumberInteger = (int) (Math.random() * 10 + 1);
                logger.info(String.format("Random so thu " + i + " la: " + randomNumber.randomNumberInteger));
                randomNumber.notifyAll();
                try {
                    Thread.sleep(1000);
                    randomNumber.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    logger.error(e);
                }
                i++;
            }
        } while (i != 0);
    }
}
