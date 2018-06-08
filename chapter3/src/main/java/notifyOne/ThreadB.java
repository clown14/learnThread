package notifyOne;

public class ThreadB extends Thread {
    private Object lock;

    @Override
    public void run() {
        Service service = new Service();
        service.testMethod(lock);
    }

    public ThreadB(Object lock) {
        super();
        this.lock = lock;
    }
}