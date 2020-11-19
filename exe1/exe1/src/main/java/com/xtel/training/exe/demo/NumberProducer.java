package com.xtel.training.exe.demo;

import java.util.Random;

public class NumberProducer extends AbsThread{
    public static final Random rd = new Random();
    public Integer atomicNumber;
    public NumberWriter numberWriter;

    protected void doSomething() throws Exception {
        atomicNumber = rd.nextInt(10);
        logger.debug("Number random is : " + atomicNumber);
        numberWriter.notifyMe();
    }

    public void setNumberWriter(NumberWriter numberWriter) {
        this.numberWriter = numberWriter;
    }
}
