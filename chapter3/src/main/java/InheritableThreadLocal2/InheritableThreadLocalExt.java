package InheritableThreadLocal2;

import java.util.Date;

public class InheritableThreadLocalExt extends InheritableThreadLocal {
    @Override
    protected Object childValue(Object parentValue) {
        return parentValue + "我在子线程加的~";
    }

    @Override
    protected Object initialValue() {
        return new Date().getTime();
    }
}
