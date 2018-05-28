package runMethodUseStopMethod;
/*
调用stop()方法时会抛出java.lang.ThreadDeath异常，但在通常情况下，此异常不需要显示地捕捉。
 */
public class Run {
    public static void main(String[] args) {
        MyThread thread = new MyThread();
        thread.start();
    }
}
