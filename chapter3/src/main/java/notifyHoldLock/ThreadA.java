package notifyHoldLock;

public class ThreadA extends Thread {
    private Object lock;

    @Override
    public void run() {
        Service service = new Service();
        service.testMethod(lock);
    }

    public ThreadA(Object lock) {
        super();
        this.lock = lock;
    }
}
