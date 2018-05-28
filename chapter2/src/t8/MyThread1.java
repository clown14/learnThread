package t8;

public class MyThread1 extends Thread {
    private Task task;

    @Override
    public void run() {
        super.run();
        task.doLongTimeTask();
    }

    public MyThread1(Task task) {
        this.task = task;
    }
}
