package singleton_8;

import singleton_7_1.MyObject;

/**
 * @program: Thread
 * @author: onion
 * @create: 2019-05-30 21:45
 **/
public class MyThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(MyObject.getInstance().hashCode());
        }
    }
}

    