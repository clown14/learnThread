package t12;
/*
interrupted()方法具有清除状态的功能，所以第2次调用interrupted()返回的值是false
 */
public class Run2 {
    public static void main(String[] args) {
        Thread.currentThread().interrupt();
        System.out.println("是否停止了1 =" + Thread.interrupted());
        System.out.println("是否停止了2 =" + Thread.interrupted());
        System.out.println("end!");
    }
}
