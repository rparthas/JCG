package com.jcg.testng;


import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SubtractTest {

    Calculator calculator;

    @BeforeClass
    public void setUp() {
        System.out.println("initialize calculator");
        calculator = new Calculator();
    }

    @Test(groups = {"subgrp"})
    public void subtractTest() {
        Assert.assertEquals(calculator.subtract(4, 3), 1);
    }


}
