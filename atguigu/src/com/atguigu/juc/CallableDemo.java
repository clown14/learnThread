package com.atguigu.juc;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

class MyThread2 implements Runnable {

    @Override
    public void run() {

    }
}

class MyThread implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        System.out.println("******Mythread name call******");
        return 1024;
    }
}

/**
 * @program: Thread
 * @author: onion
 * @create: 2020-09-30 15:46
 **/

public class CallableDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<Integer> futureTask = new FutureTask(new MyThread());

        new Thread(futureTask,"A").start();
        Integer integer = futureTask.get();
        System.out.println(integer);

    }
}

    