package t20;

import t19.MyThread1;
import t19.MyThread2;

/*
线程的优先级还具有“随机性”，也就是优先级较高的线程不一定每一次都先执行完
 */
public class Run {
    public static void main(String[] args) {
        for (int i=0;i<5;i++) {

            MyThread1 thread1 = new MyThread1();
            thread1.setPriority(5);
            thread1.start();
            MyThread2 thread2 = new MyThread2();
            thread2.setPriority(6);
            thread2.start();
        }
    }
}
