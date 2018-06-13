package awaitUninterruptiblyTest_1;

public class MyThread extends Thread {
    private Service service;

    @Override
    public void run() {
        service.testMethod();
    }

    public MyThread(Service service) {
        super();
        this.service = service;
    }
}
