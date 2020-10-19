package com.atguigu.interview.jvm.oom;

/**
 * @program: Thread
 * @author: onion
 * @create: 2020-10-17 16:28
 **/

public class StackOverflowErrorDemo {
    public static void main(String[] args) {
        stackOverflowError();
    }

    private static void stackOverflowError() {
        stackOverflowError();
    }
}

    