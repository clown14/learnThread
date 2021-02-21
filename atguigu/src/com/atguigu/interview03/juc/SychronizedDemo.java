package com.atguigu.interview03.juc;

/**
 * @program: Thread
 * @author: onion
 * @create: 2021-02-21 22:10
 **/

//1.同步块
public class SychronizedDemo {
    Object object=new Object();

    public void sychronizedMethod(){
        new Thread(()->{
            synchronized (object){
                System.out.println(Thread.currentThread().getName()+"\t"+"外层....");
                synchronized (object){
                    System.out.println(Thread.currentThread().getName()+"\t"+"中层....");
                    synchronized (object){
                        System.out.println(Thread.currentThread().getName()+"\t"+"内层....");
                    }
                }
            }
        },"A").start();
    }
    public static void main(String[] args) {
        new SychronizedDemo().sychronizedMethod();
        /*
        输出结果：
            A	外层....
            A	中层....
            A	内层....
        * */
    }
}


    