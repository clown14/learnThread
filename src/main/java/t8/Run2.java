package t8;
/*
由于main线程与MyThread2线程是异步执行的，所以首先打印的信息为begin和end。
MyThread2线程是随后运行的，在最后两行打印run begin 和run end相关的信息。
 */

public class Run2 {
    public static void main(String[] args) {
        MyThread2 mythread = new MyThread2();
        System.out.println("begin =" + System.currentTimeMillis());
        mythread.start();
        System.out.println("end   =" + System.currentTimeMillis());
    }
}
