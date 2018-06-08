package waitInterruptException;

public class Test {
    public static void main(String[] args) {
        try {
            Object lock = new Object();
            ThreadA a = new ThreadA(lock);
            a.start();
            Thread.sleep(6000);
            a.interrupt();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
