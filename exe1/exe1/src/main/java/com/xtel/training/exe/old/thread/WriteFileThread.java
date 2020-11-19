package com.xtel.training.exe.old.thread;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

import com.xtel.training.exe.old.common.RandomNumber;
import org.apache.log4j.Logger;

public class WriteFileThread extends Thread {
    private static String filePath = "E:\\Work\\TRANING\\Phu Nguyen\\excercise_advance\\exe1\\output.txt";
    Logger logger = Logger.getLogger(WriteFileThread.class);

    File file = new File(filePath);
    RandomNumber randomNumber;

    public WriteFileThread(RandomNumber randomNumber) {
        this.randomNumber = randomNumber;
    }

    @Override
    public void run() {
        do {
            synchronized (randomNumber) {
                if (file.exists()) {
                    try {
                        BufferedWriter bw = new BufferedWriter(new FileWriter(filePath, true));
                        bw.write(String.valueOf(randomNumber.randomNumberInteger));
                        logger.debug(String.format("Write %s to file success !", randomNumber.randomNumberInteger));
                        bw.close();

                        randomNumber.notifyAll();
                        randomNumber.wait();
                    } catch (Exception e) {
                        e.printStackTrace();
                        logger.error(e);
                    }
                } else {
                    logger.warn(String.format("File not found"));
                }
            }
            synchronized (randomNumber) {
                randomNumber.notifyAll();
            }
        } while (true);
    }
}