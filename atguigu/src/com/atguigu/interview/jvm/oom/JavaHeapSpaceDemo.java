package com.atguigu.interview.jvm.oom;

import java.util.Random;

/**
 * @program: Thread
 * @author: onion
 * @create: 2020-10-17 16:38
 *
 * Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
 **/

public class JavaHeapSpaceDemo {
    public static void main(String[] args) {
        String str = "atguigu";

        while (true) {
            str += str + new Random().nextInt(1111111) + new Random().nextInt(2222222);
            str.intern();
        }
    }
}

    