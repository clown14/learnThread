package singleton_7;

/**
 * @program: Thread
 * @author: onion
 * @create: 2019-05-30 21:26
 **/
public class MyObject {
    //内部类方式
    private static class MyObjectHandler {
        private static MyObject myObject = new MyObject();
    }

    private MyObject() {
    }

    public static MyObject getInstance() {
        return MyObjectHandler.myObject;
    }
}

    