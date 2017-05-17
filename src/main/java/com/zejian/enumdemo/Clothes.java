package com.zejian.enumdemo;

/**
 * Created by zejian on 2017/5/10.
 * Blog : http://blog.csdn.net/javazejian [原文地址,请尊重原创]
 */
public class Clothes {
    private final String id;
    private final Color color;//颜色

    public Clothes(String id , Color color) {
        this.color = color;
        this.id=id;
    }

    @Override
    public String toString() {
        return id;
    }

    public String getId() {
        return id;
    }

    public Color getColor() {
        return color;
    }
}
