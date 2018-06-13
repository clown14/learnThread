package tryLockTest;

public class Run {
    public static void main(String[] args) {
        final MyService service = new MyService();
        Runnable runnableRef=new Runnable() {
            @Override
            public void run() {
                service.waitMehtod();
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
