package join_sleep_2;

public class ThreadC extends Thread {
    private ThreadB threadB;

    @Override
    public void run() {
        threadB.bService();
    }

    public ThreadC(ThreadB threadB) {
        super();
        this.threadB = threadB;
    }
}

