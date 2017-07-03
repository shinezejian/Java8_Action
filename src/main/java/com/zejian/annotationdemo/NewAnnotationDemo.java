package com.zejian.annotationdemo;

import checkers.nullness.quals.NonNull;
import com.sun.istack.NotNull;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by zejian on 2017/5/20.
 * Blog : http://blog.csdn.net/javazejian [原文地址,请尊重原创]
 */
public class NewAnnotationDemo<@NotNull V> {

//    //标明list容器中的元素不能为null
//    private List<@NotNull String> names;
//
//    //泛型方法,@NotNull方法用于修饰泛型参数,提示调用者该值不能为null
//    public <@NotNull T> void  setItem(@NotNull T t){
//
//    }
//
//    //泛型方法,@NewB方法用于修饰泛型参数
//    public <T> void  setNew(@NotNull T t){
//
//    }
//
//    String[] @NonNull [] words;//word[i] 不能为null
//
//    String @NotNull [][] words2;//word 不能为null
//
//    interface Shape{ }
//
//    //用于父类或接口
//    class Image implements @Rectangular Shape {}
//
//    //用于强制类型转换

    static void sample() {
        @NonNull Object my = new Object();
    }

    public static void main(String[] args){
        sample();
    }
}

@Target(ElementType.TYPE_USE)
@Retention(RetentionPolicy.RUNTIME)
@interface Rectangular {

}