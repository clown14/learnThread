package wait_nofity_size5;

public class ThreadA extends Thread {
    private Object lock;

    @Override
    public void run() {
        try {
            synchronized (lock) {
                if (MyList.size() != 5) {
                    System.out.println("wait begin " +
                            System.currentTimeMillis());
                    lock.wait();
                    System.out.println("wait end " +
                            System.currentTimeMillis());
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public ThreadA(Object lock) {
        super();
        this.lock = lock;
    }
}
