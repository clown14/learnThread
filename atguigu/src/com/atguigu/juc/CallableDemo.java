package com.atguigu.juc;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 面试题:获得多线程的方法几种?
 * （1）继承thread类
 * （2）runnable接口
 * 如果只回答这两个你连被问到juc的机会都没有
 * 正确答案如下： 传统的是继承thread类和实现runnable接口，java5以后又有实现callable接口和java的线程池获得
 *
 * 面试题:callable接口与runnable接口的区别？
 * 答：
 * （1）是否有返回值
 * （2）是否抛异常
 * （3）落地方法不一样，一个是run，一个是call
 *
 * FutrueTask
 * 在主线程中需要执行比较耗时的操作时，但又不想阻塞主线程时，可以把这些作业交给Future对象在后台完成，当主线程将来需要时，
 * 就可以通过Future对象获得后台作业的计算结果或者执行状态。一般FutureTask多用于耗时的计算，主线程可以在完成自己的任务后，
 * 再去获取结果。仅在计算完成时才能检索结果；如果计算尚未完成，则阻塞get 方法。一旦计算完成，就不能再重新开始或取消计算。
 * get方法而获取结果只有在计算完成时获取，否则会一直阻塞直到任务转入完成状态，然后会返回结果或者抛出异常。 只计算一次get方法放到最后
 */

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

    