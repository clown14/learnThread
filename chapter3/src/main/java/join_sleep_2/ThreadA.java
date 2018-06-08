package join_sleep_2;

public class ThreadA extends Thread {
    private ThreadB b;

    @Override
    public void run() {
        try {
            synchronized (b) {
                b.start();
                b.join();
                for (int i=0; i<Integer.MAX_VALUE; i++) {
                    String newString = new String();
                    Math.random();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public ThreadA(ThreadB b) {
        super();
        this.b = b;
    }
}
