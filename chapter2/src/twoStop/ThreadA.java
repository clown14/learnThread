package twoStop;

public class ThreadA extends Thread {
    private Service service;

    @Override
    public void run() {
        service.methodA();
    }

    public ThreadA(Service service) {
        super();
        this.service = service;
    }
}
