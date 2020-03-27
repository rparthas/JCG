package com.jcg.demo;

import java.io.*;
import java.util.Date;


public class PrintWriterDemo {


    final static String filename = "jcgFile.txt";

    public static void main(String[] args) {
        // the standard output as OutputStreamWriter
        PrintWriter printWriter = new PrintWriter(System.out, true);
        printWriter.println("Java Code Geeks");
        int i = 5;
        double k = 10.0;
        printWriter.printf("i = %d and k = %f", i, k);
        // flush the instance pw
        printWriter.flush();
        System.out.println("\n---------------------------------------");

        // write sth in a file (deletes the lines if exist)
        PrintWriter filePrintWriter = null;
        Date date = new Date();
        try {
            filePrintWriter = new PrintWriter(filename);
            i++;
            // write a builtIn object
            filePrintWriter.println(date);
            filePrintWriter.write("Write something in a line. i = " + i);
            System.out.println("Write to the file successfully");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        } finally {
            // always close the output stream
            if (filePrintWriter != null) {
                filePrintWriter.close();
            }
        }

        PrintWriter bufferedFileWriter = null;
        Object obj = System.getProperty("line.separator") + "A new object";
        // write in a file in a newline (no deletion of previous writing)
        try {
            FileWriter fl = new FileWriter(filename, true);
            BufferedWriter br = new BufferedWriter(fl);
            bufferedFileWriter = new PrintWriter(br);

            bufferedFileWriter.println(obj);
            // write the string beginning from the 3rd char until the 8th
            bufferedFileWriter.write("!!!JCG Test!!!", 3, 8);
            System.out.println("Add new lines to the file successfully");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (IOException e) {
            // for FileWriter
            e.printStackTrace();
        } finally {
            // no matter what happen, close the output stream
            if (bufferedFileWriter != null) {
                bufferedFileWriter.close();
            }
        }
    }

}
