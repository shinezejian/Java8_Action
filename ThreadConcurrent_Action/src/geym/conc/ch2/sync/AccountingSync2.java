package geym.conc.ch2.sync;

public class AccountingSync2 implements Runnable{

	static int i=0;

	/**
	 * synchronized 修饰实例方法
	 */
	public synchronized void increase(){
		i++;
	}
	@Override
	public void run() {
		for(int j=0;j<1000000;j++){
			increase();
		}
	}
	public static void main(String[] args) throws InterruptedException {
		 AccountingSync2 instance=new AccountingSync2();
		Thread t1=new Thread(instance);
		Thread t2=new Thread(instance);
		t1.start();t2.start();
		t1.join();t2.join();
		System.out.println(i);
	}

	/**
	 * 输出结果:
	 * 2000000
	 */
}
