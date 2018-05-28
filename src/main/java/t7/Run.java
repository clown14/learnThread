package t7;
/*
isAlive()测试线程是否处于活动状态。
 */
public class Run {
    public static void main(String[] args) {
        MyThread mythread = new MyThread();
        System.out.println("begin == " + mythread.isAlive());
        mythread.start();
        System.out.println("end =="+mythread.isAlive());
    }
}
