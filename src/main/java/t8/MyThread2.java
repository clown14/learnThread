package t8;

public class MyThread2 extends Thread {
    @Override
    public void run() {
        try {
            System.out.println("Run2 threadNmae= " +
                    this.currentThread().getName() + " begin" +
                    System.currentTimeMillis());
            Thread.sleep(2000);
            System.out.println("Run2 threadName= " +
                    this.currentThread().getName() + " end" +
                    System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
