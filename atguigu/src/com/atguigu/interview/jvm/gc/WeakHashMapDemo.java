package com.atguigu.interview.jvm.gc;

import java.util.HashMap;
import java.util.WeakHashMap;
import java.util.concurrent.TimeUnit;

/**
 * @program: Thread
 * @author: onion
 * @create: 2020-10-17 15:38
 *
 * 传统的HashMap就算key==null了，也不会回收键值对。但是如果是WeakHashMap，一旦内存不够用时，且key==null时，会回收这个键值对。
 **/

public class WeakHashMapDemo {
    public static void main(String[] args) {
        myHashmap();
        myWeakHashMap();
    }

    private static void myHashmap() {
        HashMap<Integer, String> map = new HashMap<>();
        Integer key = new Integer(1);
        String value = "HashMap";

        map.put(key, value);
        System.out.println(map);

        key = null;
        System.out.println(map);

        System.gc();
        System.out.println(map + "\t" + map.size());
    }

    private static void myWeakHashMap() {
        WeakHashMap<Integer, String> map = new WeakHashMap<>();
        Integer key = 2;
        String value = "WeakHashMap";
        map.put(key, value);
        System.out.println(map);

        key = null;
        System.out.println(map);

        System.gc();
        System.gc();
        System.gc();
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(map + "\t" + map.size());
    }
}

    