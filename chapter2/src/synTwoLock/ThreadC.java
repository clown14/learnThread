package synTwoLock;

public class ThreadC extends Thread {
    private Service service;

    @Override
    public void run() {
        service.printC();
    }

    public ThreadC(Service service) {
        super();
        this.service = service;
    }
}
