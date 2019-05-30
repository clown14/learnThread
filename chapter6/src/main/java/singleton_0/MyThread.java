package singleton_0;

/**
 * @program: Thread
 * @author: onion
 * @create: 2019-05-29 22:02
 **/
public class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println(MyObject.getInstance().hashCode());
    }
}

    