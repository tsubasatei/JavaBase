package com.xt.se.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author xt
 * @Desc
 */
public class StreamDemo {
    public static void main(String[] args) {
        // stream 生成操作
//        gen1();
//        gen2();
//        gen3();
//        gen4();
//        gen5();

        // 中间操作
        Arrays.asList(1, 2, 3, 4, 5).stream().filter(x -> x % 2 == 0).forEach(System.out::println);

        // 求出结果中所有的偶数和
        int sum = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9).stream().filter(x -> x % 2 == 0).mapToInt(x -> x).sum();
        System.out.println(sum);

        // 求集合中的最大/小值
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);
        Optional<Integer> max = list.stream().max(Integer::compareTo);
        System.out.println(max.get());
        Optional<Integer> min = list.stream().min(Integer::compareTo);
        System.out.println(min.get());
        Optional<Integer> any = list.stream().filter(x -> x % 2 == 0).findAny();
        System.out.println(any.get());
        Optional<Integer> first = list.stream().filter(x -> x % 2 == 0).findFirst();
        System.out.println(first.get());

        Optional<Integer> first1 = list.stream().sorted().findFirst();
        System.out.println(first1.get());

        Optional<Integer> first2 = list.stream().sorted((a, b) -> b - a).findFirst();
        System.out.println(first2.get());
        System.out.println("---------------");
        list.stream().filter(x -> x % 2 == 0).collect(Collectors.toList()).forEach(System.out::println);
        System.out.println("---------------");
        Arrays.asList(1, 2, 3, 3, 4, 4, 4, 5, 2).stream().distinct().forEach(System.out::println);
        System.out.println("---------------");
        Arrays.asList(1, 2, 3, 3, 4, 4, 4, 5, 2).stream().collect(Collectors.toSet()).forEach(System.out::println);
        System.out.println("-------------------");
        Stream.iterate(1, x -> x + 1).skip(20).limit(10).forEach(System.out::println);

        String str = "11,22,33,44,55";
        System.out.println(Stream.of(str.split(",")).mapToInt(x -> Integer.valueOf(x)).sum());
        System.out.println(Stream.of(str.split(",")).mapToInt(Integer::valueOf).sum());
        System.out.println(Stream.of(str.split(",")).map(x -> Integer.valueOf(x)).mapToInt(x->x).sum());

        String str2 = "java,scala,python";
        Stream.of(str2.split(",")).map(x->new Person(x)).forEach(System.out::println);
        System.out.println("-------------");
        Stream.of(str2.split(",")).map(Person::new).forEach(System.out::println);
        Stream.of(str2.split(",")).map(Person::build).forEach(System.out::println);

        System.out.println(Stream.of(str.split(",")).peek(System.out::println).mapToInt(x -> Integer.valueOf(x)).sum());
        System.out.println(list.stream().allMatch(x -> x % 2 == 0));
    }

    private static void gen5() {
        String str = "abcdefg";
        IntStream intStream = str.chars();
        intStream.forEach(System.out::println);
    }

    private static void gen4() {
        Stream<Integer> stream = Stream.iterate(1, x -> x + 1);
        stream.limit(10).forEach(System.out::println);
    }

    private static void gen3() {
        Stream<Integer> stream = Stream.generate(() -> 1);
        stream.limit(10).forEach(System.out::println);
    }

    private static void gen2() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4);
        Stream<Integer> stream = list.stream();
        stream.forEach(System.out::println);
    }

    private static void gen1() {
        String[] strs = {"a", "b", "c", "d"};
        Stream<String> strs1 = Stream.of(strs);
        strs1.forEach(System.out::println);
    }
}
