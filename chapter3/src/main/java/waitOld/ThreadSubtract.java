package waitOld;

public class ThreadSubtract extends Thread {
    private Subtract r;

    @Override
    public void run() {
        r.subtract();
    }

    public ThreadSubtract(Subtract r) {
        super();
        this.r = r;
    }
}
