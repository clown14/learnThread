package singleton_1;

/**
 * @program: Thread
 * @author: onion
 * @create: 2019-05-30 20:34
 **/
public class MyObject {
    private static MyObject myObject;
    private MyObject() {

    }

    public static MyObject getInstance() {
        //延迟加载
        if (myObject != null) {

        } else {
            myObject = new MyObject();
        }
        return myObject;
    }
}

    