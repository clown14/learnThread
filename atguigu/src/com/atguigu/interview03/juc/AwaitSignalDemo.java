package com.atguigu.interview03.juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: Thread
 * @author: onion
 * @create: 2021-02-21 22:53
 **/

public class AwaitSignalDemo {
    public static void main(String[] args) {
        Lock lock=new ReentrantLock();
        Condition condition = lock.newCondition();

        new Thread(()->{
            //如果把下行这句代码打开,先signal后await,会出现A线程一直处于等待状态
            //try { TimeUnit.SECONDS.sleep(3);  } catch (InterruptedException e) {e.printStackTrace();}
            lock.lock();
            try {
                System.out.println(Thread.currentThread().getName()+"\t"+"coming....");
                condition.await();
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
            System.out.println(Thread.currentThread().getName()+"\t"+"END....");
        },"A").start();

        new Thread(()->{
            lock.lock();
            try {
                System.out.println(Thread.currentThread().getName()+"\t"+"唤醒A线程****");
                condition.signal();
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        },"B").start();
    }
}


    