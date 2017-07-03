package geym.conc.ch2.inter;

import java.util.concurrent.TimeUnit;

/**
 * sleep中断后 抛出异常被重置中断状态
 * 如果希望sleep后可以判断中断状态，则必须在sleep的异常处理中，在设置中断
 *
 * @author Administrator
 */
public class InterruputSleepThread3 {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread() {
            @Override
            public void run() {
                //while在try中，通过异常中断就可以退出run循环
                try {
                    while (true) {
                        //当前线程处于阻塞状态
                        TimeUnit.SECONDS.sleep(2);
                        Thread.yield();
                    }
                } catch (InterruptedException e) {
                    System.out.println("Interruted When Sleep");
                    boolean interrupt = this.isInterrupted();
                    //中断状态被复位
                    System.out.println("interrupt:"+interrupt);
                }
            }
        };
        t1.start();
        TimeUnit.SECONDS.sleep(2);
        t1.interrupt();

        /**
         * 输出结果:
           Interruted When Sleep
           interrupt:false
         */
    }
}
