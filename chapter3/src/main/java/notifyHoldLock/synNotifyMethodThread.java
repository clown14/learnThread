package notifyHoldLock;

public class synNotifyMethodThread extends Thread {
    private Object lock;

    @Override
    public void run() {
        Service service = new Service();
        service.synNotifyMethod(lock);
    }

    public synNotifyMethodThread(Object lock) {
        super();
        this.lock = lock;
    }
}
