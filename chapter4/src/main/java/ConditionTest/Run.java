package ConditionTest;

public class Run {
    public static void main(String[] args) {

        MyService myService = new MyService();
        MyThreadA a = new MyThreadA(myService);
        a.start();
        MyThreadB b = new MyThreadB(myService);
        b.start();
    }
}
