package com.zejian.enumdemo;

import java.util.EnumSet;

/**
 * Created by zejian on 2017/5/10.
 * Blog : http://blog.csdn.net/javazejian [原文地址,请尊重原创]
 */

enum Type{
    TYPE_ONE,TYPE_TWO,TYPE_THREE,TYPE_FOUR
}

public class EnumSetDemo {

//    public static final int TYPE_ONE = 1 << 0 ; //1
//    public static final int TYPE_TWO = 1 << 1 ; //2
//    public static final int TYPE_THREE = 1 << 2 ; //4
//    public static final int TYPE_FOUR = 1 << 3 ; //8


    public static void main(String[] args){
//        int type= TYPE_ONE | TYPE_TWO | TYPE_THREE |TYPE_FOUR;

        EnumSet set =EnumSet.of(Type.TYPE_ONE,Type.TYPE_FOUR);
    }
}
