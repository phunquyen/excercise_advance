package com.xtel.training.exe.old;

import com.xtel.training.exe.old.common.RandomNumber;
import com.xtel.training.exe.old.thread.RandomNumberThread;
import com.xtel.training.exe.old.thread.WriteFileThread;

import java.util.Scanner;

public class MainApplication {

    public static void main(String[] args) {
        RandomNumber randomNumber = new RandomNumber();
        RandomNumberThread tRandomNumber = new RandomNumberThread(randomNumber);
        WriteFileThread tWriteFile = new WriteFileThread(randomNumber);

        tRandomNumber.start();
        tWriteFile.start();

        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap vao lenh stop de dung chuong trinh:");
        String stop = sc.nextLine();

        do {
            System.exit(0);
        } while (stop.equals("stop"));
    }
}