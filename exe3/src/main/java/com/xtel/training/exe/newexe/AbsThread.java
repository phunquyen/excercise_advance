package com.xtel.training.exe.newexe;

import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class AbsThread extends Thread {
    protected static List<AbsThread> threads = Collections.synchronizedList(new ArrayList<AbsThread>());
    Logger logger = Logger.getLogger(AbsThread.class);
    protected boolean running = false;
    public void start() {
        running = true;
        super.start();
        logger.debug(String.format("Thread %s is started !", this.getName()));
        threads.add(this);
    }
}
