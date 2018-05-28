package StringAndSyn;

public class ThreadA extends Thread {
    private Service service;

    @Override
    public void run() {
        service.print("AA");
    }

    public ThreadA(Service service) {
        super();
        this.service = service;
    }
}


