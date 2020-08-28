package com.jcg.testng;


import org.testng.Assert;
import org.testng.annotations.*;

@Test
public class CalculatorAttributeTest {

    Calculator calculator = new Calculator();


    @Test
    public void addTest() {
        Assert.assertEquals(calculator.add(4, 3), 6);
    }

    @Test(dependsOnMethods = {"addTest"})
    public void subtractTest() {
        Assert.assertEquals(calculator.subtract(4, 3), 1);
    }

    @Test(enabled = false)
    public void multiplyTest() {
        Assert.assertEquals(calculator.multiply(4, 3), 12);
    }


}
