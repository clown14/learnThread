package com.atguigu.interview.thread;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @program: Thread
 * @author: onion
 * @create: 2020-10-10 14:54
 **/

public class SemaphoreDemo {
    public static void main(String[] args) {
        Semaphore semaphore=new Semaphore(3);
        for (int i = 1; i <=6 ; i++) {
            new Thread(()->{
                try {
                    //占有资源
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName()+"\t抢到车位");
                    try{ TimeUnit.SECONDS.sleep(3);} catch (Exception e){e.printStackTrace(); }
                    System.out.println(Thread.currentThread().getName()+"\t停车3秒后离开车位");
                }
                catch (InterruptedException e) {e.printStackTrace();}
                //释放资源
                finally {semaphore.release();}
            },String.valueOf(i)).start();
        }
    }
}

    