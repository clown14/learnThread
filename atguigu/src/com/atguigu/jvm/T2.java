package com.atguigu.jvm;

import java.util.Random;

/**
 * @program: Thread
 * @author: onion
 * @create: 2020-10-02 15:02
 **/

public class T2 {
    public static void main(String[] args) {
//        System.out.println(Runtime.getRuntime().availableProcessors());
//        //返回 Java虚拟机试图使用的最大内存量。物理内存的1/4（-Xmx）
//        long maxMemory = Runtime.getRuntime().maxMemory() ;
//        //返回 Java虚拟机中的内存总量(初始值)。物理内存的1/64（-Xms）
//        long totalMemory = Runtime.getRuntime().totalMemory() ;
//        System.out.println("-Xmx:MAX_MEMORY =" + maxMemory +"(字节)、" + (maxMemory / (double)1024 / 1024) + "MB");
//        System.out.println("-Xms:DEFALUT_MEMORY = " + totalMemory + " (字节)、" + (totalMemory / (double)1024 / 1024) + "MB");
        String str = "atguigu";
        //Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
        while (true) {
            str+=str+new Random().nextInt(88888888)+new Random().nextInt(999999999) ;

        }
    }
}

    