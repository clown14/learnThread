package awaitUntilTest;

public class Run {
    public static void main(String[] args) {
        Service service = new Service();
        MyThreadA myThreadA = new MyThreadA(service);
        myThreadA.start();
    }
}
