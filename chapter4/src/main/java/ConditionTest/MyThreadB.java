package ConditionTest;

public class MyThreadB extends Thread {
    private MyService myService;

    @Override
    public void run() {
        for (int i = 0; i< Integer.MAX_VALUE; i++) {
            myService.get();
        }
    }

    public MyThreadB(MyService myService) {
        super();
        this.myService = myService;
    }
}
