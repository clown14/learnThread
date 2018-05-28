package synBlockString2;


public class ThreadB extends Thread {
    private Service service;

    @Override
    public void run() {
        service.a();
    }

    public ThreadB(Service service) {
        super();
        this.service = service;
    }
}
