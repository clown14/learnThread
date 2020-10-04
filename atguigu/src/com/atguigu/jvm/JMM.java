package com.atguigu.jvm;

class MyNumber {
    volatile int number = 10;

    public void addTo1205() {
        this.number = 1205;
    }
}
/**
 * @program: Thread
 * @author: onion
 * @create: 2020-10-04 13:56
 *
 * JMM = 可见性（通知机制）
 **/

public class JMM {
    public static void main(String[] args) {
        MyNumber myNumber = new MyNumber();
        new Thread(() -> {
            try {
                Thread.sleep(3000);
                myNumber.addTo1205();
                System.out.println(Thread.currentThread().getName() + "\t update number,value： " + myNumber.number);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "AAAA").start();

        while (myNumber.number == 10) {
            //需要由一种通知机制告诉main线程，number已经修改1205，跳出
        }

        System.out.println(Thread.currentThread().getName() + "\t is over");
    }
}

    