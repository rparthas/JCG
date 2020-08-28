package com.jcg.testng;


import org.testng.Assert;
import org.testng.annotations.*;

public class MultiplyTest {

    Calculator calculator;

    @BeforeClass
    public void setUp() {
        System.out.println("initialize calculator");
        calculator = new Calculator();
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("Before Test");
    }

    @AfterTest
    public void afterTest() {
        System.out.println("After Test");
    }

}
