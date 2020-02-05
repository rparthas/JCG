package com.jcg.demo;

import java.io.*;

public class PrintStreamDemo {
    public static void main(String[] args) throws IOException {
        File file = new File("test.txt");
        PrintStream printStream = new PrintStream(file);
        printStream.println("test");

        FileOutputStream fileOutputStream = new FileOutputStream("test.txt");
        printStream = new PrintStream(fileOutputStream, true, "UTF-8");
        printStream.println("test1");

        printStream = new PrintStream("test.txt");
        printStream.println("hi");
        printStream.print((Object) null);
        printStream.append("hello", 0, 3);
        printStream.printf("%nIt is %d year to %s", 1, "2021");
        printStream.println();
        printStream.write("bytes".getBytes());
        printStream.close();
        printStream.println("text not written");
        System.out.println("Error State:" + printStream.checkError());


    }
}

