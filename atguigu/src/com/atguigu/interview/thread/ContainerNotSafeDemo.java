package com.atguigu.interview.thread;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @program: Thread
 * @author: onion
 * @create: 2020-10-08 13:42
 *
 * 集合类不安全
 *  ArrayList
 *
 * 使用Vector（ArrayList所有方法加synchronized，太重）。
 * 使用Collections.synchronizedList()转换成线程安全类。
 * 使用java.concurrent.CopyOnWriteArrayList（推荐）。
 *
 * 跟List类似，HashSet和TreeSet都不是线程安全的，与之对应的有CopyOnWriteSet这个线程安全类。这个类底层维护了一个CopyOnWriteArrayList数组。
 * HashSet底层是用HashMap实现的。既然是用HashMap实现的，那HashMap.put()需要传两个参数，而HashSet.add()只传一个参数，
 * 这是为什么？实际上HashSet.add()就是调用的HashMap.put()，只不过Value被写死了，是一个private static final Object对象。
 *
 * HashMap不是线程安全的，Hashtable是线程安全的，但是跟Vector类似，太重量级。所以也有类似CopyOnWriteMap，只不过叫ConcurrentHashMap。
 *
 **/

public class ContainerNotSafeDemo {
    public static void main(String[] args) {
        listNotSafe();
        setNoSafe();
        mapNotSafe();
    }

    private static void mapNotSafe() {
        //Map<String,String> map=new HashMap<>();
        Map<String, String> map = new ConcurrentHashMap<>();
        for (int i = 1; i <= 30; i++) {
            new Thread(() -> {
                map.put(Thread.currentThread().getName(), UUID.randomUUID().toString().substring(0, 8));
                System.out.println(Thread.currentThread().getName() + "\t" + map);
            }, String.valueOf(i)).start();
        }
    }

    private static void setNoSafe() {
        //Set<String> set=new HashSet<>();
        Set<String> set = new CopyOnWriteArraySet<>();
        for (int i = 1; i <= 30; i++) {
            new Thread(() -> {
                set.add(UUID.randomUUID().toString().substring(0, 8));
                System.out.println(Thread.currentThread().getName() + "\t" + set);
            }, String.valueOf(i)).start();
        }
    }

    private static void listNotSafe() {
        //List<String> list=new ArrayList<>();
        List<String> list = new CopyOnWriteArrayList<>();
        for (int i = 1; i <= 30; i++) {
            new Thread(() -> {
                list.add(UUID.randomUUID().toString().substring(0, 8));
                System.out.println(Thread.currentThread().getName() + "\t" + list);
            }, String.valueOf(i)).start();
        }
    }
}

    