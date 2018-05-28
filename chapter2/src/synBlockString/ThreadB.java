package synBlockString;

public class ThreadB extends Thread {
    private Service service;

    @Override
    public void run() {
        service.setUsernamePassword("b","bb");
    }

    public ThreadB(Service service) {
        super();
        this.service = service;
    }
}
