package joinLong;

public class Test {
    public static void main(String[] args) {
        try {
            MyThread threadTest = new MyThread();
            threadTest.start();
            threadTest.join(2000);
            System.out.println("  end timer=" + System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
