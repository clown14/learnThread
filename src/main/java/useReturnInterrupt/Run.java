package useReturnInterrupt;
/*
将方法interrupt()与return结合使用也能实现停止线程的效果
不过还是建议使用“抛异常”的方法来实现线程的停止，因为在catch块中还可以将异常向上抛，使线程停止的事件得以传播
 */
public class Run {
    public static void main(String[] args) throws InterruptedException {
        MyThread t = new MyThread();
        t.start();
        Thread.sleep(2000);
        t.interrupt();
    }
}
