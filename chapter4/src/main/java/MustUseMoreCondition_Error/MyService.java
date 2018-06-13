package MustUseMoreCondition_Error;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyService {
    private Lock lock = new ReentrantLock();
    public Condition condition = lock.newCondition();

    public void awaitA() {
        try {
            lock.lock();
            System.out.println("awaitA begin ThreadName=" +
                    Thread.currentThread().getName() + " time=" +
                    System.currentTimeMillis());
            condition.await();
            System.out.println("awaitA   end ThreadName=" +
                    Thread.currentThread().getName() + " time=" +
                    System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void awaitB() {
        try {
            lock.lock();
            System.out.println("awaitB begin ThreadName=" +
                    Thread.currentThread().getName() + " time=" +
                    System.currentTimeMillis());
            condition.await();
            System.out.println("awaitB   end ThreadName=" +
                    Thread.currentThread().getName() + " time=" +
                    System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void signalAll() {
        try {
            lock.lock();
            System.out.println("  signalAll时间为" + System.currentTimeMillis() +
                    " ThreadName=" + Thread.currentThread().getName());
            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }
}
