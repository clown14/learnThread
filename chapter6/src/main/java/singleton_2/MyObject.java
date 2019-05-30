package singleton_2;

/**
 * @program: Thread
 * @author: onion
 * @create: 2019-05-30 20:36
 **/
public class MyObject {
    private static MyObject myObject;

    private MyObject() {
    }

    public static MyObject getInstance() {
        try {
            if (myObject != null) {

            } else {
                Thread.sleep(6000);
                synchronized (MyObject.class) {
                    //模板在创建对象之前做一些准备性的工作
                    myObject = new MyObject();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return myObject;
    }
}

    