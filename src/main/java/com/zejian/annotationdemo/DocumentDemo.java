package com.zejian.annotationdemo;

import java.lang.annotation.Annotation;
import java.util.Arrays;

/**
 * Created by zejian on 2017/5/20.
 * Blog : http://blog.csdn.net/javazejian [原文地址,请尊重原创]
 */
//@DocumentA
//class A{ }
//
//class B extends A{ }

@DocumentB
class C{ }

class D extends C{ }


@DocumentB
public class DocumentDemo extends A{

//    public static void main(String... args){
//        A instanceA=new B();
//        System.out.println("已使用的@Inherited注解:"+Arrays.toString(instanceA.getClass().getAnnotations()));
//
//        C instanceC = new D();
//
//        System.out.println("没有使用的@Inherited注解:"+Arrays.toString(instanceC.getClass().getAnnotations()));
//    }

    /**
     * 运行结果:
     已使用的@Inherited注解:[@com.zejian.annotationdemo.DocumentA()]
     没有使用的@Inherited注解:[]
     */

    public static void main(String... args){

        Class<?> clazz = DocumentDemo.class;
        //根据指定注解类型获取该注解
        DocumentA documentA=clazz.getAnnotation(DocumentA.class);
        System.out.println("A:"+documentA);

        //获取该元素上的所有注解,包括从父类继承的
        Annotation[] an= clazz.getAnnotations();
        System.out.println("an:"+ Arrays.toString(an));

        //获取该元素上的所有注解,不包括继承的
        Annotation[] an2=clazz.getDeclaredAnnotations();
        System.out.println("an2:"+ Arrays.toString(an2));

        //判断注解DocumentA是否在该元素上
        boolean b=clazz.isAnnotationPresent(DocumentA.class);
        System.out.println("b:"+b);

        /**
         * 执行结果:
         A:@com.zejian.annotationdemo.DocumentA()
         an:[@com.zejian.annotationdemo.DocumentA(), @com.zejian.annotationdemo.DocumentB()]
         an2:[@com.zejian.annotationdemo.DocumentB()]
         b:true
         */
    }
}
