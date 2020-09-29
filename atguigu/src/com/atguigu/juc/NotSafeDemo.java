package com.atguigu.juc;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @program: Thread
 * @author: onion
 * @create: 2020-09-28 15:48
 *
 * 4.1 故障现象（并发修改异常）
 *  java.util.ConcurrentModificationException
 * 4.2导致原因
 *  多线程并发，资源未加锁
 * 4.3解决方法
 *  1.Vector是线程安全的，加了锁
 *  2.Collections.synchronizedList(new ArrayList());
 *  3.new CopyOnWriteArrayList(); （写时复制）
 *      CopyOnWrite容器即写时复制的容器。往一个容器添加元素的时候，不直接往当前容器Object[]添加，而是先将当前容器Object[]进行Copy，
 *      复制出一个新的容器Object[] newElements，然后向新的容器Object[] newElements里添加元素。添加元素后，
 *      再将原容器的引用指向新的容器setArray(newElements)。这样做的好处是可以对CopyOnWrite容器进行并发的读，
 *      而不需要加锁，因为当前容器不会添加任何元素。所以CopyOnWrite容器也是一种读写分离的思想，读和写不同的容器。
 * 4.4优化建议（同样的错误不犯第二次）
 *  高并发下推荐使用juc里的
 * 4.5常用集合相对的安全的集合
 *  HashMap -> ConcurrentHashMap
 *  HashSet -> CopyOnWriteArraySet
 *  ArrayList -> CopyOnWriteArrayList
 **/

public class NotSafeDemo {
    public static void main(String[] args) {
        mapNotSafe();
    }

    public static void mapNotSafe() {
        //        Map<String,String> map = new HashMap<>();
        Map<String,String> map = new ConcurrentHashMap<>();

        for (int i = 1; i <= 30; i++) {
            new Thread(()->{
                map.put(Thread.currentThread().getName(), UUID.randomUUID().toString().substring(0, 8));
                System.out.println(map);
            },String.valueOf(i)).start();
        }
    }

    public static void setNotSafe() {
        //        Set<String> set = new HashSet<>();
        Set<String> set = new ConcurrentSkipListSet<>();

        for (int i = 1; i <= 30; i++) {
            new Thread(()->{
                set.add(UUID.randomUUID().toString().substring(0, 8));
                System.out.println(set);
            },String.valueOf(i)).start();
        }
    }

    public static void listNotSafe() {
//        List<String> list = new ArrayList<>();
//        List<String> list = new Vector<>();
//        List<String> list = Collections.synchronizedList(new ArrayList<>());
        List<String> list = new CopyOnWriteArrayList<>();

        for (int i = 1; i <= 30; i++) {
            new Thread(()->{
                list.add(UUID.randomUUID().toString().substring(0, 8));
                System.out.println(list);
            },String.valueOf(i)).start();
        }
    }
}

    