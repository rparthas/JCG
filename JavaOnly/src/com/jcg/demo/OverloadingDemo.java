package com.jcg.demo;

public class OverloadingDemo {
    public static void main(String[] args) {
        Calculator calculator = new ScientificCalculator();
        System.out.println(calculator.add(2, 3));
        System.out.println(calculator.add(2.0, 3.0));
        System.out.println(calculator.add(2, 3, 4));
        System.out.println(calculator.pow(2.0, 3.0));
    }
}

class Calculator {
    int add(int a, int b) {
        return a + b;
    }

    double add(double a, double b) {
        return a + b;
    }

    int add(int a, int b, int c) {
        return a + b + c;
    }

    double pow(double a, double b) {
        return 0;
    }
}

class ScientificCalculator extends Calculator {
    @Override
    double pow(double a, double b) {
        return Math.pow(a, b);
    }
}

