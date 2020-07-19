package com.jcg.demo;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.stream.IntStream;

public class ForkJoinAdd extends RecursiveAction {

    private int start;
    private int end;
    private int[] array;

    public ForkJoinAdd(int start, int end, int[] array) {
        this.start = start;
        this.end = end;
        this.array = array;
    }

    @Override
    protected void compute() {
        int length = (end - start + 1);

        if (length <= 10) {
            for (int i = start; i <= end; i++) {
                array[i] += 1;
            }
            return;
        }

        int mid = length / 2;
        RecursiveAction firstTask = new ForkJoinAdd(start, start + mid - 1, array);
        RecursiveAction secondTask = new ForkJoinAdd(start + mid, end, array);
        firstTask.fork();
        secondTask.invoke();
        firstTask.join();
    }

    public static void main(String[] args) {
        int numSize = 1_000_000;
        final int[] array = new int[numSize];
        IntStream.range(0, array.length).forEach(index -> array[index] = index);
        ForkJoinAdd forkJoinAdd = new ForkJoinAdd(0, numSize - 1, array);
        ForkJoinPool.commonPool().invoke(forkJoinAdd);
    }
}
