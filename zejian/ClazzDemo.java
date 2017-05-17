package com.zejian;

/**
 * Created by zejian on 2017/4/30.
 * Blog : http://blog.csdn.net/javazejian [原文地址,请尊重原创]
 */
public class ClazzDemo {


    public static void main(String[] args){
        //没有泛型
        Class intClass = int.class;

        //带泛型的Class对象
        Class<Integer> integerClass = int.class;

        integerClass = Integer.class;

        //没有泛型的约束,可以随意赋值,错误将在运行时期才暴露出来
        intClass= double.class;

        //编译期错误,无法编译通过
//        integerClass = double.class

//        Class<Number> numberClass=Integer.class;
        Class<? extends Number> clazz = Integer.class;
    }

}
