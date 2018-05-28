package suspend_resume_LockStop;
/*
当程序运行到println()方法内部停止时，同步锁未被释放。
导致PrintStream对象的println()方法一直是暂停状态，并且“锁未释放”
 */
public class Run {
    public static void main(String[] args) {
        try {
            MyThread thread = new MyThread();
            thread.start();
            Thread.sleep(1000);
            thread.suspend();
            System.out.println("main end!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
