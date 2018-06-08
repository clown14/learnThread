package notifyOne;

public class ThreadC extends Thread {
    private Object lock;

    @Override
    public void run() {
        Service service = new Service();
        service.testMethod(lock);
    }

    public ThreadC(Object lock) {
        super();
        this.lock = lock;
    }
}