package com.atguigu.interview.thread;

import com.atguigu.interview.thread.enums.CountryEnum;

import java.util.concurrent.CountDownLatch;

/**
 * @program: Thread
 * @author: onion
 * @create: 2020-10-10 14:03
 **/

public class CountDownLatchDemo {
    public static void main(String[] args) throws InterruptedException {

        closeDoor();
        CountDownLatch countDownLatch = new CountDownLatch(6);

        for (int i = 1; i <= 6; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "\t国，被灭");
                countDownLatch.countDown();
            }, CountryEnum.forEach_CountryEnum(i).getRetMessage()).start();
        }

        countDownLatch.await();
        System.out.println(Thread.currentThread().getName() + "\t***************秦帝国，一统华夏");
        System.out.println();
        System.out.println(CountryEnum.ONE);
        System.out.println(CountryEnum.ONE.getRetCode());
        System.out.println(CountryEnum.ONE.getRetMessage());
    }

    public static void closeDoor() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(6);

        for (int i = 1; i <= 6; i++) {
            new Thread(()->{
                System.out.println(Thread.currentThread().getName() + "\t上完自习，离开教室");
                countDownLatch.countDown();
            },String.valueOf(i)).start();
        }

        countDownLatch.await();
        System.out.println(Thread.currentThread().getName() + "\t***************班长关门走人");
    }
}

    