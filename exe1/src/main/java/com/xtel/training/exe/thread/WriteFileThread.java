package com.xtel.training.exe.thread;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

import com.xtel.training.exe.common.RandomNumber;
import org.apache.log4j.Logger;

public class WriteFileThread extends Thread {
    private static String filePath = "output.txt";
    Logger logger = Logger.getLogger(WriteFileThread.class);

    File file = new File(filePath);
    public static RandomNumber randomNumber2;

    public WriteFileThread(RandomNumber randomNumber) {
        this.randomNumber2 = randomNumber;
    }

    @Override
    public void run() {
        do {
            synchronized (RandomNumberThread.randomNumber1) {
                if (file.exists()) {
                    try {
                        BufferedWriter bw = new BufferedWriter(new FileWriter(filePath, true));
                        bw.write(String.valueOf(randomNumber2.number));
                        logger.info(String.format(String.valueOf(randomNumber2.number)));
                        bw.close();
                        randomNumber2.notifyAll();
                        randomNumber2.wait();
                    } catch (Exception e) {
                        e.printStackTrace();
                        logger.error(e);
                    }

                } else {
                    logger.warn(String.format("File not found"));
                }
            }
            synchronized (randomNumber2) {
                randomNumber2.notifyAll();
            }
        } while (true);
    }
}