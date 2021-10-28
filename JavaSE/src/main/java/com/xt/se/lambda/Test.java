package com.xt.se.lambda;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @author xt
 * @Desc 方法引用
 */
public class Test {
    static String test() {
        System.out.println("test...");
        return "test";
    }

    public String put () {
        System.out.println("put...");
        return "put";
    }

    public void show() {
        System.out.println("show");
    }

    public Test() {
    }

    private Integer age;

    public Test(Integer age) {
        this.age = age;
        System.out.println("调用有参构造方法");
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public static void main(String[] args) {
        Supplier<String> supplier = Test::test;
        System.out.println(supplier.get());
        Supplier<String> supplier2 = new Test()::put;
        System.out.println(supplier2.get());
        Consumer<Test> consumer = Test::show;
        consumer.accept(new Test());

        Supplier<Student> sup = Student::new;
        System.out.println(sup.get());

        Function<Integer, Test> fun = Test::new;
        System.out.println(fun.apply(18));
    }
}
