package stopThrowLock;

/*
使用stop()释放锁将会给数据造成不一致性的结果，如果出现这样的情况，程序处理数据就有可能遭到破坏
由于stop()方法已经被标明为“作废/过期”，显然再功能上又缺陷，所以不建议使用
 */

public class Run {
    public static void main(String[] args) {
        try {
            SynchronizedObject object = new SynchronizedObject();
            MyThread thread = new MyThread(object);
            thread.start();
            Thread.sleep(500);
            thread.stop();
            System.out.println(object.getUsername() + " " +
                    object.getPassword());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
