package t6;

public class Task {
    private String getData1;
    private String getData2;
    public synchronized void doLongTimeTask() {
        try {
            System.out.println("begin task");
            Thread.sleep(3000);
            String privateGetDate1 = "长时间处理任务后从远程返回的值1 threadName=" +
                    Thread.currentThread().getName();
            String privateGetDate2 = "长时间处理任务后从远程返回的值2 threadName=" +
                    Thread.currentThread().getName();
            synchronized (this) {
                getData1 = privateGetDate1;
                getData2 = privateGetDate2;
            }
            System.out.println(getData1);
            System.out.println(getData2);
            System.out.println("end task");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
