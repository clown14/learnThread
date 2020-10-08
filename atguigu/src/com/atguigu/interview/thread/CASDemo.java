package com.atguigu.interview.thread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @program: Thread
 * @author: onion
 * @create: 2020-10-05 15:13
 *
 * CAS是指Compare And Swap，比较并交换，是一种很重要的同步思想。如果主内存的值跟期望值一样，那么就进行修改，否则一直重试重新读取，直到一致为止
 **/

public class CASDemo {
    public static void main(String[] args) {
        AtomicInteger atomicInteger=new AtomicInteger(5);
        System.out.println(atomicInteger.compareAndSet(5, 2019)+"\t current data : "+ atomicInteger.get());
        //修改失败
        System.out.println(atomicInteger.compareAndSet(5, 1024) + "\t current data : " + atomicInteger.get());

        atomicInteger.getAndIncrement();
    }
}

    