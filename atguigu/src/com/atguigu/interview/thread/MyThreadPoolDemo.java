package com.atguigu.interview.thread;

import com.sun.jmx.snmp.ThreadContext;

import java.util.concurrent.*;

/**
 * @program: Thread
 * @author: onion
 * @create: 2020-10-13 14:58
 * 第4种获得/使用java多线程的方式，线程池
 **/

public class MyThreadPoolDemo {
    public static void main(String[] args) {

        ExecutorService threadPool=new ThreadPoolExecutor(2,5,
                1L, TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());

        try {
            //模拟10个用户来办理业务，每个用户就是一个来自外部的请求线程
            for (int i = 1; i <= 10; i++) {
                threadPool.execute(() -> {
                    System.out.println(Thread.currentThread().getName()+"\t 办理业务");
                });
            }

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            threadPool.shutdown();
        }
    }

    public static void threadPoolInit() {
        //        System.out.println(Runtime.getRuntime().availableProcessors());
//        ExecutorService threadPool = Executors.newFixedThreadPool(5);//一池5个处理线程,使用LinkedBlockingQueue实现，定长线程池
//        ExecutorService threadPool = Executors.newSingleThreadExecutor();//一池1个处理线程,使用LinkedBlockingQueue实现
        ExecutorService threadPool = Executors.newCachedThreadPool();//一池n个处理线程,使用SynchronousQueue实现，变长线程池

        try {
            //模拟10个用户来办理业务，每个用户就是一个来自外部的请求线程
            for (int i = 1; i <= 10; i++) {
                threadPool.execute(() -> {
                    System.out.println(Thread.currentThread().getName()+"\t 办理业务");
                });
            }

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            threadPool.shutdown();
        }
    }

}

    