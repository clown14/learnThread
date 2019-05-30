package singleton_5;

/**
 * @program: Thread
 * @author: onion
 * @create: 2019-05-30 20:56
 **/
public class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println(MyObject.getInstance().hashCode());
    }
}

    