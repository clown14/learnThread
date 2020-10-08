package com.atguigu.interview.thread;


import java.util.concurrent.atomic.AtomicReference;

/**
 * @program: Thread
 * @author: onion
 * @create: 2020-10-06 14:19
 **/

class User {
    String userName;
    int userAge;

    public User(String name, int age) {
        userName = name;
        userAge = age;
    }
}
public class AtomicReferenceDemo {
    public static void main(String[] args) {
        User user1 = new User("Jack",25);
        User user2 = new User("Lucy",21);
        AtomicReference<User> atomicReference = new AtomicReference<>();
        atomicReference.set(user1);
        System.out.println(atomicReference.compareAndSet(user1,user2)); // true
        System.out.println(atomicReference.compareAndSet(user1,user2)); //false
    }
}

