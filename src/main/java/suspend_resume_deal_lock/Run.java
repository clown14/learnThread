package suspend_resume_deal_lock;

/*
在使用suspend何resume方法时，如果使用不当，极易造成公共的同步对象的独占，
使得其他线程无法访问公共同步对象
 */

public class Run {
    public static void main(String[] args) {
        try {
            final SynchronizedObject object = new SynchronizedObject();
            Thread thread1 = new Thread() {
                @Override
                public void run() {
                    object.printString();
                }
            };
            thread1.setName("a");
            thread1.start();
            Thread.sleep(1000);
            Thread thread2 = new Thread() {
                @Override
                public void run() {
                    System.out.println("thread2 启动了，但进入不了printString()方法！只打印一个begin");
                    System.out.println("因为printString()方法被a线程锁定并且永远suspend暂停了！");
                    object.printString();
                }
            };
            thread2.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
