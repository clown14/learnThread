package test2;

public class MyThread1 extends Thread {
    private Object lock;

    @Override
    public void run() {
        try {
            synchronized (lock) {
                System.out.println("开始   wait time=" +
                        System.currentTimeMillis());
                lock.wait();
                System.out.println("结束   wait time=" +
                        System.currentTimeMillis());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public MyThread1(Object lock) {
        super();
        this.lock = lock;
    }
}
