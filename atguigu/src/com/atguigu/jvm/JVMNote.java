package com.atguigu.jvm;

/**
 * @program: Thread
 * @author: onion
 * @create: 2020-10-01 15:42
 **/

public class JVMNote {
    public static void main(String[] args) throws InterruptedException{
        System.out.println("1111");
        //Exception in thread "main" java.lang.StackOverflowError
        m1();
        System.out.println("2222");
    }

    private static void m1() throws InterruptedException{
        m1();
    }
}

/*
 *output:
 * 111
 * Exception in thread "main" java.lang.StackOverflowError
 * */

    