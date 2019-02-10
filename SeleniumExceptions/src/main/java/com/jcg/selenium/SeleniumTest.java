package com.jcg.selenium;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class SeleniumTest {

    WebDriver webDriver;

    public static final String file ="file:///index.html";

    @BeforeClass
    public static void setUp() {
        System.setProperty("webdriver.chrome.driver", "chromedriver");
    }

    @Before
    public void initializeDriver() {
        ChromeOptions options = new ChromeOptions();
//        options.setCapability(CapabilityType.UNHANDLED_PROMPT_BEHAVIOUR,"Yes");
        webDriver = new ChromeDriver(options);
//        webDriver.quit();
    }

    @After
    public void closeDriver() {
        webDriver.quit();
    }

    @Test
    public void testCase1() {
        webDriver.navigate().to("http://www.google.com");
        Assert.assertEquals("Google", webDriver.getTitle());
    }

    @Test
    public void testCase2() {
        webDriver.navigate().to("http://www.google.com");
        webDriver.findElement(By.id("unknown"));
    }

    @Test
    public void testCase3() {
        webDriver.navigate().to("http://www.google.com");
        webDriver.findElement(By.cssSelector("input[type=submit")).click();
    }
    @Test
    public void testCase4(){
        webDriver.navigate().to(file);
        webDriver.findElement(By.cssSelector("input[value='hi'")).sendKeys("hi");
    }

    @Test
    public void testCase5(){
        webDriver.navigate().to(file);
        webDriver.findElement(By.cssSelector("input[value='hidden'")).sendKeys("hi");
    }

    @Test
    public void testCase6(){
        webDriver.navigate().to(file);
        webDriver.switchTo().alert().dismiss();
        String val = webDriver.findElement(By.id("attr")).getAttribute("custom");
    }

    @Test
    public void testCase7(){
        webDriver.navigate().to(file);
        Select select = new Select(webDriver.findElement(By.id("attr")));
        select.selectByIndex(0);
    }

    @Test
    public void testCase8(){
        webDriver.navigate().to(file);
        webDriver.manage().deleteCookieNamed("test");
    }
}
