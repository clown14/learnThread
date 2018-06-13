package ConditionTest;

public class MyThreadA extends Thread {
    private MyService myService;

    @Override
    public void run() {
        for (int i = 0; i< Integer.MAX_VALUE; i++) {
            myService.set();
        }
    }

    public MyThreadA(MyService myService) {
        super();
        this.myService = myService;
    }
}
