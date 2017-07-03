package geym.conc.ch2.inter;

import java.util.concurrent.TimeUnit;

/**
 * 中断状态可以检测，并在应用上作出相应
 * 如果应用不相应中断，则T1永远不会退出
 * @author Administrator
 *
 */
public class InterruputThread {
	public static void main(String[] args) throws InterruptedException {
		Thread t1=new Thread(){
			@Override
			public void run(){
				while(true){
					//判断当前线程是否被中断
					if (this.isInterrupted()){
						System.out.println("线程中断");
						break;//结束循环
					}
				}

				System.out.println("已跳出循环,线程中断!");
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
