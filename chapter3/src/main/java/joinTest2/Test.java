package joinTest2;

public class Test {
    public static void main(String[] args) {
        try {
            MyThread threadTest = new MyThread();
            threadTest.start();
            threadTest.join();
            System.out.println("我想当threadTest执行完后再执行，我做到了");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
