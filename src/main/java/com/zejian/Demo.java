package com.zejian;

import java.util.Vector;

/**
 * Created by wuzejian on 2017/6/5.
 */
public class Demo {

    private static Vector vector = new Vector();

    public static void main(String[] args){
        while (true){
            for (int i=0; i < 10 ; i++){
                 vector.add(i);
            }


//
        Thread removeThread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0 ; i<vector.size(); i++){
                    vector.remove(i);
                }
            }
        });

        Thread printThread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0 ; i<vector.size(); i++){
                    System.out.println(vector.get(i));
                }
            }
        });

        removeThread.start();
        printThread.start();

        if (Thread.activeCount()>20){
            break;
        }

        }
    }
}
