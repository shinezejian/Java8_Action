package com.zejian.enumdemo;

import java.util.*;

/**
 * Created by zejian on 2017/5/10.
 * Blog : http://blog.csdn.net/javazejian [原文地址,请尊重原创]
 */
public class EnumMapDemo {
    public static void main(String[] args){
        List<Clothes> list = new ArrayList<>();
        for (int i = 0; i <100 ; i++) {
            list.add(new Clothes("C"+i,Enums.random(Color.values())));
        }

//        list.add(new Clothes("C002",Color.YELLOW));
//        list.add(new Clothes("C003",Color.RED));
//        list.add(new Clothes("C004",Color.GREEN));
//        list.add(new Clothes("C005",Color.BLUE));
//        list.add(new Clothes("C006",Color.BLUE));
//        list.add(new Clothes("C007",Color.RED));
//        list.add(new Clothes("C008",Color.YELLOW));
//        list.add(new Clothes("C009",Color.YELLOW));
//        list.add(new Clothes("C010",Color.GREEN));
        //方案1:使用HashMap
        Long start = System.currentTimeMillis();
        Map<String,Integer> map = new HashMap<>();
        for (Clothes clothes:list){
           String colorName=clothes.getColor().name();
           Integer count = map.get(colorName);
            if(count!=null){
                map.put(colorName,count+1);
            }else {
                map.put(colorName,1);
            }
        }

        System.out.println("使用HashMap消耗的时间:"+(System.currentTimeMillis()-start));

        System.out.println(map.toString());

        System.out.println("---------------");

        Long startEnum = System.currentTimeMillis();

        //方案2:使用EnumMap
        Map<Color,Integer> enumMap=new EnumMap<>(Color.class);

        for (Clothes clothes:list){
            Color color=clothes.getColor();
            Integer count = enumMap.get(color);
            if(count!=null){
                enumMap.put(color,count+1);
            }else {
                enumMap.put(color,1);
            }
        }
        System.out.println("使用EnumMap消耗的时间:"+(System.currentTimeMillis()-startEnum));

        System.out.println(enumMap.toString());
        System.out.println(enumMap.values());
    }

    /**
     输出结果:
     {RED=2, BLUE=3, YELLOW=3, GREEN=2}
     ---------------
     {GREEN=2, RED=2, BLUE=3, YELLOW=3}
     */
}
