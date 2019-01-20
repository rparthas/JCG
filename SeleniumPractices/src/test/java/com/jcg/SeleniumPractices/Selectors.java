package com.jcg.SeleniumPractices;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Selectors {

    WebDriver webDriver;


    @Before
    public void setUp() {
        webDriver = new ChromeDriver();
        webDriver.get("file:///Users/psraja/repo/JCG/SeleniumPractices/src/main/resources/index.html");
    }

    @BeforeClass
    public static void initialize() {
        System.setProperty("webdriver.chrome.driver", "chromedriver");
    }

    @After
    public void tearDown() {
        webDriver.quit();
    }


    @Test
    public void checkButtonText() {
        WebElement clickElement = webDriver.findElement(By.id("click"));
        Assert.assertEquals("Click Me", clickElement.getText());
    }

    @Test
    public void checkListDisplayed() {
        WebElement listElement = webDriver.findElement(By.name("list"));
        Assert.assertTrue(listElement.isDisplayed());
    }

    @Test
    public void checkListFirstItemIsItem1() {
        WebDriverWait webDriverWait = new WebDriverWait(webDriver,10,1000);
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("ol[name='list']>li")));
        WebElement listElement = webDriver.findElement(By.cssSelector("ol[name='list']>li"));
        Assert.assertEquals(listElement.getText(),"Item1");
    }

    @Test
    public void checkListSecondItemIsItem2() {
        WebDriverWait webDriverWait = new WebDriverWait(webDriver,10);
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ol[@name='list']/li[2]")));
        WebElement listElement = webDriver.findElement(By.xpath("//ol[@name='list']/li[2]"));
        Assert.assertEquals(listElement.getText(),"Item2");
    }
}
