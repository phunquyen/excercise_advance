package com.xtel.training.exe2.thread;

import com.xtel.training.exe2.MainApplication;
import org.apache.log4j.Logger;

public class RandomNumberThread extends Thread{
    Logger logger = Logger.getLogger(MainApplication.class);

    @Override
    public void run() {
        int randomNumber = 0;
        int count = 1;

        do{
            randomNumber = (int) (Math.random() * 10 +1);
            logger.info("Random so thu " + count + " la: " + randomNumber);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
                logger.error(e);
            }
            count ++;
//            Thread.currentThread().sleep(1000*6000*n);
        } while (true);
    }
}
