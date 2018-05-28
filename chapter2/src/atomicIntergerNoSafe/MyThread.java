package atomicIntergerNoSafe;

public class MyThread extends Thread {
    private MyService myService;

    @Override
    public void run() {
        myService.addNum();
    }

    public MyThread(MyService myService) {
        super();
        this.myService = myService;
    }
}
