package setNewPropertiesLockOne;

public class ThreadA extends Thread {
    private Service service;
    private Userinfo userinfo;

    @Override
    public void run() {
        service.serviceMethodA(userinfo);
    }

    public ThreadA(Service service, Userinfo userinfo) {
        super();
        this.service = service;
        this.userinfo = userinfo;
    }
}
