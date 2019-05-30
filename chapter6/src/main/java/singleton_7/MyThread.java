package singleton_7;

/**
 * @program: Thread
 * @author: onion
 * @create: 2019-05-30 21:27
 **/
public class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println(MyObject.getInstance().hashCode());
    }
}

    