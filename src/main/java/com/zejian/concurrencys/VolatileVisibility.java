package com.zejian.concurrencys;

/**
 * Created by zejian on 2017/6/11.
 * Blog : http://blog.csdn.net/javazejian [原文地址,请尊重原创]
 */
public class VolatileVisibility {
    public static volatile int i =0;

    public static void increase(){
        i++;
    }
}
