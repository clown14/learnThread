package stack_2_old;

public class C_Thread extends Thread {
    private C r;

    @Override
    public void run() {
        while (true) {
            r.popService();
        }
    }

    public C_Thread(C r) {
        super();
        this.r = r;
    }
}
