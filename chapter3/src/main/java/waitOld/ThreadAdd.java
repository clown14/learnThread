package waitOld;

public class ThreadAdd extends Thread {
    private Add p;

    @Override
    public void run() {
        p.add();
    }

    public ThreadAdd(Add p) {
        super();
        this.p = p;
    }
}
