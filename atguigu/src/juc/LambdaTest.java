package juc;

@FunctionalInterface
interface Foo{
//    public void sayHello();

    public int plus(int x, int y);

    default int add(int x, int y) {
        return x + y;
    }

    default int add2(int x, int y) {
        return x + y;
    }

    static int mul(int x, int y) {
        return x*y;
    }

    static int mul2(int x, int y) {
        return x*y;
    }
}
/**
 * @program: Thread
 * @author: onion
 * @create: 2020-09-28 15:29
 *
 * 1 函数式编程
 * 2 拷贝小括号 ， 中间右箭头，落地大括号
 * 3 @FunctionalInterface(使用这个注解的接口一定是函数式接口)
 * 函数式接口里可以有除了唯一方法之外的默认方法
 * 静态方法
 * default static
 **/

public class LambdaTest {
    public static void main(String[] args) {
        Foo foo = (int x,int y) -> {
            return x+y;
        };
        System.out.println(foo.plus(5, 6));
        System.out.println(foo.add(3, 4));
    }
}

    