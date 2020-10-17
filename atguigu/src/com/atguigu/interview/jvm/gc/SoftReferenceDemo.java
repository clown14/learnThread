package com.atguigu.interview.jvm.gc;

import java.lang.ref.SoftReference;

/**
 * @program: Thread
 * @author: onion
 * @create: 2020-10-17 15:02
 *
 * 需要用Object.Reference.SoftReference来显式创建。如果内存够，GC的时候不回收。内存不够，则回收。常用于内存敏感的应用，比如高速缓存。
 **/

public class SoftReferenceDemo {
    public static void main(String[] args) {
        //softRef_Memory_Enough();

        softRef_Memory_NotEnough();
    }

    private static void softRef_Memory_NotEnough() {
        Object o1 = new Object();
        SoftReference<Object> softReference = new SoftReference<>(o1);
        System.out.println(o1);
        System.out.println(softReference.get());

        o1 = null;
//        System.gc();

        try {
            byte[] bytes = new byte[30 * 1024 * 1024];
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println(o1);
            System.out.println(softReference.get());
        }
    }

    private static void softRef_Memory_Enough() {
        Object o1 = new Object();
        SoftReference<Object> softReference = new SoftReference<>(o1);
        System.out.println(o1);
        System.out.println(softReference.get());

        o1 = null;
        System.gc();
        System.out.println(o1);
        System.out.println(softReference.get());
    }
}

    