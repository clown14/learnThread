package singleton_0;

/**
 * @program: Thread
 * @author: onion
 * @create: 2019-05-30 20:16
 **/
public class Run {
    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();
        MyThread t3 = new MyThread();
        t1.start();
        t2.start();
        t3.start();
    }
}

    