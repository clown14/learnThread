package singleton_8;


/**
 * @program: Thread
 * @author: onion
 * @create: 2019-05-30 21:43
 **/
public class MyObject {
    private static MyObject instance = null;

    private MyObject() {
    }

    static{
        instance = new MyObject();
    }

    public static MyObject getInstance() {
        return instance;
    }
}



    