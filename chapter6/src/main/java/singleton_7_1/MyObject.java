package singleton_7_1;

import java.io.ObjectStreamException;
import java.io.Serializable;

/**
 * @program: Thread
 * @author: onion
 * @create: 2019-05-30 21:31
 **/
public class MyObject implements Serializable {
    private static final long serialVersionUID = 888L;

    //内部类方式
    private static class MyObjectHandler {
        private static final MyObject myObject = new MyObject();
    }

    private MyObject() {
    }

    public static MyObject getInstance() {
        return MyObjectHandler.myObject;
    }

    protected Object readResolve()throws ObjectStreamException {
        System.out.println("调用了read Resolve方法");
        return MyObjectHandler.myObject;
    }
}

    