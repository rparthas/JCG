package com.jcg.selenium;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.net.MalformedURLException;
import java.net.URL;

public class NameLocatorTests {

    WebDriver webDriver;

    public static final String file = "file:///D:\\git\\JCG\\seleniumNameLocator\\index.html";

    @BeforeClass
    public static void setUp() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
    }

    @Before
    public void initializeDriver() {
        ChromeOptions options = new ChromeOptions();
        webDriver = new ChromeDriver(options);
    }

    @After
    public void closeDriver() {
        webDriver.quit();
    }

    @Test
    public void findElement() throws MalformedURLException, InterruptedException {
        String name = "Jane";
        webDriver.navigate().to(file);
        WebElement webElement = webDriver.findElement(By.name("username"));
        webElement.sendKeys(name);
        webElement.sendKeys(Keys.TAB);
        Assert.assertEquals("Hi " + name + "()",
                webDriver.findElement(By.id("display")).getText());
    }

    @Test
    public void findElements() throws MalformedURLException, InterruptedException {
        String name = "Jane";
        webDriver.navigate().to(file);
        WebElement webElement = webDriver.findElement(By.name("username"));
        webElement.sendKeys(name);
        webElement.sendKeys(Keys.TAB);
        webElement = webDriver.findElements(By.name("sex")).get(0);
        webElement.click();
        webElement.sendKeys(Keys.TAB);
        Assert.assertEquals("Hi " + name + "(Male)",
                webDriver.findElement(By.id("display")).getText());
    }
}