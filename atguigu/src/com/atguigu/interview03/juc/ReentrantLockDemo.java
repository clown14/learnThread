package com.atguigu.interview03.juc;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: Thread
 * @author: onion
 * @create: 2021-02-21 22:28
 **/

class Phone2{
    static ReentrantLock lock =new ReentrantLock();

    public static void sendSms(){
        lock.lock();
        /*
        注意有多少个lock,就有多少个unlock,他们是配对使用的
        如果多了一个lock(),那么会出现线程B一直处于等待状态
        * */
//        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName()+"\t"+"sendSms");
            sendEmails();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    private static void sendEmails() {
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName()+"\t"+"sendEmails...");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}
public class ReentrantLockDemo {
    public static void main(String[] args) {
        Phone2 phone2=new Phone2();
        new Thread(()->{phone2.sendSms();},"A").start();
        new Thread(()->{phone2.sendSms();},"B").start();
    }
}


    