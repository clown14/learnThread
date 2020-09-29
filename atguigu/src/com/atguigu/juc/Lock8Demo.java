package com.atguigu.juc;

class Phone{
    public synchronized void sendEmainl()throws Exception{
        System.out.println("sendEmail");
    }
    public synchronized void sendSMS()throws Exception{
        System.out.println("sendSMS");
    }
}

/**
 * @program: Thread
 * @author: onion
 * @create: 2020-09-29 13:03
 **/

public class Lock8Demo {
    public static void main(String[] args) throws InterruptedException{
        Phone phone = new Phone();

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
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"B").start();
    }
}

    