package test2;

public class ThreadB extends Thread {
    private MyObject object;

    @Override
    public void run() {
        super.run();
        object.speedPrintString();
    }

    public ThreadB(MyObject object) {
        super();
        this.object = object;
    }
}
