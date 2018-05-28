package extthread;

/*
虽然println()方法在内部时同步的，但i--的操作却是在进入println()之前发生的，所有非线程安全问题。
 */
public class MyThread extends Thread {
    private int i = 5;

    @Override
    public void run() {
        System.out.println("i= " + (i--) + "threadName=" + Thread.currentThread().getName());
    }
}

