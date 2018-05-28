package t11;

public class MyThread extends Thread {
    @Override
    public void run() {
        super.run();
        for (int i=1;i<500000;i++) {
            System.out.println("i=" + (i + 1));
        }
    }
}
