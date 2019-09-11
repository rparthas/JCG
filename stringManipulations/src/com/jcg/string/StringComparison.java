package com.jcg.string;

public class StringComparison {
    public static void main(String[] args) {

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

        b = "Java is great!";

        if (a.compareTo(b) == 0)
            System.out.println("Strings are equal");
        else
            System.out.println("Strings are NOT equal");

        if (a.contentEquals(new StringBuilder(b)))
            System.out.println("Strings are equal");
        else
            System.out.println("Strings are NOT equal");

    }


}
