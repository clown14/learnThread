package notifyOne;

public class NotifyThread extends Thread {
    private Object lock;

    @Override
    public void run() {
        synchronized (lock) {
            lock.notify();
            lock.notify();
            lock.notify();
            lock.notify();
            lock.notify();
            lock.notify();
            lock.notify();
        }
    }

    public NotifyThread(Object lock) {
        super();
        this.lock = lock;
    }
}
