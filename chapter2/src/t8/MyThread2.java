package t8;

public class MyThread2 extends Thread {
    private Task task;

    @Override
    public void run() {
        super.run();
        task.otherMethod();
    }

    public MyThread2(Task task) {
        this.task = task;
    }
}
