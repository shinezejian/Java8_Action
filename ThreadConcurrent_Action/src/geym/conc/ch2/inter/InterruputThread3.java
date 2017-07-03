package geym.conc.ch2.inter;

import java.util.concurrent.TimeUnit;

/**
 * 中断状态可以检测，并在应用上作出相应
 * 如果应用不相应中断，则T1永远不会退出
 * @author Administrator
 *
 */
public class InterruputThread3 {
	public static void main(String[] args) throws InterruptedException {
		Thread t1=new Thread(){
			@Override
			public void run(){
				try {
					//判断当前线程是否已中断,注意interrupted方法是静态的,执行后会对中断状态进行复位
					while (!Thread.interrupted()) {
						TimeUnit.SECONDS.sleep(2);
					}
				} catch (InterruptedException e) {

				}
			}
		};
		t1.start();
		TimeUnit.SECONDS.sleep(2);
		t1.interrupt();

		/**
		 * 输出结果:
		    线程中断
		    已跳出循环,线程中断!
		 */
	}
}
