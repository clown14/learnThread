package stack_1;

public class P_Thread extends Thread {
    private P p;

    @Override
    public void run() {
        while (true) {
            p.pushService();
        }
    }

    public P_Thread(P p) {
        super();
        this.p = p;
    }
}
