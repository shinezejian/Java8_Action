package com.zejian.annotationdemo;

import net.mindview.atunit.Test;

import javax.annotation.processing.AbstractProcessor;

/**
 * Created by wuzejian on 2017/5/19.
 *
 */
public class AnnotationDemo {


    @Test
    public static void A(){
        System.out.println("Test.....");
//        AbstractProcessor
    }

    @Deprecated
    @SuppressWarnings("uncheck")
    public static void B(){

    }
}
