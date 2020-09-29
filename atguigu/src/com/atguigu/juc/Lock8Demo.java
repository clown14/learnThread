package com.atguigu.juc;

import java.util.concurrent.TimeUnit;

class Phone{
//    public static synchronized void sendEmainl()throws Exception{
    public synchronized void sendEmainl()throws Exception{
        TimeUnit.SECONDS.sleep(4);
        System.out.println("sendEmail");
    }
    public synchronized void sendSMS()throws Exception{
        System.out.println("sendSMS");
    }
    public void getHello()  {
        System.out.println("------getHello");
    }
}

/**
 * @program: Thread
 * @author: onion
 * @create: 2020-09-29 13:03
 *
 * @Description: 8锁
 *  1 标准访问，先打印短信还是邮件
 *  2 停4秒在短信方法内，先打印短信还是邮件
 *    先邮件，静态方法锁的是类，普通方法锁的是对象，phone里的锁，会把这个对象给锁住，只要有一个线程进来访问，那么其他线程就都进不来。
 *  3 新增普通的hello方法，是先打短信还是hello
 *    先hello后邮件，普通方法不会和加锁的方法争抢资源，所以不会被锁
 *  4 现在有两部手机，先打印短信还是邮件
 *    先短信后邮件，各用各的
 *
 *  5 两个静态同步方法，1部手机，先打印短信还是邮件
 *  6 两个静态同步方法，2部手机，先打印短信还是邮件
 *    先邮件后短信，对象锁和全局锁的区别，静态同步方法是全局锁，把Class锁了
 *  7 1个静态同步方法,1个普通同步方法，1部手机，先打印短信还是邮件
 *  8 1个静态同步方法,1个普通同步方法，2部手机，先打印短信还是邮件
 *    先短信后邮件
 * ---------------------------------
 *
 **/

public class Lock8Demo {
    public static void main(String[] args) throws InterruptedException{
        Phone phone = new Phone();
        Phone phone2 = new Phone();

        new Thread(()->{
            try {
                phone.sendEmainl();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"A").start();

        Thread.sleep(100);

        new Thread(()->{
            try {
                phone.sendSMS();
                //phone.getHello();
                //phone2.sendEmail();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"B").start();
    }
}

    