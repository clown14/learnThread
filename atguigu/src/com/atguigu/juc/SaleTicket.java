package com.atguigu.juc;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @program: Thread
 * @author: onion
 * @create: 2020-11-22 20:42
 **/

class Ticket{ //资源类 = 实例变量+实例方法
    private int number = 120;
    Lock lock = new ReentrantLock();
    public void sale(){
        lock.lock();
        try {
            if(number > 0) {
                System.out.println(Thread.currentThread().getName()+"\t卖出第："+(number--)+"\t还剩："+number);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }

    }
}

public class SaleTicket {

    public static void main(String[] args) {
        Ticket ticket = new Ticket();
            /*new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i <=40 ; i++) {
                        ticket.sale();
                    }
                }
            }, "A").start();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i <=40 ; i++) {
                        ticket.sale();
                    }
                }
            }, "B").start();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i <=40 ; i++) {
                        ticket.sale();
                    }
                }
            }, "C").start();*/
        //使用lambda表达式之后只用三行代码
        new Thread(() -> {
            for (int i = 0; i <= 40; i++) ticket.sale();
        }, "A").start();
        new Thread(() -> {
            for (int i = 0; i <= 40; i++) ticket.sale();
        }, "B").start();
        new Thread(() -> {
            for (int i = 0; i <= 40; i++) ticket.sale();
        }, "C").start();

    }
}

    