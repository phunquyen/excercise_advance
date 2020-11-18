package com.xtel.training.exe.newexe;

public class MainApplication {
    public static void main(String... s) throws InterruptedException {
        MessageQueue messageQueue = new MessageQueue();
        new Thread(new Consumer(messageQueue)).start();
        for (int i = 0; i < 1000; ++i) {
            new Thread(new Producer("Email Message " + i, messageQueue))
                    .start();
        }
    }
}
