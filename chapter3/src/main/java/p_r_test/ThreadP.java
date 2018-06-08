package p_r_test;

public class ThreadP extends Thread {
    private P p;

    @Override
    public void run() {
        while (true) {
            p.setValue();
        }
    }

    public ThreadP(P p) {
        super();
        this.p = p;
    }
}
