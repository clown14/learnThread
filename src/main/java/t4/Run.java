package t4;

import t3.MyThread;

public class Run {
    public static void main(String[] args) {
        t4.MyThread mythread = new t4.MyThread();
        Thread a = new Thread(mythread,"A");
        Thread b = new Thread(mythread,"B");
        Thread c = new Thread(mythread,"C");
        Thread d = new Thread(mythread,"D");
        Thread e = new Thread(mythread,"E");
        a.start();
        b.start();
        c.start();
        d.start();
        e.start();
    }
}
