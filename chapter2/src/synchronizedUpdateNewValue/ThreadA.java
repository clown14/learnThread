package synchronizedUpdateNewValue;

public class ThreadA extends Thread {
    private Service service;

    @Override
    public void run() {
        service.runMethod();
    }

    public ThreadA(Service service) {
        super();
        this.service = service;
    }
}
