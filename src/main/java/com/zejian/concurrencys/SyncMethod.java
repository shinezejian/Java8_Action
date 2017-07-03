package com.zejian.concurrencys;

/**
 * Created by zejian on 2017/6/2.
 * Blog : http://blog.csdn.net/javazejian [原文地址,请尊重原创]
 */
public class SyncMethod {

   public int i;

   public synchronized void syncTask(){
           i++;
   }
}
