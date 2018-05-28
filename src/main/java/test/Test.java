package test;

//getId()的作用是取得线程的唯一标识

public class Test {
    public static void main(String[] args) {
        Thread runThread = Thread.currentThread();
        System.out.println(runThread.getName() + " " +
                runThread.getId());
    }
}
