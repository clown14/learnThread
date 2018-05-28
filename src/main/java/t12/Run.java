package t12;

/*
this.interrupted():测试当前线程是否已经中断
this.isInterrupted():测试线程是否已经中断
 */

public class Run {
    public static void main(String[] args) {
        try {
            MyThread thread = new MyThread();
            thread.start();
            Thread.sleep(1000);
            thread.interrupt();
            //Thread.currentThread().interrupt();
            System.out.println("是否停止了1？ =" + thread.interrupted());
            System.out.println("是否停止了2？ =" + thread.interrupted());
        } catch (InterruptedException e) {
            System.out.println("main catch");
            e.printStackTrace();
        }
        System.out.println("end!");
    }
}
