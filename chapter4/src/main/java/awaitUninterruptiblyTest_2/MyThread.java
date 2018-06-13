package awaitUninterruptiblyTest_2;

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
