package notifyHoldLock;

public class Test {
    public static void main(String[] args) {
        Object lock = new Object();
        ThreadA a = new ThreadA(lock);
        a.start();
        NotifyThread b = new NotifyThread(lock);
        b.start();
        synNotifyMethodThread c = new synNotifyMethodThread(lock);
        c.start();
    }
}
