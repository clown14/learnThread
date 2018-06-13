package tryLock_param;

public class Run2 {
    public static void main(String[] args) {
        final MyService service = new MyService();
        Runnable runnableRef=new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() +
                        "调用waitMehtod时间：" + System.currentTimeMillis());
                service.waitMethod();
            }
        };
        Thread threadA = new Thread(runnableRef);
        threadA.setName("A");
        threadA.start();
        Thread threadB = new Thread(runnableRef);
        threadB.setName("B");
        threadB.start();
    }
}
