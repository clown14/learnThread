package t19;
/*
高优先级的线程总是大部分先执行完，但不代表高优先级的线程全部先执行完。
当优先级的等级差距很大时，谁先执行完何代码的调用顺序无关
 */
public class Run {
    public static void main(String[] args) {
        for (int i=0;i<5;i++) {

            MyThread1 thread1 = new MyThread1();
            thread1.setPriority(10);
            thread1.start();
            MyThread2 thread2 = new MyThread2();
            thread2.setPriority(1);
            thread2.start();
        }
    }
}
