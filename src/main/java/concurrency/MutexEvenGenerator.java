package concurrency;//: concurrency/MutexEvenGenerator.java
// Preventing thread collisions with mutexes.
// {RunByHand}
import java.util.concurrent.locks.*;

public class MutexEvenGenerator extends IntGenerator {
  private int currentEvenValue = 0;
  private Lock lock = new ReentrantLock();
  public int next() {
    lock.lock();
    try {
      ++currentEvenValue;
      //Thread.yield()方法 暂停当前正在执行的线程对象，
      // yield()只是使当前线程重新回到可执行状态，
      // 所以执行yield()的线程有可能在进入到可执行状态后马上又被执行，
      // yield()只能使同优先级或更高优先级的线程有执行的机会。
      Thread.yield(); // Cause failure faster
      ++currentEvenValue;
      return currentEvenValue;
    } finally {
      lock.unlock();
    }
  }
  public static void main(String[] args) {
    EvenChecker.test(new MutexEvenGenerator());
  }
} ///:~
