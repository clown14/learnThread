package singleton_0;

/**
 * @program: Thread
 * @author: onion
 * @create: 2019-05-29 21:59
 **/
public class MyObject {
    private static MyObject myObject = new MyObject();
    private MyObject() {
    }

    public static MyObject getInstance() {
        return myObject;
    }
}

    