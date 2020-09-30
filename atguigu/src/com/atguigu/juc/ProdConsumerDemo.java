package com.atguigu.juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Aircondition{
    private int number = 0;

    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public  void increment() throws InterruptedException {

        lock.lock();
        try {
            //1.判断
            while (number != 0) {
                condition.await();
            }
            //2.干活
            number ++ ;
            System.out.println(Thread.currentThread().getName() + "\t" + number);
            //3.通知
            condition.signalAll();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public  void decrement() throws InterruptedException {

        lock.lock();
        try {
            //1.判断
            while (number == 0) {
                condition.await();
            }
            //2.干活
            number -- ;
            System.out.println(Thread.currentThread().getName() + "\t" + number);
            //3.通知
            condition.signalAll();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    //synchronized老版本
//    public synchronized void increment() throws InterruptedException {
//
//        //1.判断(if要改成while就不会有虚假唤醒)
//        while (number != 0) {
//            this.wait();
//        }
//        //2.干活
//        number ++ ;
//        System.out.println(Thread.currentThread().getName() + "\t" + number);
//        //3.通知
//        this.notifyAll();
//    }
//    public synchronized void decrement() throws InterruptedException {
//        //1.判断
//        while (number == 0) {
//            this.wait();
//        }
//        //2.干活
//        number -- ;
//        System.out.println(Thread.currentThread().getName() + "\t" + number);
//        //3.通知
//        this.notifyAll();
//    }
}

/**
 * @program: Thread
 * @author: onion
 * @create: 2020-09-29 20:41
 **/

public class ProdConsumerDemo {
    public static void main(String[] args) {
        Aircondition aircondition = new Aircondition();

        new Thread(() -> {
            for (int i = 0; i <10 ; i++) {
                try {
                    aircondition.increment();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        },"A").start();

        new Thread(() -> {
            for (int i = 0; i <10 ; i++) {
                try {
                    aircondition.decrement();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        },"B").start();

        new Thread(() -> {
            for (int i = 0; i <10 ; i++) {
                try {
                    aircondition.increment();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        },"C").start();

        new Thread(() -> {
            for (int i = 0; i <10 ; i++) {
                try {
                    aircondition.decrement();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        },"D").start();
    }
}

    