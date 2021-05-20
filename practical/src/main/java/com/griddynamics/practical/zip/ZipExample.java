package com.griddynamics.practical.zip;

import com.google.common.collect.Streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ZipExample {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3);
        List<String> numbersNames = List.of("one", "two", "three", "four");

        List<List<Object>> zippedLists1 = IntStream
                .range(0, Math.min(numbers.size(), numbersNames.size()))
                .mapToObj(i -> {
                    List<Object> pair = new ArrayList<>();
                    pair.add(numbers.get(i));
                    pair.add(numbersNames.get(i));
                    return pair;
                })
                .collect(Collectors.toList());


        List<List<Object>> zippedLists2 = Streams.
                zip(numbers.stream(), numbersNames.stream(), (num, name) -> {
                    List<Object> pair = new ArrayList<>();
                    pair.add(num);
                    pair.add(name);
                    return pair;
                }).collect(Collectors.toList());

        System.out.println(zippedLists1);
        System.out.println(zippedLists2);
    }
}
