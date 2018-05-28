package t8;
/*
sleep()的作用是再指定的毫秒数内让当前“正在执行的线程”休眠（暂停执行）
“正在执行的线程”是指this.currentThread()返回的线程。
 */

public class MyThread1 extends Thread {
    @Override
    public void run() {
        try {
            System.out.println("Run1 threadNmae= " +
                    this.currentThread().getName() + " begin");
            Thread.sleep(2000);
            System.out.println("Run1 threadName= " +
                    this.currentThread().getName() + " end");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
