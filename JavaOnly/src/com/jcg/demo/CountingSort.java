package com.jcg.demo;

public class CountingSort {
    public static void main(String[] args) {
        final int[] input = { 7, 5, 4, 3, 5, 2, 2, 1 };
        final int[] output = new int[input.length];
        final int[] count = new int[8];
        // Count of occurences
        for (int i : input) {
            count[i] += 1;
        }
        // Cumulative sum
        for (int i = 1; i < count.length; i++) {
            count[i] = count[i] + count[i - 1];
        }
        // Shift to identify actual position
        for (int i = count.length - 1; i > 0; i--) {
            count[i] = count[i - 1];
        }
        count[0] = 0;
        // Find each element position
        for (int i : input) {
            output[count[i]] = i;
            count[i] += 1;
        }
        // Print output
        for (int i : output) {
            System.out.println(i);
        }
    }
}