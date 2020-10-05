package com.atguigu.interview.thread;

import java.util.concurrent.atomic.AtomicInteger;

class MyData {
    volatile int number = 0;

    public void addTo1205() {
        this.number = 1205;
    }

    //请注意此时number前面加了volatile，不保证原子性
    public void addPlusPlus() {
        number++;
    }

    AtomicInteger atomicInteger = new AtomicInteger();
    public void addAtomic() {
        atomicInteger.getAndIncrement();
    }
}

/**
 * @program: Thread
 * @author: onion
 * @create: 2020-10-04 13:56
 *
 * JMM = 可见性（通知机制）
 **/

public class VolatileDemo2 {
    public static void main(String[] args) {
        MyData myData = new MyData();

        for (int i = 1; i <= 20; i++) {
            new Thread(() -> {
                for (int j = 1; j <= 1000; j++) {
                    myData.addPlusPlus();
                    myData.addAtomic();
                }
            }, String.valueOf(i)).start();
        }

        //需要等待上面20个线程都全部计算完成后，再用Main线程取得最终结果值
        while (Thread.activeCount() > 2) {
            Thread.yield();
        }
        System.out.println(myData.number);
        System.out.println(myData.atomicInteger);
    }


}

    