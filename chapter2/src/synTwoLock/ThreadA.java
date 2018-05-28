package synTwoLock;

public class ThreadA extends Thread {
    private Service service;

    @Override
    public void run() {
        Service.printA();
    }

    public ThreadA(Service service) {
        super();
        this.service = service;
    }
}


