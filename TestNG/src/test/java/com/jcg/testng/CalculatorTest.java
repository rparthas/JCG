package com.jcg.testng;


import org.testng.Assert;
import org.testng.annotations.*;

@Test
public class CalculatorTest {

    Calculator calculator = new Calculator();

    @BeforeMethod
    public void setUp() {
        System.out.println("initialize calculator");
        calculator = new Calculator();
    }

    @BeforeGroups({"addgrp"})
    public void beforeGroup() {
        System.out.println("Before Group");
    }

    @Test(groups = {"addgrp"})
    public void addTest() {
        Assert.assertEquals(calculator.add(2, 3), 5);
    }

    @Test(groups = {"subgrp"})
    public void subtractTest() {
        Assert.assertEquals(calculator.subtract(4, 3), 1);
    }

    @AfterGroups({"addgrp"})
    public void afterGroup() {
        System.out.println("After Group");
    }

    @AfterMethod
    public void tearDown() {
        System.out.println("teardown calculator");
        calculator = null;
    }

}
