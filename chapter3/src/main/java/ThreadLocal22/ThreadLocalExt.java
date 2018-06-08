package ThreadLocal22;

public class ThreadLocalExt extends ThreadLocal {
    @Override
    protected Object initialValue() {
        return "我时默认值 第一次get不再为null";
    }
}
