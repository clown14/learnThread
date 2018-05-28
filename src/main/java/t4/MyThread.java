package t4;

/*
通过在run方法前加入synchronized关键字，使多个线程在执行run方法时，以排队的方式进行处理。
线程在调用run方法时，先判断有没有上锁，如果上锁，必须等其他线程对run调用完后才执行run。
synchronized可以在任意对象及方法上加锁，而加锁的这段代码称为互斥区或临界区。

非线程安全主要是指多个线程对同一个对象中的同一个实例变量进行操作时会出现值被更改、值不同步的情况。
 */

public class MyThread extends Thread {
    private int count = 5;
    @Override
    synchronized public void run() {
        super.run();
        count--;
        System.out.println("由" + this.currentThread().getName() + "计算.count" + count);

    }
}
