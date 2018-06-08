package TwoThreadTransData;

public class ThreadB extends Thread {
    private MyList list;

    @Override
    public void run() {
        try {
            while (true) {
                if (list.size() == 5) {
                    System.out.println("==5了，线程b要退出了！");
                    throw new InterruptedException();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public ThreadB(MyList list) {
        super();
        this.list = list;
    }
}
