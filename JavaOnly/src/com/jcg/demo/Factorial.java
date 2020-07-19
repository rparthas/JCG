package com.jcg.demo;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

public class Factorial extends RecursiveTask<Double> {

    private long start;
    private long end;

    public static final long threshold = 5;

    public Factorial(long number) {
        this(1, number);
    }

    private Factorial(long start, long end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Double compute() {
        long length = (end - start + 1);
        if (length <= threshold) {
            return factorial();
        }

        long mid = length / 2;
        Factorial firstTask = new Factorial(start, start + mid);
        Factorial secondTask = new Factorial(start + mid + 1, end);
        firstTask.fork();
        return secondTask.compute() * firstTask.join();

    }

    private Double factorial() {
        Double result = 1.0;
        for (long i = start; i <= end; i++) {
            result *= i;
        }
        return result;
    }


    public static void main(String[] args) {
        ForkJoinTask<Double> task = new Factorial(100);
        System.out.println(ForkJoinPool.commonPool().invoke(task));
    }

}