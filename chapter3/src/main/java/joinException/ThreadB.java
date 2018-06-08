package joinException;

public class ThreadB extends Thread {
    @Override
    public void run() {
        try {
            ThreadA a = new ThreadA();
            a.start();
            a.join();
            System.out.println("线程B在run end处打印了");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
