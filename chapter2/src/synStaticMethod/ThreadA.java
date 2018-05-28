package synStaticMethod;

public class ThreadA extends Thread {
    @Override
    public void run() {
        Service.printA();
    }
}
