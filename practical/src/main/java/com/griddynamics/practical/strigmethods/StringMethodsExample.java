package com.griddynamics.practical.strigmethods;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StringMethodsExample {
    public static void main(String[] args) {
        //=== String.join() === since Java 8
        String separator = "+";
        List<String> elements = Arrays.asList("Adam", "Peter", "Alex");
        System.out.println(
                String.join(separator, elements)
        );
        //varargs
        System.out.println(
                String.join(separator, "Adam", "Peter", "Paul")
        );
        // output:
        // Adam+Peter+Alex
        // Adam+Peter+Paul

        // ===stringValue.chars() & stringValue.codePoints() === since Java 9
        String supplString = new String( Character.toChars(0x1F600) );
        supplString.chars()
                .forEach(System.out::println);     //prints: 55357 56832
        supplString.chars()
                .forEach(c -> System.out.println((char)c)); //prints: ? ?
        supplString.chars()
                .forEach(c -> System.out.println(Character.toChars(c))); //prints: ? ?

        supplString.codePoints()
                .forEach(System.out::println);          //prints: 128512
        supplString.codePoints()
                .forEach(c -> System.out.println((char)c));  //prints:  (took U+F600)
        supplString.codePoints()
                .forEach(c -> System.out.println(Character.toChars(c)));//prints: 😀

        //=== stringValue.lines() === (Since Java 11)
        String block = """
                first medium line
                second longer longer line
                shorter line""";
        Stream<String> lines = block.lines();
        lines.forEach(line -> System.out.println(line.length()));
        // output:
        // 17
        // 25
        // 12

        //=== stringValue.repeat() === (Since Java 11)
        String smile = new String( Character.toChars(0x1F600)); //😀
        String smileMore = smile.repeat(15);
        System.out.println(smileMore);
        // output: 😀😀😀😀😀😀😀😀😀😀😀😀😀😀😀


        String variableWithSpaces = "  Space remove  ";
        System.out.println(variableWithSpaces+"d");
        System.out.println(variableWithSpaces.strip()+"d");
        System.out.println(variableWithSpaces.stripLeading()+"d");
        System.out.println(variableWithSpaces.stripTrailing()+"d");
        // Space remove  d
        //Space removed
        //Space remove  d
        // Space removed

        //=== stringValue.transform() and stringValue.intend() === (Since Java 12)
        String value = "some text";
        String transformed = value.transform(v -> "+" + v.indent(5));
        System.out.println(transformed); //+     some text
    }
}
