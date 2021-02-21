package com.atguigu.interview03.juc;

import java.util.concurrent.locks.LockSupport;

/**
 * @program: Thread
 * @author: onion
 * @create: 2021-02-21 22:53
 **/

/**
(1).阻塞
 (permit默认是O，所以一开始调用park()方法，当前线程就会阻塞，直到别的线程将当前线程的permit设置为1时,
 park方法会被唤醒，然后会将permit再次设置为O并返回)
 static void park()
 static void park(Object blocker)
(2).唤醒
static void unpark(Thread thread)
 (调用unpark(thread)方法后，就会将thread线程的许可permit设置成1(注意多次调用unpark方法，不会累加，
 permit值还是1)会自动唤醒thread线程，即之前阻塞中的LockSupport.park()方法会立即返回)
 static void unpark(Thread thread)



 1)LockSupport是一个线程阻塞工具类，所有的方法都是静态方法，可以让线程在任意位置阻塞，阻塞之后也有对应的唤醒方法。归根结底，LockSupport调用的Unsafe中的native代码。

 2)LockSupport它解决的痛点
 LockSupport不用持有锁块，不用加锁，程序性能好
 不管先后顺序，不容易导致卡死(因为unpark获得了一个凭证，之后再调用park方法，就可以名正言顺的凭证消费，故不会阻塞)

 3)面试题目：
 为什么可以先唤醒线程后阻塞线程?(因为unpark获得了一个凭证，之后再调用park方法，就可以名正言顺的凭证消费，故不会阻塞)
 为什么唤醒两次后阻塞两次，但最终结果还会阻塞线程?(因为凭证的数量最多为1，连续调用两次unpark和调用一次unpark效果一样，
 只会增加一个凭证;而调用两次park却需要消费两个凭证，证不够，不能放行)
**/
public class LockSupportDemo {
    public static void main(String[] args) {

        Thread t1 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "\t" + "coming....");
            LockSupport.park();
            /*
            如果这里有两个LockSupport.park(),因为permit的值为1,上一行已经使用了permit
            所以下一行被注释的打开会导致程序处于一直等待的状态
            * */
            //LockSupport.park();
            System.out.println(Thread.currentThread().getName() + "\t" + "被B唤醒了");
        }, "A");
        t1.start();

        //下面代码注释是为了A线程先执行
        //try { TimeUnit.SECONDS.sleep(3);  } catch (InterruptedException e) {e.printStackTrace();}

        Thread t2 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "\t" + "唤醒A线程");
            //有两个LockSupport.unpark(t1),由于permit的值最大为1,所以只能给park一个通行证
            LockSupport.unpark(t1);
            //LockSupport.unpark(t1);
        }, "B");
        t2.start();
    }
}



    