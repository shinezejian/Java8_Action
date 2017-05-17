package com.zejian.enumdeom2;

import java.util.EnumMap;

/**
 * Created by zejian on 2017/5/7.
 * Blog : http://blog.csdn.net/javazejian [原文地址,请尊重原创]
 */
public class EnumMapDemo {

    public static void main(String[] args){
        EnumMap map = new EnumMap<Color, Integer>(Color.class);

        System.out.println(map.toString());


//        Set<Day> days = EnumSet.allOf(Day.class);
//        System.out.println(days.toString());
    }
}
//
//enum Days {
//    MONDAY, TUESDAY, WEDNESDAY,
//    THURSDAY, FRIDAY, SATURDAY, SUNDAY
//}