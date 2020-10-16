package com.atguigu.interview.thread;

import java.util.concurrent.CyclicBarrier;

/**
 * @program: Thread
 * @author: onion
 * @create: 2020-10-10 14:41
 **/

public class CyclicBarrierDemo {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier=new CyclicBarrier(7,()->{
            System.out.println("*****召唤神龙");
        });
        for (int i = 1; i <=7 ; i++) {
            final int tempInt=i;
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+
                        "\t 收集到第"+tempInt+"颗龙珠");
                try{
                    cyclicBarrier.await();
                }catch (Exception e){
                    e.printStackTrace();
                }
            },String.valueOf(i)).start();
        }
    }
}

    