package StringAndSyn2;

public class ThreadB extends Thread {
    private Service service;

    @Override
    public void run() {
        service.print(new Object());
    }

    public ThreadB(Service service) {
        super();
        this.service = service;
    }
}
