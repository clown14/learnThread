package synBlockString;

public class ThreadA extends Thread {
    private Service service;

    @Override
    public void run() {
        service.setUsernamePassword("a","aa");
    }

    public ThreadA(Service service) {
        super();
        this.service = service;
    }

}
