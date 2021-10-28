package com.xt.se.lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @author xt
 * @Desc
 */
public class LambdaDemo {
    public static void main(String[] args) {
        new Thread(()-> System.out.println("running")).start();
        List<String> list = Arrays.asList("Java", "Python", "Scala");
        Collections.sort(list, Comparator.comparingInt(String::length));
        list.forEach(System.out::println);

        Function<String, Integer> fun = (str) -> str.length();
        System.out.println(fun.apply("zhangsan"));

        Supplier<Student> supplier = () -> new Student("zhangsan", 18, 87);
        System.out.println(supplier.get());

        Consumer<String> consumer = (a) -> System.out.println(a);
        consumer.accept("abc");
    }
}
