package com.atguigu.interview03.juc;

/**
 * @program: Thread
 * @author: onion
 * @create: 2021-02-21 22:39
 **/

public class WaitNotifyDemo {
    //等待线程
    public void waitThread(){
//      1.如果将synchronized (this){}注释,会抛出异常,因为wait和notify一定要在同步块或同步方法中
        synchronized (this){
            try {
                System.out.println(Thread.currentThread().getName()+"\t"+"coming....");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"\t"+"end....");
        }
    }
    //唤醒线程
    public void notifyThread(){
        synchronized (this){
            System.out.println("唤醒A线程....");
            notify();
        }
    }
    public static void main(String[] args) {
        WaitNotifyDemo synchronizedDemo = new WaitNotifyDemo();
        new Thread(()->{
//            2.如果把下行这句代码打开,先notify后wait,会出现A线程一直处于等待状态
//            try { TimeUnit.SECONDS.sleep(3);  } catch (InterruptedException e) {e.printStackTrace();}
            synchronizedDemo.waitThread();
        },"A").start();
        new Thread(()->{
            synchronizedDemo.notifyThread();
        },"B").start();

    }
}


    