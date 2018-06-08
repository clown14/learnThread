package p_r_test;

public class ThreadC extends Thread {
    private C r;

    @Override
    public void run() {
        while (true) {
            r.getValue();
        }
    }

    public ThreadC(C r) {
        super();
        this.r = r;
    }
}
