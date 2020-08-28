package com.jcg.testng;


import org.testng.Assert;
import org.testng.annotations.*;

public class AddTest {

    Calculator calculator = null;

    @BeforeClass
    public void setUp() {
        System.out.println("initialize calculator");
        calculator = new Calculator();
    }

    @BeforeSuite
    public void setUpSuite() {
        System.out.println("initialize before suite");
    }

    @Test(groups = {"addgrp"})
    public void addTest() {
        Assert.assertEquals(calculator.add(2, 3), 5);
    }

    @AfterSuite
    public void tearDown() {
        System.out.println("after suite");
    }


}
