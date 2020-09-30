package com.atguigu.juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class ShareData {
    private int number = 1; //A:1 B:2 C:3
    private Lock lock = new ReentrantLock();
    private Condition c1 = lock.newCondition();
    private Condition c2 = lock.newCondition();
    private Condition c3 = lock.newCondition();

    public void print5() {
        lock.lock();
        try {
            //1 判断
            while (number != 1) {
                //wait...
                c1.await();
            }
            //2 干活
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName() + "\t" + i);
            }
            //3 通知
            number = 2;
            //如何通知第2个
            c2.signal();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void print10() {
        lock.lock();
        try {
            //1 判断
            while (number != 2) {
                //wait...
                c2.await();
            }
            //2 干活
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + "\t" + i);
            }
            //3 通知
            number = 3;
            //如何通知第2个
            c3.signal();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void print15() {
        lock.lock();
        try {
            //1 判断
            while (number != 3) {
                //wait...
                c3.await();
            }
            //2 干活
            for (int i = 0; i < 15; i++) {
                System.out.println(Thread.currentThread().getName() + "\t" + i);
            }
            //3 通知
            number = 1;
            //如何通知第1个
            c1.signal();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}

/**
 * @program: Thread
 * @author: onion
 * @create: 2020-09-30 15:16
 **/

public class ConditionDemo {
    public static void main(String[] args) {
        ShareData sd = new ShareData();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                sd.print5();
            }
        }, "A").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                sd.print10();
            }
        }, "B").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                sd.print15();
            }
        }, "C").start();
    }
}

    