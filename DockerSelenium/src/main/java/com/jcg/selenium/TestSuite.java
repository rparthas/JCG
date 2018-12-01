package com.jcg.selenium;

import org.junit.Test;
import org.junit.experimental.ParallelComputer;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;


public class TestSuite {
    @Test
    public void test() {
        Class[] cls={GoogleSearchTest.class };
        Result result = JUnitCore.runClasses(new ParallelComputer(true, true), cls);
        System.out.println(result.wasSuccessful());
    }
}
