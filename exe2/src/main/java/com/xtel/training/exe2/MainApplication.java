package com.xtel.training.exe2;

import org.apache.log4j.Logger;

import java.util.Scanner;

public class MainApplication extends Thread{
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

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap vao thoi gian chay (tinh theo phut): ");
        int timeRun = sc.nextInt();
        System.out.println("Thoi gian chay la: " + timeRun + " phut");
        int realTime = timeRun * 60 * 1000;

        MainApplication main = new MainApplication();
        main.start();

        try {
            Thread.sleep(realTime);
            System.exit(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Thoi gian " + timeRun + " da het");
    }
}
