package test3;

public class MyObject {
    public void speedPrintString() {
        synchronized (this) {
            System.out.println("testMethod1 ____getLock time=" +
                    System.currentTimeMillis() + "run ThreadNmae=" +
                    Thread.currentThread().getName());
            System.out.println("-------------");
            System.out.println("testMethod1 releaseLock time=" +
                    System.currentTimeMillis() + "run ThreadNmae=" +
                    Thread.currentThread().getName());
        }
    }
}
