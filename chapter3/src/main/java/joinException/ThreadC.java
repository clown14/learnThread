package joinException;

public class ThreadC extends Thread {
    private ThreadB threadB;

    @Override
    public void run() {
        threadB.interrupt();
    }

    public ThreadC(ThreadB threadB) {
        super();
        this.threadB = threadB;
    }
}
