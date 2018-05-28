package StringAndSyn2;

public class ThreadA extends Thread {
    private Service service;

    @Override
    public void run() {
        service.print(new Object());
    }

    public ThreadA(Service service) {
        super();
        this.service = service;
    }
}


