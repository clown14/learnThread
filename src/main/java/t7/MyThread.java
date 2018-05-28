package t7;

public class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("Run1=" + this.isAlive());
    }
}
