/**
 * wxh Inc.
 * Copyright (c) 2016-2018 All Rights Reserved.
 */
package com.wxh.java8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * jdk1.8特性：访问接口的默认方法
 * Java 8 API同样还提供了很多全新的函数式接口来让工作更加方便，
 * 有一些接口是来自Google Guava库里的，即便你对这些很熟悉了，还是有必要看看这些是如何扩展到lambda上使用的
 * @author wxh
 * @version $Id: AccessIntefaceDefalutMethod.java, v 0.1 2018年2月6日 下午3:49:38 wxh Exp $
 */
public class AccessIntefaceDefalutMethod {

    public static void main(String[] args) {
        Formula formula = new Formula() {
            @Override
            public double calculate(int a) {
                // 直接调用默认方法
                return sqrt(a * 100);
            }
        };

        System.out.println("sqrt: " + formula.sqrt(16));

        // Predicate接口
        Predicate<String> predicate = (s) -> s.length() > 0;
        System.out.println(predicate.test("foo"));

        // Function接口
        Function<String, Integer> toInteger = Integer::valueOf;
        Function<String, String> backToString = toInteger.andThen(String::valueOf);
        System.out.println(backToString.apply("1234"));

        // Supplier接口
        Supplier<Person> personSupplier = Person::new;
        System.out.println(personSupplier.get());

        // Consumer接口
        Consumer<Person> greeter = (p) -> System.out.println("Hello, " + p.firstName);
        greeter.accept(new Person("Luke", "Skywalker"));

        // Comparator接口---只有compare方法，Comparable---compareTo方法
        Comparator<Person> comparator = (p1, p2) -> p1.firstName.compareTo(p2.firstName);
        Person p1 = new Person("John", "Doe");
        Person p2 = new Person("Alice", "Wonderland");
        System.out.println(comparator.compare(p1, p2));

        // Optional接口
        Optional<String> optional = Optional.of("bams");
        System.out.println(optional.isPresent());
        System.out.println(optional.get());

        // Stream接口
        List<String> stringCollection = new ArrayList<>();
        stringCollection.add("ddd2");
        stringCollection.add("aaa2");
        stringCollection.add("bbb1");
        stringCollection.add("aaa1");
        stringCollection.add("bbb3");
        stringCollection.add("ccc");
        stringCollection.add("bbb2");
        stringCollection.add("ddd1");

        // Stream操作：1.Filter过滤
        stringCollection.stream().filter((s) -> s.startsWith("a")).forEach(System.out::println);

        // Stream操作：2.Sort排序
        stringCollection.stream().sorted().filter((s) -> s.startsWith("a"))
            .forEach(System.out::println);

        // Stream操作：3.Map映射
        stringCollection.stream().map(String::toUpperCase).sorted((a, b) -> b.compareTo(a))
            .forEach(System.out::println);

    }
}
