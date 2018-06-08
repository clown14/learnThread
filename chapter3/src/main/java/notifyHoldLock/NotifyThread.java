package notifyHoldLock;

public class NotifyThread extends Thread {
    private Object lock;

    @Override
    public void run() {
        Service service = new Service();
        service.synNotifyMethod(lock);
    }

    public NotifyThread(Object lock) {
        super();
        this.lock = lock;
    }
}
