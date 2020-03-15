package com.jcg.demo;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

import static java.lang.Character.*;

public class StringDemo {
    public static void main(String[] args) {
        java8();
        java9();
        java11();
        java12();
        java13();
    }

    private static void java13() {
        String html = "<html> \n" +
                "  <body>\n" +
                "    <p>Hello, \\t world from Java %d</p>\n" +
                "  </body>\n" +
                "</html>\n";
        System.out.println(html.formatted(13).stripIndent().translateEscapes());
    }

    private static void java12() {
        String value = "value";
        Optional<String> optionalValue = value.describeConstable();
        System.out.println(optionalValue.orElse("Empty"));

        String indentedValue = value.indent(10);
        System.out.print(indentedValue);

        String resolvedValue = value.resolveConstantDesc(MethodHandles.publicLookup());
        System.out.println(resolvedValue);

        String out = resolvedValue.transform(x -> x.repeat(2));
        System.out.println(out);

    }

    private static void java11() {
        String value = "  ";
        System.out.println(value.isBlank());
        System.out.println(value.isEmpty());
        String fileContent = "This is line1\nThis is line2";
        fileContent.lines().forEach(line -> System.out.println(line));
        System.out.println("-".repeat(20));
        String variableWithSpaces = "  Space remove  ";
        System.out.println(variableWithSpaces + "d");
        System.out.println(variableWithSpaces.strip() + "d");
        System.out.println(variableWithSpaces.stripLeading() + "d");
        System.out.println(variableWithSpaces.stripTrailing() + "d");
    }

    private static void java9() {
        String value = MAX_HIGH_SURROGATE + "" + MAX_SURROGATE;
        value = "Hello World";
        value.chars().forEach(character -> {
            System.out.print(character + " ");
        });
        System.out.println();
        value.codePoints().forEach(character -> {
            System.out.print(character + " ");
        });
        System.out.println();
    }

    private static void java8() {
        String sep = " ";
        System.out.println(String.join(sep, "first", "second", "third"));
        List<String> elements = Arrays.asList(new String[]{"first", "second", "third"});
        System.out.println(String.join(sep, elements));
    }
}
