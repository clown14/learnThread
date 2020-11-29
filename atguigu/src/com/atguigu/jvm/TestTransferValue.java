package com.atguigu.jvm;

class Person {
    private String name;

    public Person(String abc) {
        this.name = abc;
    }

    public void setPersonName(String name) {
        this.name = name;
    }

    public String getPersonName() {
        return name;
    }
}
/**
 * @program: Thread
 * @author: onion
 * @create: 2020-10-02 14:04
 *
 * main方法里str指向abc，字符串常量池里没有xxx要新建改指向。
 **/

public class TestTransferValue {

    public static void main(String[] args) {
        TestTransferValue test = new TestTransferValue();
        int age=20;
        test.changeValue1(age);
        System.out.println("age------" + age);

        Person person = new Person("abc");
        test.changeValue2(person);
        System.out.println("personName-----" + person.getPersonName());

        String str = "abc";
        test.changeValue3(str);
        System.out.println("String--------" + str);
    }

    private void changeValue3(String str) {
        str = "xxx";
    }

    private void changeValue2(Person person) {
        person.setPersonName("xxx");
    }

    private void changeValue1(int age) {
        age = 30;
    }

}

    