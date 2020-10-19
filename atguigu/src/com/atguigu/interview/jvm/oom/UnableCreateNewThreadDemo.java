package com.atguigu.interview.jvm.oom;

/**
 * @program: Thread
 * @author: onion
 * @create: 2020-10-18 15:00
 *
 * Exception in thread "main" java.lang.OutOfMemoryError: unable to create new native thread
 **/
 
public class UnableCreateNewThreadDemo {
    public static void main(String[] args) {
        for (int i = 0; ; i++) {
            System.out.println("***********" + i);
            new Thread(() -> {
                try {
                    Thread.sleep(Integer.MAX_VALUE);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }, "" + i).start();
        }
    }
}

    