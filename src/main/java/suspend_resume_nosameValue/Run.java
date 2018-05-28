package suspend_resume_nosameValue;
/*
在使用suspend与resume方法时也容易出现因为线程的暂停而导致数据不同步的情况
 */
public class Run {
    public static void main(String[] args) throws InterruptedException {
        final MyObject myObject = new MyObject();
        Thread thread1 = new Thread() {
            @Override
            public void run() {
                myObject.setValue("a", "aa");
            };
        };
        thread1.setName("a");
        thread1.start();
        Thread.sleep(500);
        Thread thread2 = new Thread() {
            @Override
            public void run() {
                myObject.printUsernamePassword();
            };
        };
        thread2.start();

    }
}
