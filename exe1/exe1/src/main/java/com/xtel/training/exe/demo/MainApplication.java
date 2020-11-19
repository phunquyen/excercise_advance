package com.xtel.training.exe.demo;

import org.apache.log4j.Logger;
import java.util.Scanner;

public class MainApplication {
    public static Logger logger = Logger.getLogger(MainApplication.class.getName());
    public static void main(String[] args) throws InterruptedException {
        logger.debug("Application is started ... !");
        Scanner sc = new Scanner(System.in);

        NumberProducer numberProducer = new NumberProducer();
        numberProducer.setName("Number Producer");
        NumberWriter numberWriter = new NumberWriter();
        numberWriter.setName("Number Writer");

        numberProducer.setNumberWriter(numberWriter);
        numberWriter.setNumberProducer(numberProducer);

        numberProducer.start();
        Thread.sleep(100);
        numberWriter.start();

        String cmd;
        do{
            cmd = sc.nextLine();
        }
        while (!cmd.equals("1"));

        AbsThread.killAllThread();
    }
}

