package com.atguigu.interview.jvm.oom;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: Thread
 * @author: onion
 * @create: 2020-10-18 14:29
 *
 * Exception in thread "main" java.lang.OutOfMemoryError: GC overhead limit exceeded
 **/

//-Xms10m -Xmx10m -XX:MaxDirectMemorySize=5m -XX:+PrintGCDetails
public class GCOverheadDemo {
    public static void main(String[] args) {
        int i = 0;
        List<String> list = new ArrayList<>();
        try {
            while (true) {
                list.add(String.valueOf(++i).intern());
            }
        } catch (Exception e) {
            System.out.println("************i" + i);
            e.printStackTrace();
            throw e;
        }
    }
}

    