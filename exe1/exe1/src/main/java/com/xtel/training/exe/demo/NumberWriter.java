package com.xtel.training.exe.demo;

public class NumberWriter extends AbsThread{
    public NumberProducer numberProducer;

    protected void doSomething() throws Exception {
        logger.debug("Number written is : "+numberProducer.atomicNumber);
        numberProducer.notifyMe();
    }

    public void setNumberProducer(NumberProducer numberProducer) {
        this.numberProducer = numberProducer;
    }
}
