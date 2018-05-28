package synBlockString2;


public class ThreadA extends Thread {
    private Service service;

    @Override
    public void run() {
        service.b();
    }

    public ThreadA(Service service) {
        super();
        this.service = service;
    }

}
