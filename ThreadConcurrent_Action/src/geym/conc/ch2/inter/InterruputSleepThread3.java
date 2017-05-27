package geym.conc.ch2.inter;

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
                        System.out.println("while");
                        Thread.sleep(2000);
                        Thread.yield();
                    }
                } catch (InterruptedException e) {
                    System.out.println("Interruted When Sleep");
                }
            }
        };
        t1.start();
        Thread.sleep(2000);
        t1.interrupt();
    }
}
