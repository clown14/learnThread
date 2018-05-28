package t9;

public class MyThread1 extends Thread {
    private MyOneList list;

    @Override
    public void run() {
        MyService msRef = new MyService();
        msRef.addServiceMethod(list, "A");
    }

    public MyThread1(MyOneList list) {
        super();
        this.list = list;
    }
}
