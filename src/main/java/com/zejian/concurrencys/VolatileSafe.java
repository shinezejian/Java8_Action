package com.zejian.concurrencys;

/**
 * Created by zejian on 2017/6/11.
 * Blog : http://blog.csdn.net/javazejian [原文地址,请尊重原创]
 */
public class VolatileSafe {

    volatile boolean close;

    public void close(){
        close=true;
    }

    public void doWork(){
        while (!close){
            System.out.println("safe....");
        }
    }
}
