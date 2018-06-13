package awaitUntilTest;

public class MyThreadA extends Thread {
    private Service service;

    @Override
    public void run() {
        service.waitMethod();
    }

    public MyThreadA(Service service) {
        super();
        this.service = service;
    }
}
