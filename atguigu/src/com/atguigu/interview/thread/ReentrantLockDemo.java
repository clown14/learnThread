package com.atguigu.interview.thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: Thread
 * @author: onion
 * @create: 2020-10-08 15:54
 **/

public class ReentrantLockDemo {
    public static void main(String[] args) throws InterruptedException {
        Phone phone=new Phone();
        syncTest(phone);

        TimeUnit.SECONDS.sleep(1);
        System.out.println();

        Thread t3=new Thread(phone);
        Thread t4=new Thread(phone);
        t3.start();
        t4.start();

    }

    private static void syncTest(Phone phone) {

        new Thread(()->{
            try{
                phone.sendSMS();
            }catch (Exception e){
                e.printStackTrace();
            }
        },"t1").start();

        new Thread(()->{
            try{
                phone.sendSMS();
            }catch (Exception e){
                e.printStackTrace();
            }
        },"t2").start();

    }
}
class Phone implements Runnable{
    //Synchronized TEST

    public synchronized void sendSMS(){
        System.out.println(Thread.currentThread().getId()+"\t"+"sendSMS()");
        sendEmail();
    }
    public synchronized void sendEmail(){
        System.out.println(Thread.currentThread().getId()+"\t"+"#######sendEmail()");
    }

    //Reentrant TEST

    Lock lock=new ReentrantLock();
    @Override
    public void run() {
        get();
    }
    public void get(){
        lock.lock();
        try{
            System.out.println(Thread.currentThread().getId()+"\t"+"get()");
            set();
        }finally {
            lock.unlock();
        }
    }
    public void set(){
        lock.lock();
        try{
            System.out.println(Thread.currentThread().getId()+"\t"+"set()");
        }finally {
            lock.unlock();
        }
    }
}

    