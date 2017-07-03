package com.zejian.classloader;

import sun.reflect.CallerSensitive;
import sun.reflect.Reflection;

/**
 * Created by zejian on 2017/6/18.
 * Blog : http://blog.csdn.net/javazejian [原文地址,请尊重原创]
 */

class TestDemo1 {

    public void gg(){
        g();
    }


    public void g(){
        System.out.println("g....:"+ Reflection.getCallerClass());
    }
}

public class DemoClass {


    public  static void main(String[] args){

        TestDemo1 d =new TestDemo1();
        d.gg();

    }

}
