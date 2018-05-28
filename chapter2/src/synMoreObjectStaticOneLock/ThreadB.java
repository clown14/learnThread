package synMoreObjectStaticOneLock;

public class ThreadB extends Thread {
    private Service service;

    @Override
    public void run() {
        Service.printB();
    }

    public ThreadB(Service service) {
        super();
        this.service = service;
    }
}
