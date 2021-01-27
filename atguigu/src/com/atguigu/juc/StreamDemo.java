package com.atguigu.juc;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * @program: Thread
 * @author: onion
 * @create: 2020-12-03 20:00
 * <p>
 * Java就是sql，sql就是Java
 * Java.util.function
 * 集合讲的是数据，流讲的是计算
 *
 * Function,Predicate,Consumer,Supplier
 *
 * Stream
 *   1）不会存储元素
 *   2）不会改变源对象，返回一个持有结果的新Stream
 *   3）延迟执行，等到需要结果的时候才执行
 **/

class User {
    private Integer id;
    private String userName;
    private int age;

    public User(Integer id, String userName, int age) {
        this.id = id;
        this.userName = userName;
        this.age = age;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", age=" + age +
                '}';
    }
}

public class StreamDemo {
    public static void main(String[] args) {

        User u1 = new User(11, "a", 23);
        User u2 = new User(12, "b", 24);
        User u3 = new User(13, "c", 22);
        User u4 = new User(14, "d", 28);
        User u5 = new User(16, "f", 26);

        List<User> list = Arrays.asList(u1, u2, u3, u4, u5);

        //输出 学号为偶数
        //    年龄>24
        //    名字大写
        //    倒序
        //    一个名字
        list.stream().filter(u -> u.getId() % 2 == 0)
                .filter(u -> u.getAge() > 24)
                .map(u -> u.getUserName().toUpperCase())
                .sorted(((o1, o2) -> o2.compareTo(o1)))
                .limit(1)
                .forEach(System.out::println);


        //===============================================================================
        //===============================================================================
        //===============================================================================
        Function<String, Integer> function = new Function<String, Integer>() {
            @Override
            public Integer apply(String s) {
                return 1024;
            }
        };

        /*Function<String, Integer> function = s -> {return s.length();};*/
        System.out.println(function.apply("abc")+" 有参数有返回值");

        Predicate<String> predicate = new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return false;
            }
        };

        /*Predicate<String> predicate = s -> s.isEmpty();*/
        System.out.println(predicate.test("aaa")+" 有参数，返回Boolean");

        Consumer<String> consumer = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println("有参，无返回值");
            }
        };

        /*Consumer<String> consumer = s -> System.out.println(s);*/
        consumer.accept("aaa");

        Supplier<String> supplier = new Supplier<String>() {
            @Override
            public String get() {
                return "无参数，有返回值";
            }
        };

        /*Supplier<String> supplier=()->{return "java";};*/
        System.out.println(supplier.get());
    }
}

interface MyInterface {
    public int myInt(int x);

    public String myString(String str);

    public boolean isOK(String str);
}
    