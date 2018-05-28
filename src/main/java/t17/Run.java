package t17;
/*
yield方法的作用是放弃当前的CPU资源，将它让给其他的任务去占用CPU执行时间
但放弃的时间不确定，有可能刚放弃，马上又获取CPU时间片。
 */
public class Run {
    public static void main(String[] args) {
        MyThread thread = new MyThread();
        thread.start();
    }
}
