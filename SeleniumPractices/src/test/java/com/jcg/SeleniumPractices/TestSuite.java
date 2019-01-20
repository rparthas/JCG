package com.jcg.SeleniumPractices;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestSuite {

    WebDriver webDriver;

    @Before
    public void setUp(){
        webDriver = new ChromeDriver();
    }

    @BeforeClass
    public static void initialize(){
        System.setProperty("webdriver.chrome.driver","chromedriver");
    }

    @After
    public void tearDown(){
        webDriver.quit();
    }


    @Test
    public void enterGoogleSearchAndViewResults() {
        webDriver.navigate().to("http://www.google.com");
        WebElement searchText = webDriver.findElement(By.cssSelector("input[title=Search]"));
        searchText.sendKeys("Selenium",Keys.ENTER);
        Assert.assertEquals("Selenium - Google Search", webDriver.getTitle());
    }


    @Test
    public void enterGoogleImageSearch() {
        webDriver.navigate().to("http://www.google.com");
        WebElement searchText = webDriver.findElement(By.cssSelector("input[title=Search]"));
        searchText.sendKeys("Selenium",Keys.ENTER);
        WebElement imageSearch = webDriver.findElement(By.xpath("//a[contains(text(), 'Images')]"));
        imageSearch.click();
    }
}
