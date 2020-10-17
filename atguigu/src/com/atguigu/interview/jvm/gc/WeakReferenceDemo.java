package com.atguigu.interview.jvm.gc;

import java.lang.ref.WeakReference;

/**
 * @program: Thread
 * @author: onion
 * @create: 2020-10-17 15:15
 *
 * 需要用Object.Reference.WeakReference来显示创建。无论内存够不够，GC的时候都回收，也可以用在高速缓存上。
 **/

public class WeakReferenceDemo {
    public static void main(String[] args) {
        Object o1 = new Object();
        WeakReference<Object> weakReference = new WeakReference(o1);
        System.out.println(o1);
        System.out.println(weakReference.get());

        o1 = null;
        System.gc();
        System.out.println(o1);
        System.out.println(weakReference.get());
    }
}

    