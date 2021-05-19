package com.griddynamics.practical.teeing;

import lombok.Getter;
import lombok.ToString;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TeeingExample {
    public static void main(String[] args) {
        var twoLists =
                Stream.of("Devoxx", "Voxxed Days", "Code One", "Basel One",
                        "Angular Connect")
                        .collect(Collectors.teeing(
                                // first collector
                                Collectors.filtering(n -> n.contains("xx"), Collectors.toList()),
                                // second collector
                                Collectors.filtering(n -> n.endsWith("One"), Collectors.toList()),
                                // merger
                                (List<String> list1, List<String> list2) -> List.of(list1, list2)
                        ));

        System.out.println(twoLists); // -> [[Devoxx, Voxxed Days], [Code One, Basel One]]

        var result =
                Stream.of(5, 12, 19, 21)
                        .collect(Collectors.teeing(
                                // first collector
                                Collectors.counting(),
                                // second collector
                                Collectors.summingInt(n -> Integer.parseInt(n.toString())),
                                // merger: (count, sum) -> new Result(count, sum);
                                Result::new
                        ));

        System.out.println(result); // -> {count=4, sum=57}

        Map<String, Double> namesAndAvgSalaries = Stream.of(
                new Person("Peter Parker", 7000.0),
                new Person("Peter Bence", 5000.0),
                new Person("John Doe", 8000.0)
        ).collect(
                Collectors.groupingBy(person -> person.getName().split(" ")[0],
                        Collectors.averagingDouble(Person::getSalary)));

        System.out.println(namesAndAvgSalaries);

    }

    @ToString
    private static class Result {
        private long count;
        private int sum;

        public Result(long count, int sum) {
            this.count = count;
            this.sum = sum;
        }
    }

    @ToString
    @Getter
    private static class Person {
        private String name;
        private double salary;

        public Person(String name, double salary) {
            this.name = name;
            this.salary = salary;
        }
    }
}
