package com.xtel.training.exe2;

import com.xtel.training.exe2.thread.RandomNumberThread;

import java.util.Scanner;

public class MainApplication extends Thread{
    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap vao thoi gian chay (tinh theo phut): ");
        int timeRun = sc.nextInt();
        System.out.println("Thoi gian chay la: " + timeRun + " phut");
        int realTime = timeRun * 60 * 1000;

        RandomNumberThread trandom = new RandomNumberThread();
        trandom.start();
        trandom.join();

        try {
            Thread.sleep(realTime);
            System.exit(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Thoi gian " + timeRun + " da het");
    }
}
