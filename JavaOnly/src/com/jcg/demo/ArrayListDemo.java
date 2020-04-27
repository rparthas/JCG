package com.jcg.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class ArrayListDemo {

    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        final int endRange = 100000000;
        IntStream.range(0, endRange).forEach(value -> {
            numbers.add(value + 1);
        });

        /*
        100 Runs
        Elapsed ms:773
        Elapsed ms:1029
        Elapsed ms:318

        10 Runs
        Elapsed ms:929
        Elapsed ms:1074
        Elapsed ms:668

        1 Run
        Elapsed ms:351
        Elapsed ms:593
        Elapsed ms:741
         */

        int loop = 100;
        IntStream.range(0, 3).forEach(index -> {
            long diff = 0;
            for (int i = 0; i < loop; i++) {
                StopWatch.start();
                switch (index) {
                    case 0:
                        toObjectArray(numbers);
                        break;
                    case 1:
                        toArray(numbers);
                        break;
                    case 2:
                        fillArray(numbers);
                        break;
                }
                diff += StopWatch.end();
            }
            System.out.println("Elapsed ms:" + (diff / loop));
        });
    }

    private static void fillArray(List<Integer> numbers) {
        int[] intArray = new int[100000000];
        for (int i = 0; i < numbers.size(); i++) {
            intArray[i] = numbers.get(i);
        }
//        System.out.println(intArray.length);
    }

    private static void toArray(List<Integer> numbers) {
        Integer[] dummy = new Integer[0];
        Integer[] ints = numbers.toArray(dummy);
//        System.out.println(ints.length);
//        System.out.println(dummy.length);
    }

    private static void toObjectArray(List<Integer> numbers) {
        Object[] arr = numbers.toArray();
//        System.out.println(arr.length);
    }


    static class StopWatch {
        private static long time = 0;

        static void start() {
            time = System.currentTimeMillis();
        }

        static long end() {
            long diff = System.currentTimeMillis() - time;
            time = 0;
            return diff;
        }
    }

}
