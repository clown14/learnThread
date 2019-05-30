package singleton_1;

/**
 * @program: Thread
 * @author: onion
 * @create: 2019-05-30 20:28
 **/
public class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println(MyObject.getInstance().hashCode());
    }
}

    