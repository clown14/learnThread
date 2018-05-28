package test2;

public class MyObject {
    synchronized public void speedPrintString() {
        System.out.println("testMethod1 ____getLock time=" +
                System.currentTimeMillis() + "run ThreadNmae=" +
                Thread.currentThread().getName());
        System.out.println("-------------");
        System.out.println("testMethod1 releaseLock time=" +
                System.currentTimeMillis() + "run ThreadNmae=" +
                Thread.currentThread().getName());
    }
}
