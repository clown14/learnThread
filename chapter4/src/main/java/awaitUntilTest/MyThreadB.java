package awaitUntilTest;

public class MyThreadB extends Thread {
    private Service service;

    @Override
    public void run() {
        service.notifyMethod();
    }

    public MyThreadB(Service service) {
        super();
        this.service = service;
    }
}
