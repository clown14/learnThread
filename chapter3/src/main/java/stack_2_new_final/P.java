package stack_2_new_final;

public class P {
    private MyStack myStack;

    public P(MyStack myStack) {
        super();
        this.myStack = myStack;
    }

    public void pushService() {
        myStack.push();
    }
}
