package t13;

public class MyThread extends Thread {
    @Override
    public void run() {
        super.run();
        for (int i=0; i<250000; i++) {
            if (this.isInterrupted()) {
                System.out.println("已经是停止状态了！我要退出了");
                break;
            }
            System.out.println("i=" + (i + 1));
        }
    }
}
