package setNewPropertiesLockOne;

public class ThreadB extends Thread {
    private Service service;
    private Userinfo userinfo;

    @Override
    public void run() {
        service.serviceMethodA(userinfo);
    }

    public ThreadB(Service service, Userinfo userinfo) {
        super();
        this.service = service;
        this.userinfo = userinfo;
    }
}
