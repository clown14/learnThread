package ConditionTestMoreMethod;

public class Run {
    public static void main(String[] args) throws InterruptedException {
        MyService service = new MyService();
        ThreadA a = new ThreadA(service);
        a.setName("A");
        a.start();
        ThreadA aa = new ThreadA(service);
        aa.setName("AA");
        aa.start();
        Thread.sleep(100);
        ThreadB b = new ThreadB(service);
        b.setName("B");
        b.start();
        ThreadB bb = new ThreadB(service);
        bb.setName("BB");
        bb.start();
    }
}
