package com.atguigu.interview.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @program: Thread
 * @author: onion
 * @create: 2020-10-10 15:32
 *
 * 不需要关心什么时候需要阻塞线程，什么时候需要唤醒线程
 **/

public class BlockingQueueDemo {
    public static void main(String[] args) throws Exception{
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);

        addAndRemove(blockingQueue);
        System.out.println();
        offerAndPoll(blockingQueue);
        System.out.println();
        putAndTake(blockingQueue);
        System.out.println();
        outOfTime(blockingQueue);
    }

    private static void outOfTime(BlockingQueue<String> blockingQueue) throws InterruptedException {
        System.out.println(blockingQueue.offer("a",2L, TimeUnit.SECONDS));
        System.out.println(blockingQueue.offer("a",2L, TimeUnit.SECONDS));
        System.out.println(blockingQueue.offer("a",2L, TimeUnit.SECONDS));
        System.out.println(blockingQueue.offer("a",2L, TimeUnit.SECONDS));
    }

    private static void putAndTake(BlockingQueue<String> blockingQueue) throws InterruptedException {
        blockingQueue.put("a");
        blockingQueue.put("b");
        blockingQueue.put("c");
        //blockingQueue.put("d");
        //System.out.println(blockingQueue.take());
        System.out.println(blockingQueue.take());
        System.out.println(blockingQueue.take());
        System.out.println(blockingQueue.take());
    }

    private static void offerAndPoll(BlockingQueue<String> blockingQueue) {
        System.out.println(blockingQueue.offer("a"));
        System.out.println(blockingQueue.offer("b"));
        System.out.println(blockingQueue.offer("c"));
        System.out.println(blockingQueue.offer("e"));
        System.out.println(blockingQueue.peek());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
    }

    public static void addAndRemove(BlockingQueue<String> blockingQueue) {
        System.out.println(blockingQueue.add("a"));
        System.out.println(blockingQueue.add("b"));
        System.out.println(blockingQueue.add("c"));

        //Exception in thread "main" java.lang.IllegalStateException: Queue full
        //System.out.println(blockingQueue.add("x"));
        System.out.println(blockingQueue.element());

        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());


        //Exception in thread "main" java.util.NoSuchElementException
        //System.out.println(blockingQueue.remove());
    }
}

    