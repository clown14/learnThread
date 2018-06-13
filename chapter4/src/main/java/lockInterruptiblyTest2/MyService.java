package lockInterruptiblyTest2;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class MyService {
    public ReentrantLock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void waitMehtod() {
        try {
            lock.lockInterruptibly();
            System.out.println("lock begin" + Thread.currentThread().getName());
            for (int i=0; i<Integer.MAX_VALUE/10; i++) {
                String newString = new String();
                Math.random();
            }
            System.out.println("lock   end" + Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            if (lock.isHeldByCurrentThread()) {
                lock.unlock();
            }
        }
    }
}
