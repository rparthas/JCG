package com.jcg.string;

public class StringComparison {
    public static void main(String[] args) {
        method1();
        method2();
    }

    static void method1() {
        String a = "Java is great!";
        String b = "Java Is Great!";

        if (a.equals(b))
            System.out.println("Strings are equal");
        else
            System.out.println("Strings are NOT equal");


        if (a.equalsIgnoreCase(b))
            System.out.println("Strings are equal");
        else
            System.out.println("Strings are NOT equal");


        if (a.compareTo(b) == 0)
            System.out.println("Strings are equal");
        else
            System.out.println("Strings are NOT equal");
        System.out.println("a>b:" + a.compareTo(b));

        if (a.contentEquals(new StringBuilder(b)))
            System.out.println("Strings are equal");
        else
            System.out.println("Strings are NOT equal");
    }

    static void method2() {
        String a = "abc";
        String b = "aBc";
        System.out.println(a.equals("abc"));
        System.out.println(b.equalsIgnoreCase("abc"));
        System.out.println(a.compareTo("abc"));
        System.out.println(b.contentEquals("abc"));


        System.out.println("abc".equals(a));
        System.out.println("abc".equalsIgnoreCase(b));
        System.out.println("abc".compareTo(a));
        System.out.println("abc".contentEquals(b));
    }


}
