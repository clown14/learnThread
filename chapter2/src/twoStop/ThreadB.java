package twoStop;

public class ThreadB extends Thread {
    private Service service;

    @Override
    public void run() {
        service.methodB();
    }

    public ThreadB(Service service) {
        super();
        this.service = service;
    }
}
